package com.torres.springBoot.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.torres.springBoot.entities.Category;
import com.torres.springBoot.entities.Order;
import com.torres.springBoot.entities.Product;
import com.torres.springBoot.entities.User;
import com.torres.springBoot.entities.enums.OrderStatus;
import com.torres.springBoot.repositories.CategoryRepository;
import com.torres.springBoot.repositories.OrderRepository;
import com.torres.springBoot.repositories.ProductRepository;
import com.torres.springBoot.repositories.UserRepository;

@Configuration //configuration class
@Profile("test")
public class TestConfig implements CommandLineRunner {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private ProductRepository productRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		Category c1 = new Category(null, "Eletronics");
		Category c2 = new Category(null, "Books");
		Category c3 = new Category(null, "Computers");
		
		Product p1 = new Product(null, "Mouse", "Mouse", 49.90, "/img/mouse");
		Product p2 = new Product(null, "Código Limpo", "Livro", 79.90, "/img/codigo_limpo");
		Product p3 = new Product(null, "Processador", "Processador", 900.00, "/img/processador");
		
		categoryRepository.saveAll(Arrays.asList(c1, c2, c3));
		productRepository.saveAll(Arrays.asList(p1, p2, p3));
		
		p1.getCategories().add(c1);
		p2.getCategories().add(c2);
		p3.getCategories().add(c3);
		p3.getCategories().add(c1);
		
		productRepository.saveAll(Arrays.asList(p1, p2, p3));
		
		User u1 = new User(null, "Paulo", "paulo@gmail.com", "99999999999", "123456");
		User u2 = new User(null, "João", "joao@gmail.com", "99999999999", "123456");
		
		Order o1 = new Order(null, Instant.parse("2022-08-20T12:41:11Z"), OrderStatus.WAIT_PAYMENT, u1);
		Order o2 = new Order(null, Instant.parse("2022-08-20T12:41:11Z"), OrderStatus.PAID, u2);
		Order o3 = new Order(null, Instant.parse("2022-08-20T10:43:22Z"), OrderStatus.CANCELED, u2);
		
		userRepository.saveAll(Arrays.asList(u1, u2));
		orderRepository.saveAll(Arrays.asList(o1, o2, o3));
		
	}
	
}
