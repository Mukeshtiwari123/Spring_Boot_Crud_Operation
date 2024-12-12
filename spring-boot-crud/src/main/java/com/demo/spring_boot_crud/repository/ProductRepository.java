package com.demo.spring_boot_crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.spring_boot_crud.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{

}
