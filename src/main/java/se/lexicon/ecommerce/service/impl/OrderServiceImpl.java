package se.lexicon.ecommerce.service.impl;

import se.lexicon.ecommerce.dto.OrderRequest;
import se.lexicon.ecommerce.dto.OrderResponse;
import se.lexicon.ecommerce.exception.ResourceNotFoundException;
import se.lexicon.ecommerce.mapper.OrderMapper;
import se.lexicon.ecommerce.model.entity.Order;
import se.lexicon.ecommerce.model.entity.OrderStatus;
import se.lexicon.ecommerce.repository.CustomerRepository;
import se.lexicon.ecommerce.repository.OrderRepository;
import se.lexicon.ecommerce.repository.ProductRepository;
import org.springframework.stereotype.Service;
import se.lexicon.ecommerce.service.OrderService;
import se.lexicon.ecommerce.service.PromotionService;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;


// Spring service implementation for order processing
@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final CustomerRepository customerRepository;
    private final ProductRepository productRepository;
    private final OrderMapper orderMapper;
    private final PromotionService promotionService;

    // Constructor injection - for all required dependencies
    public OrderServiceImpl(OrderRepository orderRepository,
                            CustomerRepository customerRepository,
                            ProductRepository productRepository,
                            OrderMapper orderMapper, PromotionService promotionService) {
        this.orderRepository = orderRepository;
        this.customerRepository = customerRepository;
        this.productRepository = productRepository;
        this.orderMapper = orderMapper;
        this.promotionService = promotionService;
    }

    @Override
    @org.springframework.transaction.annotation.Transactional
    public OrderResponse placeOrder(OrderRequest request) {

        // Validate that incoming request isn't null
        if (request == null) {
            throw new IllegalArgumentException("Order request cannot be null");
        }

        // Fetch customer from DB or throw exception if not found
        se.lexicon.ecommerce.model.entity.Customer customer = customerRepository.findById(request.customerId())
                .orElseThrow(() -> new ResourceNotFoundException("Customer not found with ID: " + request.customerId()));

        // Create new order entity + populate basic fields
        se.lexicon.ecommerce.model.entity.Order order = new se.lexicon.ecommerce.model.entity.Order();

        // Generate a unique order number (using UUID as quick standard solution)
        order.setOrderNumber(java.util.UUID.randomUUID().toString());

        // Set creation timestamp + initial status
        order.setCreatedAt(java.time.LocalDateTime.now());
        order.setStatus(OrderStatus.CREATED);

        // Link validated customer to this order
        order.setCustomer(customer);

        // Process each item request from the incoming order request
        if (request.items() != null) {
            for (se.lexicon.ecommerce.dto.OrderItemRequest itemRequest : request.items()) {

                // Fetch product from DB to verify it exists + fet current price
                se.lexicon.ecommerce.model.entity.Product product = productRepository.findById(itemRequest.productId())
                        .orElseThrow(() -> new ResourceNotFoundException("Product not found with ID: " + itemRequest.productId()));

                // Create new OrderItem entity for this line
                se.lexicon.ecommerce.model.entity.OrderItem orderItem = new se.lexicon.ecommerce.model.entity.OrderItem();
                orderItem.setProduct(product);
                orderItem.setQuantity(itemRequest.quantity());

                // Calculate discount using promotionService and subtract it from product price
                BigDecimal basePrice = product.getPrice();
                BigDecimal discount = promotionService.calculateDiscount(product);
                orderItem.setPriceAtPurchase(basePrice.subtract(discount));

                // Explicitly link this item to main order
                orderItem.setOrder(order);

                // Add item to order's internal list
                order.getOrderItems().add(orderItem);
            }
        }
        // Save entire order - cascades will automatically save all the order items
        se.lexicon.ecommerce.model.entity.Order savedOrder = orderRepository.save(order);

        // Convert saved entity to response record and return
        return orderMapper.toResponse(savedOrder);

    }
}