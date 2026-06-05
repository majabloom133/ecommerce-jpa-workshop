package se.lexicon.ecommerce.repository;

import se.lexicon.ecommerce.model.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

// JpaRepository gives all standard CRUD operation (save, delete, findById)
public interface AddressRepository extends JpaRepository<Address, Long> {

        // Find all addresses that belong to a specific zip code
        List<Address> findByZipCode(String zipCode);

        // Find all addresses in a specific city
        List<Address> findByCity(String city);

        // Find addresses by street name using partial matching
        List<Address> findByStreetContaining(String street);

        // Count how many address records have this exakt zip code
        long countByZipCode(String zipCode);

        // Find addresses where the zip code starts with a specific prefix
        List<Address> findByZipCodeStartingWith(String prefix);
}
