package com.cassiafrench.charcreator.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.cassiafrench.charcreator.models.User;
import com.cassiafrench.charcreator.models.UserLogin;
import com.cassiafrench.charcreator.services.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class UserController {
	
	@Autowired
	private UserService userServe;
	
	@PostMapping("/register-user")
	public String createUser(@Valid @ModelAttribute("newUser") User newUser, BindingResult result, Model model, HttpSession session) {
		
		if(result.hasErrors()) {
			model.addAttribute("newUser", new User());
			model.addAttribute("newLogin", new UserLogin());
			return "index.jsp";
		}
		
		User potentialUser = userServe.registerWithUser(newUser, result);
		if(potentialUser == null) {
			model.addAttribute("newUser", new User());
			model.addAttribute("newLogin", new UserLogin());
			return "index.jsp";
		}
		session.setAttribute("userID", potentialUser.getId());
		return "redirect:/dashboard";
	}
	
	@PostMapping("/register-admin")
	public String createAdmin(@Valid @ModelAttribute("newUser") User newUser, BindingResult result, Model model, HttpSession session) {
		
		if(result.hasErrors()) {
			model.addAttribute("newUser", new User());
			model.addAttribute("newLogin", new UserLogin());
			return "index.jsp";
		}
		
		User potentialUser = userServe.registerWithAdmin(newUser, result);
		if(potentialUser == null) {
			model.addAttribute("newUser", new User());
			model.addAttribute("newLogin", new UserLogin());
			return "index.jsp";
		}
		session.setAttribute("userID", potentialUser.getId());
		return "redirect:/dashboard";
	}
	
	@PostMapping("/login")
	public String loginUser(@Valid @ModelAttribute("newLogin") UserLogin userLogin, BindingResult result, Model model, HttpSession session) {
		
		if(result.hasErrors()) {
			model.addAttribute("newUser", new User());
			model.addAttribute("newLogin", new UserLogin());
			return "index.jsp";
		}
		User potentialUser = userServe.login(userLogin, result);
		if(potentialUser == null) {
			model.addAttribute("newUser", new User());
			model.addAttribute("newLogin", new UserLogin());
			return "index.jsp";
		}
		session.setAttribute("userID", potentialUser.getId());
		return "redirect:/dashboard";
	}
	
	@PostMapping("/logout") 
	public String logoutUser(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
}
