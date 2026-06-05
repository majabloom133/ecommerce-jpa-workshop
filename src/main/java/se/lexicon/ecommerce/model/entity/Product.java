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
import jakarta.persistence.ElementCollection;
import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.JoinTable;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;

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

    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(name = "product_images", joinColumns = @JoinColumn(name = "product_id"))
    @Column(name = "image_url")
    private List<String> imageUrls = new ArrayList<>();

    @ManyToMany(fetch = FetchType.LAZY) // Defines a many-to-many relationship loaded only when requested
    @JoinTable(
            name = "products_promotions", // Names DB bridge table "products_promotions"
            joinColumns = @JoinColumn(name = "product_id"), // Connects this table to the product's ID column
            inverseJoinColumns = @JoinColumn(name = "promotion_id") // Connects this table to the promotion's ID column
    )
    private Set<Promotion> promotions = new HashSet<>();

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

    public List<String> getImageUrls() {
        return imageUrls;
    }

    public void setImageUrls(List<String> imageUrls) {
        this.imageUrls = imageUrls;
    }


    public Set<Promotion> getPromotions() {
        return promotions;
    }

    public void setPromotions(Set<Promotion> promotions) {
        this.promotions = promotions;
    }


}
