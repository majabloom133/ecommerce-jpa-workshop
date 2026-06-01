package se.lexicon.ecommerce.model.repository;

import se.lexicon.ecommerce.model.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository // Tells Spring that this interface manages database operations
public interface CategoryRepository extends JpaRepository<Category, Long> {
    // Standard methods like save(), findById(), and delete() are created automatically

}
