package se.lexicon.ecommerce.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.Instant;

@Entity
@Table(name = "customers")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // Unique ID for each customer
    private Long id;

    // First name - mandatory, max 100 characters
    @Column(nullable = false, length = 100)
    private String firstName;

    // Last name - mandatory, max 100 characters
    @Column(nullable = false, length = 100)
    private String lastName;

    // Email - mandatory, unique and max 150 characters
    @Column(nullable = false, unique = true, length = 150)
    private String email;

    // The timestamp when customer was created
    @Column(nullable = false)
    private Instant createdAt;

    // Unindirectional relation to Address
    // Mandatory FK, cascades save/delete, removes address if disconnected
    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "address_id", nullable = false)
    private Address address;


    // Bidirectional relation to UserProfile (owner side)
    // Cascades save/delete, removes profile if disconnected
    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "profile_id")
    private UserProfile userProfile;

}
