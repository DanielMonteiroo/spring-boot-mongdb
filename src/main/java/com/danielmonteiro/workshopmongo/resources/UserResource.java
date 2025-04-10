package com.danielmonteiro.workshopmongo.resources;

<<<<<<< HEAD
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
=======
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

>>>>>>> 97e46da827520630a7de50042c225d0b04bede5b
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.danielmonteiro.workshopmongo.domain.User;
<<<<<<< HEAD
import com.danielmonteiro.workshopmongo.services.UserService;
=======
>>>>>>> 97e46da827520630a7de50042c225d0b04bede5b

@RestController
@RequestMapping(value = "/users")
public class UserResource {

<<<<<<< HEAD
	@Autowired
	private UserService service;
	
	@GetMapping
	public ResponseEntity<List<User>> findAll(){
				
		List<User> list = service.findAll();
=======
	@GetMapping
	public ResponseEntity<List<User>> findAll(){
		
		User u1 = new User("1", "Daniel Monteiro", "daniel1990@gmail.com");
		User u2 = new User("2", "Vanessa Monteiro", "vanessa1996@gmail.com");
		User u3 = new User("3", "Joedison Monteiro", "johiphop85@gmail.com");
		
		List<User> list = new ArrayList<User>();
		list.addAll(Arrays.asList(u1,u2,u3));
>>>>>>> 97e46da827520630a7de50042c225d0b04bede5b
		
		return ResponseEntity.ok().body(list);
		
	}
	
}
