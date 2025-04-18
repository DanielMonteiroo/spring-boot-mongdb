package com.danielmonteiro.workshopmongo.resources;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.danielmonteiro.workshopmongo.domain.User;
import com.danielmonteiro.workshopmongo.dto.UserDTO;
import com.danielmonteiro.workshopmongo.services.UserService;


@RestController
@RequestMapping(value = "/users")
public class UserResource {


	@Autowired
	private UserService service;
	
	//Busca por todos
	@GetMapping
	public ResponseEntity<List<UserDTO>> findAll(){
				
		List<User> list = service.findAll();
		List<UserDTO> listDTO = list.stream().map(x-> new UserDTO(x)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
	}
	
	//Busca por ID
	@GetMapping(value = "/{id}")
	public ResponseEntity<UserDTO> findById(@PathVariable String id){
		Optional<User> obj = service.findById(id);		
		return ResponseEntity.ok().body(new UserDTO(obj.get()));	
	}
	
}
