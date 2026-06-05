package se.lexicon.ecommerce.service;

import se.lexicon.ecommerce.dto.OrderRequest;
import se.lexicon.ecommerce.dto.OrderResponse;

// Service Interface - handling order business operations
public interface OrderService {

// Process and save a new customer order
    OrderResponse placeOrder(OrderRequest request);
}
