package se.lexicon.ecommerce.service.impl;

import se.lexicon.ecommerce.dto.PromotionResponse;
import se.lexicon.ecommerce.model.entity.Product;
import se.lexicon.ecommerce.repository.PromotionRepository;
import se.lexicon.ecommerce.service.PromotionService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

// Annotate as a Spring Servive component to hold business logic
@Service
public class PromotionServiceImpl implements PromotionService {

    // Dependency injection via constructor
    private final PromotionRepository promotionRepository;

    public PromotionServiceImpl(PromotionRepository promotionRepository) {
        this.promotionRepository = promotionRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<PromotionResponse> getActivePromotions() {
        // Capture current local date
        LocalDate today = LocalDate.now();

        // Fetch valid promotions active today from DB using repository method
        return promotionRepository.findByStartDateLessThanEqualAndEndDateGreaterThanEqual(today, today)
                .stream()
                .map(promo -> new PromotionResponse(
                        promo.getId(),
                        promo.getCode(),
                        promo.getStartDate(),
                        promo.getEndDate()
                ))
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public BigDecimal calculateDiscount(Product product) {
        // Return zero discount if product or product price is missing
        if (product == null || product.getPrice() == null) {
            return BigDecimal.ZERO;
        }
        // Apply standard promotional business rule: 10% discount off the price
        return product.getPrice().multiply(new BigDecimal("0.10"));
    }

}
