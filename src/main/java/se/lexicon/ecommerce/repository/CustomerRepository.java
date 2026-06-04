package se.lexicon.ecommerce.repository;

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

    // Find customers whose email contains a specific keyword (like 'gmail')
    List<Customer> findByEmailContaining(String keyword);

    // Find customers created after a specific date
    List <Customer> findByCreatedAtAfter(Instant date);

    // Find customers created between 2 dates
    List<Customer> findByCreatedAtBetween(Instant start, Instant end);

    // Count how many customers live in a specific city
    long countByAddressCity(String city);

    // Check if an email is already taken
    boolean existsByEmail(String email);



}
