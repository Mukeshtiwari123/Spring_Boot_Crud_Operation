package com.demo.spring_boot_crud.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.demo.spring_boot_crud.entities.Product;
import com.demo.spring_boot_crud.repository.ProductRepository;
import com.demo.spring_boot_crud.service.ProductService;

public class ProductServiceImpl implements ProductService{

	@Autowired
	private ProductRepository productRepository;

	@Override
	public List<Product> getProducts() {
		return productRepository.findAll();
	}

	@Override
	public Product getProducts(long productId) {
		return productRepository.findById(productId)
				.orElseThrow(() -> new RuntimeException("Course not found with id: " + productId));
	}

	@Override
	public Product addProduct(Product product) {
		return productRepository.save(product);
	}

	@Override
	public Product updateProduct(Product productDetails) {
		Product existingProduct = productRepository.findById(productDetails.getId())
	            .orElseThrow(() -> new RuntimeException("Course not found with id: " + productDetails.getId()));

	    // Update fields of the course
		existingProduct.setName(productDetails.getName());
		existingProduct.setPrice(productDetails.getPrice());
		return productRepository.save(existingProduct);
	}


	@Override
	public void deleteProduct(long productId) {
		Product product = productRepository.findById(productId)
				.orElseThrow(() -> new RuntimeException("Course not found with id: " + productId));

		productRepository.delete(product);
	}
}
