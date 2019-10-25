package com.example.demo;/**
 * Created by jazzyshi on 2019/9/20.
 */

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import redis.clients.jedis.JedisPoolConfig;

/**
 * @ClassName DemoRedisConfig
 * @Description TODO
 * @Author jazzyshi
 * @Date 2019/9/20 14:41
 * @Version 1.0
 **/
@Configuration
public class DemoRedisConfig {


    /**
     * 1.创建JedisPoolConfig对象，再改对象中完成一些连接池配置
     * @return
     */
    @Bean
    @ConfigurationProperties
    public JedisPoolConfig myJedisPoolConfig(){
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();

        System.out.println("默认值："+jedisPoolConfig.getMaxIdle());
        System.out.println("默认值："+jedisPoolConfig.getMinIdle());

        return jedisPoolConfig;
    }

    /**
     * 2.创建JedisConnectionFactory对象。完成redis链接配置
     * @param jedisPoolConfig
     * @return
     */
    @Bean
    @ConfigurationProperties
    public JedisConnectionFactory myJedisConnectionFactory(JedisPoolConfig jedisPoolConfig){
        JedisConnectionFactory factory = new JedisConnectionFactory(jedisPoolConfig);
//        factory.setHostName("172.16.106.7");
//        factory.setPort(7002);
        return factory;
    }

    /**
     * 3.创建redisTempalle:用于执行redis相关的方法
     * @param f
     * @return
     */
    @Bean
    public RedisTemplate<String,Object> redisTemplate(JedisConnectionFactory f){
        RedisTemplate<String,Object> template = new RedisTemplate<>();
        template.setConnectionFactory(f);

        template.setKeySerializer(new StringRedisSerializer());
        template.setValueSerializer(new StringRedisSerializer());
        return template;
    }
}
