package com.torres.springBoot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.torres.springBoot.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
