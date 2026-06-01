package se.lexicon.ecommerce.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
// For handling high-precision money values
import java.math.BigDecimal;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;

@Entity // Tells JPA this class represents DB table
@Table(name = "products")
public class Product {

    @Id // Marks as primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Holds unique DB ID for the table
    private String name; // Holds the name of the product, like "laptop"
    private BigDecimal price; // Holds the price using BigDecimal to avoid rounding errors with money

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private Category category;

    // --- Getters & Setters ---

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory (Category category) {
        this.category = category;
    }
}
