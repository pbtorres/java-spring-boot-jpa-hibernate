package com.torres.springBoot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.torres.springBoot.entities.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long>{

}
