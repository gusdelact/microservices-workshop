package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;

import com.example.demo.model.EventLogEntry;
import com.example.demo.model.EventLogEntryRepository;

@SpringBootApplication
@EnableBinding(Sink.class)
public class EventsServiceApplication {

	private static Logger logger = LoggerFactory.getLogger(EventsServiceApplication.class);
	
	
	public static void main(String[] args) {
		SpringApplication.run(EventsServiceApplication.class, args);
	}
	
	@Autowired
	private EventLogEntryRepository repository;
	
	@StreamListener(Sink.INPUT)
	public void loggerSink(EventLogEntry entry) {
		logger.info(entry.toString());
		repository.save(entry);
	}
	

}
