package com.example.eventhello.Services;

import com.example.eventhello.Dto.EventDTO;
import com.example.eventhello.Mapper.EventMapper;
import com.example.eventhello.Repositories.EventRepository;
import com.example.eventhello.entities.Event;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service

public class EventS {

    private final EventMapper eventMapper;
    private final EventRepository eventRepository;

    public EventS(EventMapper eventMapper, EventRepository eventRepository) {
        this.eventMapper = eventMapper;
        this.eventRepository = eventRepository;
    }

//    public EventDTO saveEvent(EventDTO eventDTO) {
//        Event event = eventMapper.toEntity(eventDTO);
//        Event savedEvent = eventRepository.save(event);
//        return eventMapper.toDTO(savedEvent);
//    }
public EventDTO saveEvent(EventDTO eventDTO) {
    // Debug: Check what we receive
    System.out.println("=== RECEIVED DTO ===");
    System.out.println("Title: " + eventDTO.getTitle());
    System.out.println("Description: " + eventDTO.getDescription());
    System.out.println("Price: " + eventDTO.getPrice());
    System.out.println("Date: " + eventDTO.getDate());

    // Convert to entity
    Event event = eventMapper.toEntity(eventDTO);

    // Debug: Check what mapper produced
    System.out.println("=== MAPPED ENTITY ===");
    System.out.println("Title: " + event.getTitle());
    System.out.println("Description: " + event.getDescription());
    System.out.println("Price: " + event.getPrice());
    System.out.println("Date: " + event.getDate());

    // Save
    Event savedEvent = eventRepository.save(event);

    // Debug: Check what was saved
    System.out.println("=== SAVED ENTITY ===");
    System.out.println("ID: " + savedEvent.getId());
    System.out.println("Title: " + savedEvent.getTitle());
    System.out.println("Description: " + savedEvent.getDescription());
    System.out.println("Price: " + savedEvent.getPrice());
    System.out.println("Date: " + savedEvent.getDate());

    return eventMapper.toDTO(savedEvent);
}


    public List<EventDTO> getEvents() {
        List<Event> events = eventRepository.findAll();
        return eventMapper.toDTOs(events);
    }
    public EventDTO updateEvent(EventDTO eventDTO) {
        Event event = eventMapper.toEntity(eventDTO);
        Event savedEvent = eventRepository.save(event);
        return eventMapper.toDTO(savedEvent);
    }
    public void deleteEvent(Long id) {
        eventRepository.deleteById(id);
    }

    public  EventDTO geteventByTitle(String title) {

        Event event = eventRepository.findByTitle(title);

        return eventMapper.toDTO(event);
    }


}

