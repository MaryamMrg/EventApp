package com.example.eventhello.Services;

import com.example.eventhello.Dto.EventDTO;
import com.example.eventhello.Mapper.EventMapper;
import com.example.eventhello.Repositories.EventRepository;
import com.example.eventhello.entities.Event;
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

    public EventDTO saveEvent(EventDTO eventDTO) {
        Event event = eventMapper.toEntity(eventDTO);
        Event savedEvent = eventRepository.save(event);
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
}
