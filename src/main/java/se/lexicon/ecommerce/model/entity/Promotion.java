package se.lexicon.ecommerce.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDate;

@Entity // Tells JPA this class represent DB table
@Table(name = "promotions") // Names DB table "promotions"
public class Promotion {

    @Id // Marks this field as primary key for table
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Tells DB to automatically increase the ID counter
    private Long id; // Holds the unique DB ID for the promotion

    @Column (unique = true, nullable = false) // Forces this column to be unique (UK)  and it cannot be empty/null in the DB
    private String code; // Holds the promo code string, like "SUMMER20"

    @Column(name = "start_date") // Maps this field to the DB column named "start_date"
    private LocalDate startDate; // Holds the start date of the promotion

    @Column(name = "end_date") // Maps this field to the DB column named "end_date"
    private LocalDate endDate; // Holds the end date of the promotion

    // --- Getters & Setters ---
    // Standard methods to read + update fields in object

    // Method to get the promotion ID
    public Long getId() {
        return id;
    }

    // Method to set promotion ID
    public void setId(Long id) {
        this.id = id; // Assigns the parameter to the field
    }

    // Method to get the promo code
    public String getCode() {
        return code;
    }

    // Method to set promo code
    public void setCode(String code) {
        this.code = code;
    }

    // Method to get the start date
    public LocalDate getStartDate() {
        return startDate;
    }

    // Method to set the start date
    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    // Method to get end date
    public LocalDate getEndDate() {
        return endDate;
    }

    // Method to set end date
    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

}
