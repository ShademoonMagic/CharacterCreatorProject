package com.cassiafrench.charcreator.services;

import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.cassiafrench.charcreator.models.User;
import com.cassiafrench.charcreator.models.UserLogin;
import com.cassiafrench.charcreator.repositories.RoleRepository;
import com.cassiafrench.charcreator.repositories.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepo;
	@Autowired
	private RoleRepository roleRepo;
	
	public User registerWithUser(User newUser, BindingResult result) {
			
			Optional<User> possibleUser = userRepo.findByEmail(newUser.getEmail());
			
			if(possibleUser.isPresent()) {
				result.rejectValue("email", "emailAlreadyRegistered", "This email is already taken!");
			}
			
			if(!newUser.getPassword().equals(newUser.getConfirmPassword())) {
				result.rejectValue("password", "passwordMismatch", "Passwords do not match!");
			}
			
			if(result.hasErrors()) {
				return null;
			}
			
			String hashedPw = BCrypt.hashpw(newUser.getPassword(), BCrypt.gensalt());
			newUser.setPassword(hashedPw);
			newUser.setRole(roleRepo.findByName("ROLE_USER"));
			User registeredUser = userRepo.save(newUser);
			return registeredUser;
		}
	
	public User registerWithAdmin(User newUser, BindingResult result) {
		
		Optional<User> possibleUser = userRepo.findByEmail(newUser.getEmail());
		
		if(possibleUser.isPresent()) {
			result.rejectValue("email", "emailAlreadyRegistered", "This email is already taken!");
		}
		
		if(!newUser.getPassword().equals(newUser.getConfirmPassword())) {
			result.rejectValue("password", "passwordMismatch", "Passwords do not match!");
		}
		
		if(result.hasErrors()) {
			return null;
		}
		
		String hashedPw = BCrypt.hashpw(newUser.getPassword(), BCrypt.gensalt());
		newUser.setPassword(hashedPw);
		newUser.setRole(roleRepo.findByName("ROLE_ADMIN"));
		User registeredUser = userRepo.save(newUser);
		return registeredUser;
	}

	public User getUserById(Long id) {
		Optional<User> possibleUser = userRepo.findById(id);
		
		return possibleUser.isPresent() ? possibleUser.get() : null;
		
	}
	
	public User findByUsername(String username) {
		return userRepo.findByUsername(username);
	}
	
	public User login(UserLogin newLogin, BindingResult result) {
		Optional<User> possibleUser = userRepo.findByEmail(newLogin.getEmail());
		
		if(possibleUser.isEmpty()) {
			result.rejectValue("email", "InvalidCredentials", "Invalid login information");
			return null;
		}
		
		User returnedUser = possibleUser.get();
		
		if(!BCrypt.checkpw(newLogin.getPassword(), returnedUser.getPassword())) {
			result.rejectValue("email", "InvalidCredentials", "Invalid login information");
			return null;
		}
		
		if(result.hasErrors()) {
			return null;
		} else {
			return returnedUser;
		}
	}

	
	
}
