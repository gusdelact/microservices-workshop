package com.example.microservicios.eventlog;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
@EnableBinding(EventLogSource.class)
public class EventLogService {
	
	private Logger log = LoggerFactory.getLogger(EventLogService.class);
	
	
	@Autowired
	private EventLogSource eventLogSource;

	
	public void send(EventLogEntry entry){
		Message<EventLogEntry> message=MessageBuilder.withPayload(entry).build();
		boolean r = eventLogSource.getMessageChannel().send(message);
		log.info("Event published?: " + r);
	}

}
