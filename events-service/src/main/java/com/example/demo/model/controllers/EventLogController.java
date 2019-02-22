package com.example.demo.model.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.EventLogEntry;
import com.example.demo.model.EventLogEntryRepository;

@RestController
@RequestMapping(value="event-log",produces="application/json")
public class EventLogController {

	@Autowired
	private EventLogEntryRepository repository;
	
	
	@RequestMapping(value="last-entry")
	public EventLogEntry getLastEntry() {
		List<EventLogEntry> logs=repository.getLastEventLogEntries(PageRequest.of(0, 1));
		return logs.isEmpty() ? null : logs.iterator().next();
	}
	
	
}
