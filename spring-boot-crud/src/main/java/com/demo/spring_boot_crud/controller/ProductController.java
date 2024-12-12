package com.demo.spring_boot_crud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.demo.spring_boot_crud.entities.Product;
import com.demo.spring_boot_crud.service.ProductService;

public class ProductController {

	
	@Autowired
    private ProductService productService;

    // Get all courses
    @GetMapping
    public ResponseEntity<List<Product>> getProducts() {
        List<Product> category = productService.getProducts();
        return ResponseEntity.ok(category);
    }

    // Get a course by ID
    @GetMapping("/{id}")
    public ResponseEntity<Product> getProducts(@PathVariable long id) {
    	Product category = productService.getProducts(id);
        return ResponseEntity.ok(category);
    }

    // Add a new course
    @PostMapping
    public ResponseEntity<Product> addProduct(@RequestBody Product category) {
    	Product savedCategory = productService.addProduct(category);
        return ResponseEntity.ok(savedCategory);
    }

    // Update a course
    @PutMapping("/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable long id, @RequestBody Product categoryDetails) {
    	Product updatedCategory = productService.updateProduct(categoryDetails);
        return ResponseEntity.ok(updatedCategory);
    }

    // Delete a course
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable long id) {
    	productService.deleteProduct(id);
        return ResponseEntity.noContent().build();
    }
}
