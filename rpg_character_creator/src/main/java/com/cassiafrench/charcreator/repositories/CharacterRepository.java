package com.cassiafrench.charcreator.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cassiafrench.charcreator.models.Chara;

@Repository
public interface CharacterRepository extends CrudRepository<Chara, Long> {
	List<Chara> findAll();
}
