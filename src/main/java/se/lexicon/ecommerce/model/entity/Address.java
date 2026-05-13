package se.lexicon.ecommerce.model.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// Mark this class as DB managed object
@Entity
// Define specific name of DB table
@Table(name = "addresses")
// Lombok: Automatically generate getters, setters, toString etc
@Data
// Lombok: Create constructor with no arguments
@NoArgsConstructor
// Lombok: Create a constructor with all fields as arguments
@AllArgsConstructor
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String street;
    private String city;
    private String zipCode;

    // Fields will go here


}