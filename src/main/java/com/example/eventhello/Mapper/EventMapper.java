package com.example.eventhello.Mapper;

import com.example.eventhello.Dto.EventDTO;
import com.example.eventhello.entities.Event;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EventMapper {
    Event toEntity(EventDTO dto);
    EventDTO toDTO(Event event);
    List<EventDTO> toDTOs(List<Event> events);
}
