package com.example.demo.controller;

import com.example.demo.model.Cart;
import com.example.demo.repository.CartRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cart")
@CrossOrigin("*")
public class CartController {

    private final CartRepository cartRepository;

    public CartController(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    @PostMapping("/add")
    public Cart addToCart(@RequestBody Cart cart) {
        return cartRepository.save(cart);
    }

    @GetMapping("/{email}")
    public List<Cart> getCart(@PathVariable String email) {
        return cartRepository.findByUserEmail(email.toLowerCase());
    }
    @DeleteMapping("/{id}")
public void removeItem(@PathVariable Long id) {
    cartRepository.deleteById(id);
}
}
