package com.notifier.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.notifier.Model.notebook;
import com.notifier.Model.notes;
import com.notifier.Model.users;
import com.notifier.Service.UserService;
import com.notifier.Service.notebookService;
import com.notifier.Service.noteservice;

@Controller
public class NoteController {
		
	@Autowired
	private notebookService notebookservice;
	
	@Autowired
	private noteservice noteservice;
	
	@Autowired
	private UserService userservice;
	
	
	@GetMapping("/addnotes")
	public String addnotes(Model model) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		User p=(User) authentication.getPrincipal();
		Object q=authentication.getCredentials();
		List<users> user=userservice.getUsers();
		users credentials = null;
		for(int i=0;i<user.size();i++) {
			if(user.get(i).getUsername().equals(p.getUsername())) {
				credentials=user.get(i);				
			}
		}
		model.addAttribute("credentials", credentials);
		model.addAttribute("note", new notes());
		List<notebook> notebook=notebookservice.getnotebooks();
		model.addAttribute("notebook", notebook);
		return "addnotes";
	}
	
	@PostMapping("/savenotes")
	public String savenote(@ModelAttribute("note") notes note) {
				Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
				User p=(User) authentication.getPrincipal();
				Object q=authentication.getCredentials();
				List<users> user=userservice.getUsers();
				users credentials = null;
				for(int i=0;i<user.size();i++) {
					if(user.get(i).getUsername().equals(p.getUsername())) {
						credentials=user.get(i);				
					}
				}
		note.setUsername(credentials.getUsername());
		noteservice.savenote(note);
		
		List<notebook> notebooks=notebookservice.getnotebooks();
		for(int i=0;i<notebooks.size();i++) {
			if(note.getNotebook().equals(notebooks.get(i).getNotebookName())) {
				
			}
		}
		note.getNotebook();
		return "redirect:/";
	}
	
	@GetMapping("/editnote")
	public String editnote(Model model,@RequestParam("id") int id) {
		notes note=noteservice.getbook(id);
		model.addAttribute("note", note);
		List<notebook> notebook=notebookservice.getnotebooks();
		model.addAttribute("notebook", notebook);
		return "addnotes";
	}
	
	@GetMapping("/deletenote")
	public String deletenote(@RequestParam("id") int id) {
		noteservice.deletenote(id);
		return "redirect:/";
	}
	
	@GetMapping("/open")
	public String open(@RequestParam("id") int id,Model model) {
		notes note=noteservice.getbook(id);
		model.addAttribute("note", note);
		return "individualnote";
	}
	
}
