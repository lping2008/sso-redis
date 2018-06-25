package com.plin.sso;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.junit4.SpringRunner;



@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisTests {
	
	@Autowired
	RedisTemplate<String, String> redisTemplate;
	
	@Test
	public void redisTestSingle() {
		//Redis 操作视图接口类用的是 ValueOperations，对应的是 Redis String/Value 
		//操作。还有其他的操作视图，ListOperations、SetOperations、ZSetOperations 和 HashOperations 。
		//ValueOperations 插入缓存是可以设置失效时间。
		System.out.println(redisTemplate.hasKey("username"));
		ValueOperations<String, String> ops = redisTemplate.opsForValue();
		ops.set("name", "张三");
		String name = ops.get("name");
		System.out.println(name);
	}
	
	@Test
	public void redisCluster() {
		
	}
}
