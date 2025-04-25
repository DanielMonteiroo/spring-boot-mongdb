package com.danielmonteiro.workshopmongo.resources;

import java.net.URI;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
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
	
	//Inserção novo usuario
	@PostMapping
	public ResponseEntity<Void> insert(@RequestBody UserDTO objDTO ){
		User obj = service.fromDTO(objDTO);
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	//Deletar por ID
		@DeleteMapping(value = "/{id}")
		public ResponseEntity<Void> delete(@PathVariable String id){
			service.delete(id);	
			return ResponseEntity.noContent().build();
		}
		
		//Atualizar usuario por ID
		@PutMapping(value = "/{id}")
		public ResponseEntity<Void> update(@RequestBody UserDTO objDTO, @PathVariable String id ){
			User obj = service.fromDTO(objDTO);
			obj.setId(id);
			obj = service.update(obj);
			return ResponseEntity.noContent().build();
		}
	
}
