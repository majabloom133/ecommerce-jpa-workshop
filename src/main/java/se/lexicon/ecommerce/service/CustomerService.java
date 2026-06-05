package se.lexicon.ecommerce.service;

import se.lexicon.ecommerce.dto.CustomerRequest;
import se.lexicon.ecommerce.dto.CustomerResponse;

public interface CustomerService {

    // Register new customer in system using provided request data
    CustomerResponse register(CustomerRequest request);

    CustomerResponse findById(Long id);

    // Find and return a customer by their id and new request data
    CustomerResponse update(Long id, CustomerRequest request);
}


