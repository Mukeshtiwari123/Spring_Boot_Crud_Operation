package com.demo.spring_boot_crud.service;

import java.util.List;

import com.demo.spring_boot_crud.entities.Product;

public interface ProductService {
	public List<Product> getProducts();   		//this will retrieve all courses
	public Product getProducts(long productId);   //this will retrieve single course  
	public Product addProduct(Product product);    //this will add new course
	public Product updateProduct(Product product); //update already existing course 
	public void deleteProduct(long parseLong);   	//delete the courses
}
