package com.notifier.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class notebook {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private int noteCount;
	private String username;
	private String notebookName;
	public notebook() {
		
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getNoteCount() {
		return noteCount;
	}
	public void setNoteCount(int noteCount) {
		this.noteCount = noteCount;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getNotebookName() {
		return notebookName;
	}
	public void setNotebookName(String notebookName) {
		this.notebookName = notebookName;
	}
	public notebook(int noteCount, String username, String notebookName) {
		super();
		this.noteCount = noteCount;
		this.username = username;
		this.notebookName = notebookName;
	}
	@Override
	public String toString() {
		return "notebook [id=" + id + ", noteCount=" + noteCount + ", username=" + username + ", notebookName="
				+ notebookName + "]";
	}
	
}
