package com.torres.springBoot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.torres.springBoot.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Long>{

}
