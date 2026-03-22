package com.sgbit.events.repository;

import com.sgbit.events.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {

    @Query("SELECT e FROM Event e WHERE e.eventDate >= :today ORDER BY e.eventDate ASC")
    List<Event> findUpcomingEvents(@Param("today") LocalDate today);

    @Query("SELECT e FROM Event e WHERE e.category.slug = :slug AND e.eventDate >= :today ORDER BY e.eventDate ASC")
    List<Event> findUpcomingEventsByCategory(@Param("slug") String slug, @Param("today") LocalDate today);
}
