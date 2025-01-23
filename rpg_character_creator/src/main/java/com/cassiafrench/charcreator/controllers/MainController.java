package com.cassiafrench.charcreator.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import com.cassiafrench.charcreator.models.Chara;
import com.cassiafrench.charcreator.models.User;
import com.cassiafrench.charcreator.models.UserLogin;
import com.cassiafrench.charcreator.services.CharacterService;
import com.cassiafrench.charcreator.services.UserService;

import jakarta.servlet.http.HttpSession;

@Controller
public class MainController {
	
	@Autowired
	public UserService userServe;
	@Autowired
	public CharacterService charServe;
	
	@GetMapping("/")
	public String mainViewIndex(Model model) {
		model.addAttribute("newUser", new User());
		model.addAttribute("newLogin", new UserLogin());
		return "index.jsp";
	}
	
	@GetMapping("/dashboard")
	public String dashboardView(Model model, HttpSession session) {
		if(session.getAttribute("userID") == null) {
			return "redirect:/";
		}
		Long userID = (Long) session.getAttribute("userID");
		User loggedInUser = userServe.getUserById(userID);
		
		model.addAttribute("loggedUser", loggedInUser);
		model.addAttribute("allChars", charServe.getAllChars());
		return "dashboard.jsp";
	}
	
	@GetMapping("/characters/new")
	public String createCharView(Model model, @ModelAttribute("newChar") Chara newChara, HttpSession session ) {
		if(session.getAttribute("userID") == null) {
			return "redirect:/";
		}
		model.addAttribute("userID", session.getAttribute("userID"));
		return "newCharForm.jsp";
	}
	
	@GetMapping("/characters/{id}")
	public String viewCharacter(Model model, @PathVariable("id") Long id, HttpSession session) {
		if(session.getAttribute("userID") == null) {
			return "redirect:/";
		}
		Chara oneChar = charServe.getOneChar(id);
		Long userID = (Long) session.getAttribute("userID");
		User loggedInUser = userServe.getUserById(userID);
		
		model.addAttribute("loggedUser", loggedInUser);
		model.addAttribute("userID", session.getAttribute("userID"));
		model.addAttribute("oneChar", oneChar);
		return "viewChar.jsp";
	}
	
	@GetMapping("/characters/{id}/edit")
	public String editCharView(Model model, @PathVariable("id") Long id, HttpSession session) {
		if(session.getAttribute("userID") == null) {
			return "redirect:/";
		}
		Chara oneChar = charServe.getOneChar(id);
		model.addAttribute("userID", session.getAttribute("userID"));
		model.addAttribute("oneChar", oneChar);
		return "editCharForm.jsp";
	}
	
	@GetMapping("/profile/{id}")
	public String userProfileView(Model model, @PathVariable("id") Long id, HttpSession session) {
		if(session.getAttribute("userID") == null) {
			return "redirect:/";
		}
		if(userServe.getUserById(id) == null) {
			return "redirect:/";
		}
		User oneUserId = userServe.getUserById(id);
		
		if(session.getAttribute("userID") != oneUserId.getId()) {
			return "redirect:/";
		}
		model.addAttribute("user", oneUserId);
		return "userProfile.jsp";
	}
	
}
