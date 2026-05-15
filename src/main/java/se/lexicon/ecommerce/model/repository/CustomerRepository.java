package se.lexicon.ecommerce.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import se.lexicon.ecommerce.model.entity.Customer;
import java.time.Instant;
import java.util.List;
import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

    // Find a customer by their unique email
    Optional<Customer> findByEmail(String email);

    // Find customers by last name, ignoring if big or small letters
    List<Customer> findByLastNameIgnoreCase(String lastName);

    // Find customers living in a specific city (JPA jumps to the Address table for this)
    List<Customer> findByAddressCity(String city);

    // Find customers created between 2 dates
    List<Customer> findByCreatedAtBetween(Instant start, Instant end);


}
