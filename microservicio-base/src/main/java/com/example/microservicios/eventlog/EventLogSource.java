package com.example.microservicios.eventlog;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface EventLogSource {
	
	@Output("employeeRegistrationChannel")
	MessageChannel getMessageChannel();
}
