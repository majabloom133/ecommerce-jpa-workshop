package se.lexicon.ecommerce.service;

import se.lexicon.ecommerce.dto.CategoryResponse;
import java.util.List;

public interface CategoryService {

    // Create a new category after checking for duplicates
    CategoryResponse create(String name);

    // Return a list of all categories
    List<CategoryResponse> findAll();
}
