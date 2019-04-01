package com.example.counter.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.support.atomic.RedisAtomicLong;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="event-counter",produces="application/json")
public class CounterController {
	
	@Autowired
	private RedisAtomicLong eventsCounter;
	
	@RequestMapping(value="number-events")
	public Counter getLastEntry() {
		long number = eventsCounter.get();
		
		Counter counter = new Counter(number);
		return counter;
	}
}
