package com.example.counter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.support.atomic.RedisAtomicLong;

@Configuration
public class RedisConfig {

	@Value("counter-service.events-counter.name")
	private String eventsCounterName;
	
	
	@Autowired
	private RedisConnectionFactory redisConnectionFactory;
	

	@Bean
	public RedisAtomicLong eventsCounter() {
		RedisAtomicLong eventsCounter = new RedisAtomicLong(eventsCounterName, redisConnectionFactory);
		return eventsCounter;
	}
}
