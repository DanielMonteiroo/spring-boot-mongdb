package com.danielmonteiro.workshopmongo.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import com.danielmonteiro.workshopmongo.domain.User;

@Repository
public interface UserRepository extends MongoRepository<User, String>{

}
