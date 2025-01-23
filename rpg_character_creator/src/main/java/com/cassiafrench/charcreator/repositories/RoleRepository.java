package com.cassiafrench.charcreator.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.cassiafrench.charcreator.models.Role;

public interface RoleRepository extends CrudRepository<Role, Long> {
	List<Role> findAll();
    
    Role findByName(String name);
}
