package se.lexicon.ecommerce.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.OneToMany;
import jakarta.persistence.FetchType;
import java.util.List;
import java.util.ArrayList;


@Entity // Tells JPA that this class represents a table in the DB
@Table(name = "categories") // Names database table "categories"
public class Category {


    @Id // Marks this field as primary key for table
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Tells the DB to automatically increase the ID counter  (1, 2, 3...)
    private Long id; // Holds the unique DB ID for the category

    private String name; // Holds name of category (like "Electronics" or "Books")

    @OneToMany(mappedBy = "category", fetch = FetchType.LAZY)
    private List<Product> products = new ArrayList<>();

    // --- GETTERS & SETTERS ---
    // Methods used to get and set fields in the object.


    // Method to get the category ID
    public Long getId() {
        return id;
    }

    // Method to set the category ID
    public void setId(Long id) {
        this.id = id;
    }

    // Method to get the category name
    public String getName() {
        return name;
    }

    // Method to set the catogory name
    public void setName(String name) {
        this.name = name;
    }

public List<Product> getProducts() {
        return products;
}

public void setProducts(List<Product> products) {
        this.products = products;
}


}
