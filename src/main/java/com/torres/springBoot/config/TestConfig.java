package com.torres.springBoot.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.torres.springBoot.entities.Order;
import com.torres.springBoot.entities.User;
import com.torres.springBoot.entities.enums.OrderStatus;
import com.torres.springBoot.repositories.OrderRepository;
import com.torres.springBoot.repositories.UserRepository;

@Configuration //configuration class
@Profile("test")
public class TestConfig implements CommandLineRunner {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		User u1 = new User(null, "Paulo", "paulo@gmail.com", "99999999999", "123456");
		User u2 = new User(null, "João", "joao@gmail.com", "99999999999", "123456");
		
		Order o1 = new Order(null, Instant.parse("2022-08-20T12:41:11Z"), OrderStatus.WAIT_PAYMENT, u1);
		Order o2 = new Order(null, Instant.parse("2022-08-20T12:41:11Z"), OrderStatus.PAID, u2);
		Order o3 = new Order(null, Instant.parse("2022-08-20T10:43:22Z"), OrderStatus.CANCELED, u2);
		
		userRepository.saveAll(Arrays.asList(u1, u2));
		orderRepository.saveAll(Arrays.asList(o1, o2, o3));
		
	}
	
}
