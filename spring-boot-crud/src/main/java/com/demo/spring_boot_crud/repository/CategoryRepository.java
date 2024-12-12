package com.demo.spring_boot_crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.spring_boot_crud.entities.Category;



public interface CategoryRepository extends JpaRepository<Category, Long>{

}
