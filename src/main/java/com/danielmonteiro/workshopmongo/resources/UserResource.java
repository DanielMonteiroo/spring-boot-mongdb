package com.danielmonteiro.workshopmongo.resources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.danielmonteiro.workshopmongo.domain.User;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

	@GetMapping
	public ResponseEntity<List<User>> findAll(){
		
		User u1 = new User("1", "Daniel Monteiro", "daniel1990@gmail.com");
		User u2 = new User("2", "Vanessa Monteiro", "vanessa1996@gmail.com");
		User u3 = new User("3", "Joedison Monteiro", "johiphop85@gmail.com");
		
		List<User> list = new ArrayList<User>();
		list.addAll(Arrays.asList(u1,u2,u3));
		
		return ResponseEntity.ok().body(list);
		
	}
	
}
