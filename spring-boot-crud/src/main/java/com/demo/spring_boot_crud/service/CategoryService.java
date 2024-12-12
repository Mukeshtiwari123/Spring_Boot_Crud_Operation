package com.demo.spring_boot_crud.service;

import java.util.List;

import com.demo.spring_boot_crud.entities.Category;

public interface CategoryService {
	public List<Category> getCategories();   		//this will retrieve all courses
	public Category getcategory(long categoryId);   //this will retrieve single course  
	public Category addcategory(Category category);    //this will add new course
	public Category updatecategory(Category category); //update already existing course 
	public void deletecategory(long parseLong);   	//delete the courses
}
