package se.lexicon.ecommerce.dto;

// Define simple Java Record for outgoing Category data
public record CategoryResponse(
        // Unique identifier for the category
        Long id,

        // Name of category
        String name
) {}
