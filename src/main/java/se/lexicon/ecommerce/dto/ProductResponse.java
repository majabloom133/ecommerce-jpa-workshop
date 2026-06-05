package se.lexicon.ecommerce.dto;

import java.math.BigDecimal;

public record ProductResponse(

        // Unique identifier for the product from the database
        Long id,

        // Name of product
        String name,

        // Product price
        BigDecimal price,

        // Flattened view field containing name of assigned category
        String categoryName
) {}

