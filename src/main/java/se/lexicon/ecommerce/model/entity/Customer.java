package se.lexicon.ecommerce.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // Unique ID for each customer
    private Long id;

    // Nullable means an email must be entered.
    // @Column makes sure noone has the same email address
    @Column(unique = true, nullable = false)
    private String email;

    // The date the user joined
    private LocalDate registrationDate;

    // Link this customer to one specific address
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id")
    private Address address;

    // Link this customer to one specific user profile.
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_profile_id")
    private UserProfile userProfile;


}
