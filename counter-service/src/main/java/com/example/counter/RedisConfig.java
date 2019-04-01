package com.example.counter;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.support.atomic.RedisAtomicLong;

@Configuration
public class RedisConfig {

	@Value("counter-service.events-counter.name")
	private String eventsCounterName;
	
	
	@Bean
	public JedisConnectionFactory redisConnectionFactory() {
		return new JedisConnectionFactory();
	}

	@Bean
	public RedisAtomicLong eventsCounter() {
		RedisAtomicLong eventsCounter = new RedisAtomicLong(eventsCounterName, redisConnectionFactory());
		return eventsCounter;
	}
}
