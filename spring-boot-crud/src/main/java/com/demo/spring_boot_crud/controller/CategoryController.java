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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.demo.spring_boot_crud.entities.Category;

import com.demo.spring_boot_crud.service.CategoryService;

@RestController
@RequestMapping("/api/category")
public class CategoryController {
	@Autowired

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }
    // Get all category
    @GetMapping
    public ResponseEntity<List<Category>> getCategories() {
        List<Category> category = categoryService.getCategories();
        return ResponseEntity.ok(category);
    }

    // Get a course by ID
    @GetMapping("/{id}")
    public ResponseEntity<Category> getcategory(@PathVariable long id) {
    	Category category = categoryService.getcategory(id);
        return ResponseEntity.ok(category);
    }

    // Add a new course
    @PostMapping
    public ResponseEntity<Category> addcategory(@RequestBody Category category) {
    	Category savedCategory = categoryService.addcategory(category);
        return ResponseEntity.ok(savedCategory);
    }

    // Update a course
    @PutMapping("/{id}")
    public ResponseEntity<Category> updatecategory(@PathVariable long id, @RequestBody Category categoryDetails) {
    	Category updatedCategory = categoryService.updatecategory(categoryDetails);
        return ResponseEntity.ok(updatedCategory);
    }

    // Delete a course
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletecategory(@PathVariable long id) {
    	categoryService.deletecategory(id);
        return ResponseEntity.noContent().build();
    }
}
