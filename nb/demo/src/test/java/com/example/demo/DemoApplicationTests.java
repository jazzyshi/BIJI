package com.example.demo;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = DemoApplication.class)
public class DemoApplicationTests {

	@Autowired
	HelloServer helloServer;

	@Autowired
	RedisTemplate<String,Object> redisTemplate;


	@Before
	public void insert(){
		this.redisTemplate.opsForValue().set("name","史继卓");
	}

	@Test
	public void contextLoads() {
		String value = (String) redisTemplate.opsForValue().get("name");
		System.out.println("名称为="+value);
	}


}
