package com.sgbit.events.controller;

import com.sgbit.events.model.Event;
import com.sgbit.events.model.Category;
import com.sgbit.events.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class EventController {

    @Autowired
    private EventService eventService;

    @GetMapping("/events")
    public ResponseEntity<List<Event>> getAllEvents() {
        List<Event> events = eventService.getAllUpcomingEvents();
        return ResponseEntity.ok(events);
    }

    @GetMapping("/events/category/{slug}")
    public ResponseEntity<List<Event>> getEventsByCategory(@PathVariable("slug") String slug) {
        List<Event> events = eventService.getEventsByCategory(slug);
        return ResponseEntity.ok(events);
    }

    @GetMapping("/events/{id}")
    public ResponseEntity<Event> getEventById(@PathVariable("id") Long id) {
        Optional<Event> event = eventService.getEventById(id);
        return event.map(ResponseEntity::ok)
                    .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/events")
    public ResponseEntity<Event> addEvent(@RequestBody Event event) {
        Event saved = eventService.addEvent(event);
        return ResponseEntity.ok(saved);
    }

    @DeleteMapping("/events/{id}")
    public ResponseEntity<String> deleteEvent(@PathVariable("id") Long id) {
        eventService.deleteEvent(id);
        return ResponseEntity.ok("Event deleted successfully");
    }

    @GetMapping("/categories")
    public ResponseEntity<List<Category>> getAllCategories() {
        List<Category> categories = eventService.getAllCategories();
        return ResponseEntity.ok(categories);
    }
}
