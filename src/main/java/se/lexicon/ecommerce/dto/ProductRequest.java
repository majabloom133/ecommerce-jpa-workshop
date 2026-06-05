package se.lexicon.ecommerce.dto;

// Import validation to ensure text fields are not empty or blank
import jakarta.validation.constraints.NotBlank;
// Import validation to ensure a field is not null
import jakarta.validation.constraints.NotNull;
// import validation to ensure numbers are strictly positive
import jakarta.validation.constraints.Positive;
// Precise monetary calculations
import java.math.BigDecimal;

// Define Java Record for incoming product data
public record ProductRequest(
        // Validate that product name isn't blank
        @NotBlank(message = "Product name is required")
        String name,

        // Validate price isn't null + larger than 0
        @NotNull(message = "Price is required")
        @Positive(message = "Price must be greater than 0")
        BigDecimal price,

        // Validate category ID isn't null while creating/updating product
        @NotNull(message = "Category ID is required")
        Long categoryId
) {}
