package se.lexicon.ecommerce.service.impl;

import se.lexicon.ecommerce.dto.OrderRequest;
import se.lexicon.ecommerce.dto.OrderResponse;
import se.lexicon.ecommerce.mapper.OrderMapper;
import se.lexicon.ecommerce.repository.CustomerRepository;
import se.lexicon.ecommerce.repository.OrderRepository;
import se.lexicon.ecommerce.repository.ProductRepository;
import org.springframework.stereotype.Service;
import se.lexicon.ecommerce.service.OrderService;

// Spring service implementation for order processing
@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final CustomerRepository customerRepository;
    private final ProductRepository productRepository;
    private final OrderMapper orderMapper;

    // Constructor injection - for all required dependencies
    public OrderServiceImpl(OrderRepository orderRepository,
                            CustomerRepository customerRepository,
                            ProductRepository productRepository,
                            OrderMapper orderMapper) {
        this.orderRepository = orderRepository;
        this.customerRepository = customerRepository;
        this.productRepository = productRepository;
        this.orderMapper = orderMapper;
    }

    @Override
    public OrderResponse placeOrder(OrderRequest request) {

        // Validate that incoming request isn't null
        if (request == null) {
            throw new IllegalArgumentException("Order request cannot be null");
        }

        // Fetch customer from DB or throw exception if not found
        se.lexicon.ecommerce.model.entity.Customer customer = customerRepository.findById(request.customerId())
                .orElseThrow(() -> new IllegalArgumentException("Customer not found with ID: " + request.customerId()));

        // Temporary return - until products are mapped + order is created
        return null;
    }

}
