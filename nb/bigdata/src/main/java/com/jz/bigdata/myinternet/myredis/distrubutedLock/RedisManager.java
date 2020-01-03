package com.jz.bigdata.myinternet.myredis.distrubutedLock;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.Transaction;

import java.util.List;
import java.util.UUID;

/**
 * jedis连接的代码
 */
public class RedisManager {

    private static JedisPool jedisPool;

    static {
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxTotal(2000);
        jedisPoolConfig.setMaxIdle(100);
        jedisPool = new JedisPool(jedisPoolConfig,"172.16.106.6",6379,10000,"cloud@hansight.com");
    }

    public static Jedis getJedis() throws Exception {
        if(null != jedisPool){
            return jedisPool.getResource();
        }
        throw new Exception("jedis pool is not init!!!!");
    }

    /**
     * 获取锁
     * @param key 请求的key
     * @param timeout 请求超时时间
     * @return
     */
    public  String getLock(String key, int timeout){
        try {
            Jedis jedis = RedisManager.getJedis();
            String value = UUID.randomUUID().toString();
            long requestTimeout = System.currentTimeMillis() + timeout;

            while(System.currentTimeMillis() <= requestTimeout){
                if(jedis.setnx(key,value) == 1){
                    jedis.expire(key,timeout);
                    return value; //锁设置成功 redis操作成功
                }
                if(jedis.ttl(key) == -1){//返回key的剩余生存时间。在 Redis 2.8 以前，当 key 不存在，或者 key 没有设置剩余生存时间时，命令都返回 -1 。
                    jedis.expire(key,timeout);
                }

                Thread.sleep(10);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 释放锁
     * @param key
     * @param value
     * @return
     */
    public  boolean releaseLock(String key,String value){
        try {
            Jedis jedis = RedisManager.getJedis();
            while (true){
                jedis.watch(key);
                if(value.equals(jedis.get(key))){
                    Transaction transaction = jedis.multi();
                    transaction.del(key);
                    List<Object> lists = transaction.exec();
                    if(null == lists){
                        continue;
                    }
                    return true;
                }
                jedis.unwatch();
                break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public static void main(String[] args) {
        for(int i=0 ;i<100;i++){
            RedisManager redisManager = new RedisManager();
            new Thread(new Runnable() {
                @Override
                public void run() {

                    String value = redisManager.getLock("apple",2000);
                    if(null != value){
                        System.out.println("获取到锁="+value);
                        //模拟真实业务操作
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }finally {
                            redisManager.releaseLock("apple",value);
                        }
                    }else{
                        System.out.println("获取锁超时。。。");
                    }

                }
            }).start();
        }
    }
}
