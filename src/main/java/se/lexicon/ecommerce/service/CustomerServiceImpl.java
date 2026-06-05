package se.lexicon.ecommerce.service;

import se.lexicon.ecommerce.dto.CustomerRequest;
import se.lexicon.ecommerce.dto.CustomerResponse;
import se.lexicon.ecommerce.exception.ResourceNotFoundException;
import se.lexicon.ecommerce.mapper.CustomerMapper;
import se.lexicon.ecommerce.model.entity.Customer;
import se.lexicon.ecommerce.model.repository.CustomerRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;

    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository, CustomerMapper customerMapper) {
        this.customerRepository = customerRepository;
        this.customerMapper = customerMapper;
    }

    @Override
    public CustomerResponse register(CustomerRequest request) {
        // Check if email is already taken by another customer
        if (customerRepository.existsByEmail(request.email())) {
            throw new IllegalArgumentException("Email is already taken: " + request.email());
        }
        // Map request to entity, save to DB, return mapped response DTO
        Customer customerEntity = customerMapper.toEntity(request);
        Customer savedCustomer = customerRepository.save(customerEntity);
        return customerMapper.toResponse(savedCustomer);
    }

    @Override
    public CustomerResponse findById(Long id) {
        // Fetch customer from DB or throw custom exception if not found
        Customer customer = customerRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Customer not found with id: " + id));

        // Map found entity to response DTO
        return customerMapper.toResponse(customer);
    }

    @Override
    public CustomerResponse update(Long id, CustomerRequest request) {
        // Fetch existing customer from DB or throw custom exception
        Customer existingCustomer = customerRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Customer was not found with id: " + id));

        // Update customer account information from request fields
        existingCustomer.setFirstName(request.firstName());
        existingCustomer.setLastName(request.lastName());
        existingCustomer.setEmail(request.email());

        // Update customer nested address fields from request fields
        existingCustomer.getAddress().setStreet(request.street());
        existingCustomer.getAddress().setCity(request.city());
        existingCustomer.getAddress().setZipCode(request.zipCode());

        // Save updated entity to DB and return mapped response DTO
        Customer updatedCustomer = customerRepository.save(existingCustomer);
        return customerMapper.toResponse(updatedCustomer);
    }

}