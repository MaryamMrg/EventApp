package com.example.eventhello.Repositories;

import com.example.eventhello.entities.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event, Long> {

    public Event findByTitle(String title);
}
