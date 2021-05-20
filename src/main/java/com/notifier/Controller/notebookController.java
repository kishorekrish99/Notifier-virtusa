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
import org.springframework.web.bind.annotation.RequestParam;

import com.notifier.Model.notebook;
import com.notifier.Model.notes;
import com.notifier.Model.users;
import com.notifier.Service.UserService;
import com.notifier.Service.notebookService;
import com.notifier.Service.noteservice;

@Controller
public class notebookController {

	@Autowired
	private notebookService notebookservice;
	
	@Autowired
	private UserService userservice;
	
	@Autowired
	private noteservice noteservice;
	
	
	@GetMapping("/notebook")
	public String notebookpage(Model model) {
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
		model.addAttribute("user", credentials);
		List<notebook> notebook=notebookservice.getnotebooks();
		List<notes> notes=noteservice.getnotes();
		for(int i=0;i<notebook.size();i++) {
				int x=1;
			for(int j=0;j<notes.size();j++) {
				if(notebook.get(i).getNotebookName().equals(notes.get(j).getNotebook())) {
					notebook.get(i).setNoteCount(x++);
				}
			}
		}
		model.addAttribute("notebook", notebook);
		model.addAttribute("book", new notebook());
		List<notes> notification = new ArrayList<notes>();
		for(int i=0;i<notes.size();i++) {
			if(notes.get(i).getRemainderDate().equals(java.time.LocalDate.now().toString()) && credentials.getUsername().equals(notes.get(i).getUsername())) {
				notification.add(notes.get(i));
			}
		}
		int totalNotifications=notification.size();
		model.addAttribute("totalNotifications",totalNotifications);
		model.addAttribute("notification",notification);
		return "notebook";
	}
	
	@GetMapping("/editnotebook")
	public String editnotebook(Model model,@RequestParam("id") int id) {
		notebook notebook=notebookservice.getbook(id);
		model.addAttribute("notebook", notebook);
		return "editnotebook";
	}
	
	@PostMapping("/savenotebook")
	public String savenotebook(@ModelAttribute("notebook") notebook notebook) {
		System.out.println(notebook);
		notebookservice.savenotebook(notebook);
		return "redirect:/notebook";
	}
	
	@GetMapping("/deletenotebook")
	public String deletenotebook(@RequestParam("id") int id) {
		notebookservice.deletenotebook(id);
		return "redirect:/notebook";
	}
	
	@PostMapping("/savenewbook")
	public String savenewbook(@ModelAttribute("book") notebook book) {
		
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
		book.setNoteCount(0);
		book.setUsername(credentials.getUsername());
		notebookservice.savenewbook(book);
		return "redirect:/notebook";
	}
}










