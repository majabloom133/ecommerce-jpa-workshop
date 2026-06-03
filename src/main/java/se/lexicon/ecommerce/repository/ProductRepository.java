package se.lexicon.ecommerce.repository;

import se.lexicon.ecommerce.model.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.math.BigDecimal;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {
    // Standard CRUD operations for Product entity are inherited here automatically

    // Find products by category name, skip capital letters
    List<Product> findByCategoryNameIgnoreCase(String categoryName);

    // Find products between two price points
    List<Product> findByPriceBetween(BigDecimal start, BigDecimal end);

}
