package se.lexicon.ecommerce.mapper;

import se.lexicon.ecommerce.dto.OrderItemResponse;
import se.lexicon.ecommerce.dto.OrderResponse;
import se.lexicon.ecommerce.model.entity.Order;
import se.lexicon.ecommerce.model.entity.OrderItem;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

// Spring component for dependency injection
@Component
public class OrderMapper {

    // Map order entity to response record
    public OrderResponse toResponse(Order entity) {
        // Prevent null pointer exception
        if (entity == null) {
            return null;
        }

        // Safe check to get customer id without breaking if customer is null
        Long customerId = null;
        if (entity.getCustomer() != null) {
            customerId = entity.getCustomer().getId();
        }

        List<OrderItemResponse> itemResponses = new ArrayList<>();
        if (entity.getOrderItems() != null) {
            itemResponses = entity.getOrderItems().stream()
                    .map(this::toItemResponse)
                    .collect(Collectors.toList());
        }

        return new OrderResponse(
                entity.getId(),
                customerId,
                entity.getCreatedAt(),
                entity.getStatus(),
                itemResponses
        );
    }

    // Helper method to map individual order items
    private OrderItemResponse toItemResponse(OrderItem item) {
        if (item == null) {
            return  null;
        }

        Long productId = null;
        String productName = null;

        // Safe check to get product details
        if (item.getProduct() != null) {
            productId = item.getProduct().getId();
            productName = item.getProduct().getName();
        }

        return new OrderItemResponse(
                item.getId(),
                productId,
                productName,
                item.getQuantity(),
                item.getPriceAtPurchase()
        );
    }

}
