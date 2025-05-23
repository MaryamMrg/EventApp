package com.example.eventhello.Controllers;

import com.example.eventhello.Dto.EventDTO;
import com.example.eventhello.Services.EventS;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/event")
public class EventC {
    private final EventS eventS;
    public EventC(EventS eventS) {
        this.eventS = eventS;
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public  EventDTO addEvent(@RequestBody EventDTO eventDTO) {
        return eventS.saveEvent(eventDTO);
    }
    @GetMapping
    public List<EventDTO> getEvents() {
        return eventS.getEvents();
    }
    @PutMapping
    public EventDTO updateEvent(@RequestBody EventDTO eventDTO) {
        return eventS.updateEvent(eventDTO);


    }
    @DeleteMapping("/{id}")
    public void deleteEvent(@PathVariable Long id) {
         eventS.deleteEvent(id);
    }
}
