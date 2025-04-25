package com.danielmonteiro.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.danielmonteiro.workshopmongo.domain.User;
import com.danielmonteiro.workshopmongo.dto.UserDTO;
import com.danielmonteiro.workshopmongo.repository.UserRepository;
import com.danielmonteiro.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class UserService {

	@Autowired
	private UserRepository repo;
	
	//Metodo retorna todos usuarios
	public List<User> findAll(){
		return repo.findAll();
		
	}
	
	//Metodo retorna usuario por ID
	public Optional<User> findById(String id) {
		Optional<User> user = repo.findById(id);
		if(user == null) {
			throw new ObjectNotFoundException("Objeto não encontrado!");
		}
		return user;
	}
	
	//Metodo para inserir novo usuario
	public User insert(User obj) {
		return repo.insert(obj);
	}
	
	//Metodo de retorno dto
	public User fromDTO(UserDTO objDTO) {
		return new User(objDTO.getId(),objDTO.getName(), objDTO.getEmail());	
	}
	
	
}
