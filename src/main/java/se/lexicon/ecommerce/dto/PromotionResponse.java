package se.lexicon.ecommerce.dto;

import java.time.LocalDate;

public record PromotionResponse(
        Long id,
        String code,
        LocalDate startDate,
        LocalDate endDate
) {}
