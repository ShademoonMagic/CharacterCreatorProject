package com.cassiafrench.charcreator.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cassiafrench.charcreator.models.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
	Optional<User> findByEmail(String email);
	
	User findByUsername(String username);
	
	List<User> findAll();
}
