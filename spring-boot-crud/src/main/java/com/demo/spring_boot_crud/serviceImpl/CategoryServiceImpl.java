package com.demo.spring_boot_crud.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.demo.spring_boot_crud.entities.Category;
import com.demo.spring_boot_crud.repository.CategoryRepository;
import com.demo.spring_boot_crud.service.CategoryService;

public class CategoryServiceImpl implements CategoryService{
	
	@Autowired
	private CategoryRepository categoryRepository;

	@Override
	public List<Category> getCategories() {
		return categoryRepository.findAll();
	}

	@Override
	public Category getcategory(long categoryId) {
		return categoryRepository.findById(categoryId)
				.orElseThrow(() -> new RuntimeException("Course not found with id: " + categoryId));
	}

	@Override
	public Category addcategory(Category category) {
		return categoryRepository.save(category);
	}

	@Override
	public Category updatecategory(Category categoryDetails) {
		Category existingCategory = categoryRepository.findById(categoryDetails.getId())
	            .orElseThrow(() -> new RuntimeException("Course not found with id: " + categoryDetails.getId()));

	    // Update fields of the course
		existingCategory.setName(categoryDetails.getName());
		//existingCategory.setDescription(categoryDetails.getDescription());
		return categoryRepository.save(existingCategory);
	}


	@Override
	public void deletecategory(long categoryId) {
		Category category = categoryRepository.findById(categoryId)
				.orElseThrow(() -> new RuntimeException("Course not found with id: " + categoryId));

		categoryRepository.delete(category);
	}
}
