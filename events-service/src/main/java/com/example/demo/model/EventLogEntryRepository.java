package com.example.demo.model;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventLogEntryRepository extends CrudRepository<EventLogEntry, Long>{
	
	@Query("SELECT e FROM EventLogEntry e ORDER BY e.createdAt DESC")
	List<EventLogEntry> getLastEventLogEntries(Pageable pageable);

}
