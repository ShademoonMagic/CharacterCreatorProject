package com.cassiafrench.charcreator.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cassiafrench.charcreator.models.Chara;
import com.cassiafrench.charcreator.repositories.CharacterRepository;

@Service
public class CharacterService {
	@Autowired
	private CharacterRepository charRepo;
	
	public List<Chara> getAllChars(){
		return charRepo.findAll();
	}
	
	public Chara createChar(Chara newCharacter) {
		return charRepo.save(newCharacter);
	}
	
	public Chara getOneChar(Long id) {
		Optional<Chara> expectedChar = charRepo.findById(id);
		return expectedChar.isPresent() ? expectedChar.get() : null;
	}
	
	public Chara editChar(Chara oneCharacter) {
		return charRepo.save(oneCharacter);
	}
	
	public void deleteChar(Long id) {
		charRepo.deleteById(id);
	}
	
	public Chara levelUpChar(Chara oneCharacter, Long id) {
		Optional<Chara> selectedChar = charRepo.findById(id);
		
		if(selectedChar.isPresent()) {
			selectedChar.get();
		}
		
		Chara returnedChar = selectedChar.get();
		
		Integer newLevel = returnedChar.getLevel();
		
		returnedChar.setLevel(newLevel+1);
		return charRepo.save(returnedChar);
	}
}
