package se.lexicon.ecommerce.repository;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import se.lexicon.ecommerce.model.entity.Category;
import se.lexicon.ecommerce.model.entity.Product;
import java.math.BigDecimal;

@Component
public class DataSeeder implements CommandLineRunner {

    private final CategoryRepository categoryRepository;
    private final ProductRepository productRepository;

    public DataSeeder(CategoryRepository categoryRepository, ProductRepository productRepository) {
        this.categoryRepository = categoryRepository;
        this.productRepository = productRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        // Only seed data if database is empty
        if (categoryRepository.count() == 0) {
            Category electronics = new Category();
            electronics.setName("Electronics");
            categoryRepository.save(electronics);

            Product laptop = new Product();
            laptop.setName("Laptop");
            laptop.setPrice(new BigDecimal("12000.00"));
            laptop.setCategory(electronics);
            productRepository.save(laptop);

            System.out.println("!!! DATA SEEDING COMPLETE !!!");
        }
    }

}
