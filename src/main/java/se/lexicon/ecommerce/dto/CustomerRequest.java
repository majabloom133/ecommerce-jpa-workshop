package se.lexicon.ecommerce.dto;

// Import validation for email addresses,
// validation to ensure text isn't empty,
// validation to set boundaries on text length
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

// Define a Java Record for incoming customer data
public record CustomerRequest(
        // Validate that the first name is not blank
        @NotBlank(message = "First name is required")
        String firstName,

        // Validate that the last name isn't blank either
        @NotBlank(message = "Last name is required")
        String lastName,

        // Validate that email isn't blank
        @NotBlank(message = "Email is required")
        // Validate correct email format
        @Email(message = "Invalid email format")
        String email,

        // Validate that street address isn't blank
        @NotBlank(message = "Street is required")
        String street,

        // Validate that city isn't blank
        @NotBlank(message = "City is required")
        String city,

        // Validate that zip code isn't blank
        @NotBlank(message = "Zip code is required")
        // Validate that zip code length is between 5 and 10 characters
        @Size(min = 5, max = 10, message = "Zip code must be between 5 and 10 characters")
        String zipCode
) {}

