
package com.sgbit.events.repository;

import com.sgbit.events.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

    // Find category by its slug (e.g. "technical", "cultural")
    Category findBySlug(String slug);
}

