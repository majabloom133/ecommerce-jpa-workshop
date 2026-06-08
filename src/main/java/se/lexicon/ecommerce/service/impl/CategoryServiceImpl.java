package se.lexicon.ecommerce.service.impl;

import se.lexicon.ecommerce.dto.CategoryResponse;
import se.lexicon.ecommerce.model.entity.Category;
import se.lexicon.ecommerce.repository.CategoryRepository;
import se.lexicon.ecommerce.service.CategoryService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

// Annotate as a Spring Service component to hold business logic
@Service
public class CategoryServiceImpl implements CategoryService {

   // Dependency injection via constructor
    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    @Transactional
    public CategoryResponse create(String name) {
        // Validate that the name input isn't empty or whitespace
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Category name can't be empty");
        }
        // Check for duplicates in the DB, ignoring uppercase/lowercase letters
        if (categoryRepository.existsByNameIgnoreCase(name)) {
            throw new IllegalArgumentException("Category already exists: " + name);
        }

        // Create new Category entity instance, + set fields
        Category category = new Category();
        category.setName(name);

        // Persist the entity to DB
        Category savedCategory = categoryRepository.save(category);

        // Map saved entity fields directly into CategoryResponse record constructor
        return new CategoryResponse(savedCategory.getId(), savedCategory.getName());
    }

    @Override
    @Transactional(readOnly = true)
    public List<CategoryResponse> findAll() {
        // Fetch all categories, stream through them, map to response records, collect into a list
        return categoryRepository.findAll().stream()
                .map(category -> new CategoryResponse(category.getId(), category.getName()))
                .collect(Collectors.toList());
    }

}
