package com.notifier.Controller;

import java.util.ArrayList;
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

import com.notifier.Model.notes;
import com.notifier.Model.users;
import com.notifier.Service.UserService;
import com.notifier.Service.noteservice;
@Controller	
public class AppController {
	
	@Autowired
	private UserService userservice;
	
	@Autowired
	private noteservice noteservice;
	
	
	
	@GetMapping("/showMyLoginPage")
	public String showLoginPage() {
		return "fancy-login";
	}
	
	
	
	@GetMapping("/")
	public String showHome(Model model) {
		//SecurityContext context=SecurityContextHolder.getContext() ;
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		User p=(User) authentication.getPrincipal();
		Object q=authentication.getCredentials();
		//System.out.println(p.getUsername());
		
		List<users> user=userservice.getUsers();
		users credentials = null;
		//System.out.println(user.get(1).getUsername());
		for(int i=0;i<user.size();i++) {
			if(user.get(i).getUsername().equals(p.getUsername())) {
				credentials=user.get(i);
				
			}
		}
	
	model.addAttribute("user", credentials);
	
	List<notes> notes=noteservice.getnotes();
	
	List<notes> notification = new ArrayList<notes>();
	for(int i=0;i<notes.size();i++) {
		if(notes.get(i).getRemainderDate().equals(java.time.LocalDate.now().toString()) && credentials.getUsername().equals(notes.get(i).getUsername())) {
			notification.add(notes.get(i));
		}
	}
	
	
	int totalNotifications=notification.size();
	model.addAttribute("totalNotifications",totalNotifications);
	model.addAttribute("notification",notification);
	model.addAttribute("notes", notes);
	
	return "home";
	}
	
	
	@PostMapping("/edituser")
	public String edituser(@ModelAttribute("signup") users user) {
		userservice.edituser(user);
	return "redirect:/";	
	}
	
}