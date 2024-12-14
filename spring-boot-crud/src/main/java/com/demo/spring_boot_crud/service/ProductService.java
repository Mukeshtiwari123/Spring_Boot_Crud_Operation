package com.demo.spring_boot_crud.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.demo.spring_boot_crud.entities.Product;

public interface ProductService {
    public List<Product> getProducts(); // Retrieve all products
    public Product getProducts(long productId); // Retrieve a single product by ID
    public Product addProduct(Product product); // Add a new product
    public Product updateProduct(Product product); // Update an existing product
    public void deleteProduct(long productId); // Delete a product

    // Add this method for pagination
    public Page<Product> getAllProducts(int page, int size); // Retrieve paginated products
}
