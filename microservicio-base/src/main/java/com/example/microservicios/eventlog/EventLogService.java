package com.example.microservicios.eventlog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
@EnableBinding(EventLogSource.class)
public class EventLogService {
	
	@Autowired
	private EventLogSource eventLogSource;

	
	public void send(EventLogEntry entry){
		Message<EventLogEntry> message=MessageBuilder.withPayload(entry).build();
		eventLogSource.getMessageChannel().send(message);
	}
}
