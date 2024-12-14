package com.demo.spring_boot_crud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    // Get all categories
    @GetMapping
    public ResponseEntity<List<Category>> getCategories() {
        List<Category> categories = categoryService.getCategories();
        return ResponseEntity.ok(categories);
    }

    // Get paginated categories
    @GetMapping("/paginated")
    public ResponseEntity<Page<Category>> getPaginatedCategories(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        Page<Category> paginatedCategories = categoryService.getAllCategories(page, size);
        return ResponseEntity.ok(paginatedCategories);
    }

    // Get a category by ID
    @GetMapping("/{id}")
    public ResponseEntity<Category> getCategory(@PathVariable long id) {
        Category category = categoryService.getcategory(id);
        return ResponseEntity.ok(category);
    }

    // Add a new category
    @PostMapping
    public ResponseEntity<Category> addCategory(@RequestBody Category category) {
        Category savedCategory = categoryService.addcategory(category);
        return ResponseEntity.ok(savedCategory);
    }

    // Update a category
    @PutMapping("/{id}")
    public ResponseEntity<Category> updateCategory(@PathVariable long id, @RequestBody Category categoryDetails) {
        Category updatedCategory = categoryService.updatecategory(id, categoryDetails);
        return ResponseEntity.ok(updatedCategory);
    }


    // Delete a category
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable long id) {
        categoryService.deletecategory(id);
        return ResponseEntity.noContent().build();
    }
}