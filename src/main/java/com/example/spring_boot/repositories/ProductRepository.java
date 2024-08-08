package com.example.spring_boot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.spring_boot.models.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{}
