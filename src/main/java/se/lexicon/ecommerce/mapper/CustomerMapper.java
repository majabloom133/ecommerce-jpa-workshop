package se.lexicon.ecommerce.mapper;

import se.lexicon.ecommerce.dto.CustomerRequest;
import se.lexicon.ecommerce.dto.CustomerResponse;
import se.lexicon.ecommerce.model.entity.Address;
import se.lexicon.ecommerce.model.entity.Customer;
import org.springframework.stereotype.Component;

// Annotate class as a Spring Component so it can be dependency injected
@Component
public class CustomerMapper {

    // Define method to convert a Customer entity to a CustomerResponse record.
    public CustomerResponse toResponse(Customer customer) {
        // Return null immediately if input customer entity is null
        if (customer == null) {
            // Stop execution and return null to avoid NullPointerException
            return null;
        }

        // Return a new instance of CustomerResponse using its canonical constructor
        return new CustomerResponse(
                // Map entity id field
                customer.getId(),
                // Combine first + last name into full name
                customer.getFirstName() + " " + customer.getLastName(),
                // Map entity email field
                customer.getEmail(),
                // Map entity registration timestamp field
                customer.getCreatedAt(),
                // Map city field from customer's nested address object
                customer.getAddress().getStreet(),
                // Map city field from... - || -
                customer.getAddress().getCity(),
                // Map zip code field from customer's nested... -||-
                customer.getAddress().getZipCode()
        );
    }

    // Define method to convert a customerRequest record into a customer entity
    public Customer toEntity(CustomerRequest request) {
        if (request == null) {
            return null;
        }

        // Create new customer entity and populate its basic info from the request
        Customer customer = new Customer();
        customer.setFirstName(request.firstName());
        customer.setLastName(request.lastName());
        customer.setEmail(request.email());

        // Create a new address entity and populate its fields from the request
        Address address = new Address();
        address.setStreet(request.street());
        address.setCity(request.city());
        address.setZipCode(request.zipCode());

        // Link constructed address object to customer entity
        customer.setAddress(address);

        // Return fully mapped customer entity object
        return customer;
    }
}
