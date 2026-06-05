package se.lexicon.ecommerce.service;

import se.lexicon.ecommerce.dto.ProductRequest;
import se.lexicon.ecommerce.dto.ProductResponse;
import java.util.List;

// Define service interface for managing product catalog operations
public interface ProductService {

    // Create new product and assign it to cateogry
    ProductResponse create(ProductRequest request);

    // Retrieve all products currently available in the catalog
    List<ProductResponse> findAll();

    // Search and filter products by their name
    List<ProductResponse> searchByName(String name);
}
