package se.lexicon.ecommerce.controller;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import se.lexicon.ecommerce.dto.CustomerRequest;
import se.lexicon.ecommerce.dto.CategoryResponse;
import se.lexicon.ecommerce.service.CustomerService;

@RestController
@RequestMapping("/api/v1/customers")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }




}
