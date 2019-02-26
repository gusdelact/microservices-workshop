package com.example.microservicios.eventlog;

public class EventLogEntry {
    
	private String message;
    
	public EventLogEntry() {
	}
	
	public EventLogEntry(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}    
    
}
