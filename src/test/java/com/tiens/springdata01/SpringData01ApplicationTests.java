package com.tiens.springdata01;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringData01ApplicationTests {
@Autowired
	DataSource dataSource;
@Autowired
	JdbcTemplate jdbcTemplate;
	@Autowired
	private StringRedisTemplate stringRedisTemplate;

//	@Autowired
//	private RedisTemplate redisTemplate;
	@Test
	public void contextLoads() {
		System.out.println(dataSource.getClass());
		String sql="SELECT center_json_log_yb.json FROM center_json_log_yb where center_json_log_yb.username='b'";
		System.out.println(jdbcTemplate.queryForObject(sql,String.class));

		System.out.println(stringRedisTemplate.opsForValue().get("a"));
	}

}
