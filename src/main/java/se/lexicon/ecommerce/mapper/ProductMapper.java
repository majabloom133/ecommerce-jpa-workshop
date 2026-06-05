package se.lexicon.ecommerce.mapper;

import se.lexicon.ecommerce.dto.ProductRequest;
import se.lexicon.ecommerce.dto.ProductResponse;
import se.lexicon.ecommerce.model.entity.Product;
import org.springframework.stereotype.Component;

// Annotate as a Strong Component to allow dependency injection into service layer
@Component
public class ProductMapper {

    // Convert a DB Product entity into a ProductResponse Record
    public ProductResponse toResponse(Product entity) {
        if (entity == null) {
            return null;
        }

        // Handle the nested category entity safely to extract the category name
        String categoryName = null;
        if (entity.getCategory() != null) {
            categoryName = entity.getCategory().getName();
        }

        // Return a new immutable Record using the canonical constructor
        return new ProductResponse(
                entity.getId(),
                entity.getName(),
                entity.getPrice(),
                categoryName
        );
    }

    public Product toEntity(ProductRequest request) {
        if (request == null) {
            return null;
        }

        Product entity = new Product();
        entity.setName(request.name());
        entity.setPrice(request.price());

        return entity;
    }

}
