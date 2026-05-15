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

    // I'll add fields here in next step

}
