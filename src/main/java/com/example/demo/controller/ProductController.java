package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;
import java.util.*;
import com.example.demo.model.Product;
import com.example.demo.repository.ProductRepository;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class ProductController {

    private final ProductRepository productRepository;

    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping("/products/featured")
    public Map<String, Object> getProducts() {
        Map<String, Object> response = new HashMap<>();
        response.put("success", true);
        response.put("data", productRepository.findAll());
        return response;
    }

    @PostMapping("/products")
    public Product addProduct(@RequestBody Product product) {
        return productRepository.save(product);
    }
}