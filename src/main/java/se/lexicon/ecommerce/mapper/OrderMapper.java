package se.lexicon.ecommerce.mapper;

import se.lexicon.ecommerce.dto.OrderItemResponse;
import se.lexicon.ecommerce.dto.OrderResponse;
import se.lexicon.ecommerce.model.entity.Order;
import se.lexicon.ecommerce.model.entity.OrderItem;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class OrderMapper {

    // Map order entity to response record
    public OrderResponse toResponse(Order entity) {
        // Prevent null pointer exception
        if (entity == null) {
            return null;
        }

        return null;
    }
}
