package se.lexicon.ecommerce.repository;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import se.lexicon.ecommerce.model.entity.Category;
import se.lexicon.ecommerce.model.entity.Product;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


@DataJpaTest // Spring boot test config for DB
public class ProductRepositoryTest {

    @Autowired
    private ProductRepository productRepository; // Inject prod repo

    @Autowired
    private CategoryRepository categoryRepository; // Inject category repo

    private Category electronics; // Store catagory for products

    @BeforeEach
    public void setUp() {
        // Save category first
        electronics = new Category();
        electronics.setName("Electronics");
        electronics = categoryRepository.save(electronics);

        // Create laptop product
        Product laptop = new Product();
        laptop.setName("Laptop");
        laptop.setPrice(new BigDecimal("500.00"));
        laptop.setCategory(electronics);
        productRepository.save(laptop);

        // Create mouse product
        Product mouse = new Product();
        mouse.setName("Mouse");
        mouse.setPrice(new BigDecimal("500.00"));
        mouse.setCategory(electronics); // Connect to category
        productRepository.save(mouse);
    }

}