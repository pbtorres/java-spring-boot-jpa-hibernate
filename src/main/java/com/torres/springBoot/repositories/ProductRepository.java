package com.torres.springBoot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.torres.springBoot.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
