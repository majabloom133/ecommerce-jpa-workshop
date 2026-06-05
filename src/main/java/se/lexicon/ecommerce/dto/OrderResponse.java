package se.lexicon.ecommerce.dto;

import se.lexicon.ecommerce.model.entity.OrderStatus;
import java.time.LocalDateTime;
import java.util.List;

public record OrderResponse(
        Long id,
        Long customerId,
        LocalDateTime orderDate,
        OrderStatus status,
        List <OrderItemResponse> items
) {}
