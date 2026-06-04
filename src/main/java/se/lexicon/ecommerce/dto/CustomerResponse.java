package se.lexicon.ecommerce.dto;

// Import timestamp class for creation dates
import java.time.Instant;

public record CustomerResponse(
        // Unique identifier for the customer from the DB
        Long id,
        // Combined first and last name into full name string
        String fullName,
        // Email address of customer
        String email,
        // Timestamp showing when customer was created
        Instant createdAt,
        // Street address of customer
        String street,
        // City of customer
        String city,
        // Zip code of customer
        String zipCode
) {}
