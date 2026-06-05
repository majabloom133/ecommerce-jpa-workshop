package se.lexicon.ecommerce.service.impl;

import se.lexicon.ecommerce.dto.ProductRequest;
import se.lexicon.ecommerce.dto.ProductResponse;
import se.lexicon.ecommerce.exception.ResourceNotFoundException;
import se.lexicon.ecommerce.mapper.ProductMapper;
import se.lexicon.ecommerce.model.entity.Category;
import se.lexicon.ecommerce.model.entity.Product;
import se.lexicon.ecommerce.repository.CategoryRepository;
import se.lexicon.ecommerce.repository.ProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import se.lexicon.ecommerce.service.ProductService;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

// Annotate as a Spring Service component - to contain business logic!
@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;
    private final ProductMapper productMapper;

    // Use constructor injection - to inject required dependencies
    @Autowired
    public ProductServiceImpl(ProductRepository productRepository,
                              CategoryRepository categoryRepository,
                              ProductMapper productMapper) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
        this.productMapper = productMapper;
    }

    @Override
    @Transactional
    public ProductResponse create(ProductRequest request) {
        Category category = categoryRepository.findById(request.categoryId())
                .orElseThrow(() -> new ResourceNotFoundException("Category not found with id: " + request.categoryId()));

        Product productEntity = productMapper.toEntity(request);
        productEntity.setCategory(category);

        Product savedProduct = productRepository.save(productEntity);
        return productMapper.toResponse(savedProduct);
    }

        @Override
        @Transactional(readOnly = true)
        public List<ProductResponse> findAll () {
            return productRepository.findAll()
                    .stream()
                    .map(productMapper::toResponse)
                    .collect(Collectors.toList());
        }

        @Override
        @Transactional(readOnly = true)
        public List<ProductResponse> searchByName (String name){
            return productRepository.findByCategoryNameIgnoreCase(name)
                    .stream()
                    .map(productMapper::toResponse)
                    .collect(Collectors.toList());
        }
    }
