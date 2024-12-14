package com.demo.spring_boot_crud.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.demo.spring_boot_crud.entities.Category;

public interface CategoryService {
    public List<Category> getCategories();        // Retrieve all categories
    public Category getcategory(long categoryId); // Retrieve a single category by ID
    public Category addcategory(Category category); // Add a new category
    public Category updatecategory(long id, Category categoryDetails); // Update an existing category
    public void deletecategory(long categoryId);  // Delete a category

    // Add this method for pagination
    public Page<Category> getAllCategories(int page, int size); // Retrieve paginated categories
}
