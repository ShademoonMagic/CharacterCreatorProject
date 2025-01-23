package com.cassiafrench.charcreator.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.cassiafrench.charcreator.models.Chara;
import com.cassiafrench.charcreator.services.CharacterService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class CharacterController {
	@Autowired
	private CharacterService charServe;
	
	@PostMapping("/characters/new")
	public String createChara(Model model, @Valid @ModelAttribute("newChar") Chara newChara, BindingResult result, HttpSession session) {
		if(session.getAttribute("userID") == null) {
			return "redirect:/";
		}
		if(result.hasErrors()) {
			return "newCharForm.jsp";
		} else {
			charServe.createChar(newChara);
			return "redirect:/dashboard";
		}
	}
	
	@PutMapping("/characters/{id}/edit")
	public String editOneChar(Model model, @PathVariable("id") Long id, @Valid @ModelAttribute("oneChar") Chara oneChar, BindingResult result, HttpSession session) {
		if(session.getAttribute("userID") == null) {
			return "redirect:/";
		}
		if(result.hasErrors()) {
			return "editCharForm.jsp";
		} else {
			charServe.editChar(oneChar);
			return "redirect:/dashboard";
		}
	}
	
	@DeleteMapping("/characters/{id}")
	public String deleteOneChar(@PathVariable("id") Long id, HttpSession session) {
		if(session.getAttribute("userID") == null) {
			return "redirect:/";
		}
		charServe.deleteChar(id);
		return "redirect:/dashboard";
	}
	
	@PutMapping("/characters/level-up/{id}")
	public String levelUpChar(@PathVariable("id") Long id, @ModelAttribute("oneChar") Chara oneChar, HttpSession session) {
		if(session.getAttribute("userID") == null) {
			return "redirect:/";
		}
		
		charServe.levelUpChar(oneChar, id);
		
		return "redirect:/characters/{id}";
	}
}
