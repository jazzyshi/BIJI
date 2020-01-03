package com.jz.bigdata.myinternet.myredis.seckill;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.Transaction;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 代码应该有问题
 */
public class SecKill implements Runnable {

    private String customName;
    private String key;

    public SecKill(String customName,String key){
        this.customName = customName;
        this.key = key;
    }

    @Override
    public void run() {

        try {
            JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
            jedisPoolConfig.setMaxTotal(200);
            jedisPoolConfig.setMaxIdle(100);
            Jedis jedis = new Jedis("172.16.106.6",6379);
            jedis.auth("cloud@hansight.com");
            //通过watch实现redis的incr(原子递增操作)
            jedis.watch(key);
            boolean sucess = false;
            int currentNum;
            while (!sucess){ //可重复抢购直到成功

                currentNum = Integer.parseInt(jedis.get(key));
                if(currentNum > 0) {
                    //开启事务
                    Transaction transaction = jedis.multi();
                    //设置新值，如果key的值被其它连接的客户端修改，那么当前连接的exec命令将执行失败
                    --currentNum;
                    transaction.set(key, String.valueOf(currentNum));
                    List result = transaction.exec();
                    if (null == result || result.size() == 0) {
                        System.out.println(customName+"抢购失败");
                        sucess = false;
                    } else {
                        sucess = true;
                        System.out.println(customName + "抢购成功,剩余" + currentNum);
                    }
                }else {
                    System.out.println("商品售空，活动结束");
                    System.exit(0);
                }
            }
            jedis.unwatch();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {

        ExecutorService executorService = Executors.newFixedThreadPool(8);
        try{
            for(int i = 1; i<=600; i++){
                executorService.submit(new SecKill("顾客"+i,"apple"));
            }
        }finally {
            executorService.shutdown();
        }

    }
}
