package com.example.counter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.data.redis.support.atomic.RedisAtomicLong;

@SpringBootApplication
@EnableBinding(Sink.class)
public class CounterServiceApplication {

	private static Logger logger = LoggerFactory.getLogger(CounterServiceApplication.class);
	
	@Autowired
	private RedisAtomicLong eventsCounter;
	
	public static void main(String[] args) {
		SpringApplication.run(CounterServiceApplication.class, args);
	}

	
	@StreamListener(Sink.INPUT)
	public void loggerSink(Object entry) {
		long events = eventsCounter.incrementAndGet();
		logger.info("Current events number: {}", events);
	}
}
