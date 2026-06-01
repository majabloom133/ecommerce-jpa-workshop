package se.lexicon.ecommerce.model.repository;

import se.lexicon.ecommerce.model.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {
    // Standard CRUD operations for Product entity are inherited here automatically
}
