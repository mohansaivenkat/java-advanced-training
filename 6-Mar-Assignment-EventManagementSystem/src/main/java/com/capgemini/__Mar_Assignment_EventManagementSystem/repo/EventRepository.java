package com.capgemini.__Mar_Assignment_EventManagementSystem.repo;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capgemini.__Mar_Assignment_EventManagementSystem.entity.Event;
import com.capgemini.__Mar_Assignment_EventManagementSystem.entity.EventType;

public interface EventRepository extends JpaRepository<Event, Integer> {

    List<Event> findByEventDateAfter(LocalDate date);

    List<Event> findByEventType(EventType eventType);

    List<Event> findByTitleContainingIgnoreCase(String title);

}
