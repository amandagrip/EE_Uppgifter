package com.example.ee_lektion_4;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository repository;

    @Autowired
    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    public Product createProduct(Product product) {
        return repository.save(product);
    }
    
    public Product findByName(String name) {
        return repository.findByName(name)
                .orElseThrow(() -> new ProductNotFoundException(name));
    }

}
