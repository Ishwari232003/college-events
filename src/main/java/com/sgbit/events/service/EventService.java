

package com.sgbit.events.service;

import com.sgbit.events.model.Event;
import com.sgbit.events.model.Category;
import com.sgbit.events.repository.EventRepository;
import com.sgbit.events.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class EventService {

    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    // Get all upcoming events
    public List<Event> getAllUpcomingEvents() {
        return eventRepository.findUpcomingEvents(LocalDate.now());
    }

    // Get upcoming events by category
    public List<Event> getEventsByCategory(String slug) {
        return eventRepository.findUpcomingEventsByCategory(slug, LocalDate.now());
    }

    // Get single event by ID
    public Optional<Event> getEventById(Long id) {
        return eventRepository.findById(id);
    }

    // Add new event (called from admin panel)
    public Event addEvent(Event event) {
        event.setIsNew(true);
        return eventRepository.save(event);
    }

    // Delete event by ID (called from admin panel)
    public void deleteEvent(Long id) {
        eventRepository.deleteById(id);
    }

    // Get all categories
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    // Get category by slug
    public Category getCategoryBySlug(String slug) {
        return categoryRepository.findBySlug(slug);
    }
}
