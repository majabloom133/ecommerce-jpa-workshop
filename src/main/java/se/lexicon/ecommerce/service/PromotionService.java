package se.lexicon.ecommerce.service;

import se.lexicon.ecommerce.dto.PromotionResponse;
import se.lexicon.ecommerce.model.entity.Product;
import java.math.BigDecimal;
import java.util.List;

public interface PromotionService {
    // Fetch currently active promotions from the DB
    List<PromotionResponse> getActivePromotions();

    // Calculate a standard discount for a product
    BigDecimal calculateDiscount(Product product);
}
