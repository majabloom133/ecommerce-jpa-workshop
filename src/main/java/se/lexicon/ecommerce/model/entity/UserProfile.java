package se.lexicon.ecommerce.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


// Mark this class as a  database entity
@Entity
// Name table for storing profile info
@Table(name = "user_profiles")
// Use Lombok to handle boilerplate code like getters and setters
@Data
// JPA requires a no-args constructor
@NoArgsConstructor
// Convinient constructor for initializing all fields
@AllArgsConstructor
public class UserProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Nickname is mandatory and max 100 characters
    @Column(nullable = false, length = 100)
    private String nickname;

    // Phone number is mandatory and max 100 characters
    @Column(nullable = false, name = "phone_number", length = 100)
    private String phoneNumber;

    // Bio is optional, but max 500 characters
    @Column(length = 500)
    private String bio;

    // Link back to Customer (Inverse side of bidirectional relationship)
    @OneToOne(mappedBy = "userProfile")
    private Customer customer;

    // I'll add fields here in next step

}
