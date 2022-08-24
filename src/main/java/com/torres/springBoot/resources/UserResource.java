package com.torres.springBoot.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.torres.springBoot.entities.User;

@RestController
@RequestMapping("/users")
public class UserResource {
	
	@GetMapping
	public ResponseEntity<User> findAll() {
		User u = new User(1L, "Maria", "maria@gmail.com", "99999999999", "123456");
		return ResponseEntity.ok().body(u);
	}

}
