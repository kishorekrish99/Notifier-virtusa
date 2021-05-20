package com.notifier.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class notes {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String title;
	private String startDate;
	private String endDate;
	private String description;
	private String status;
	private String remainderDate;
	private String username;
	private String notebook;
	public notes() {
		
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getRemainderDate() {
		return remainderDate;
	}
	public void setRemainderDate(String remainderDate) {
		this.remainderDate = remainderDate;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getNotebook() {
		return notebook;
	}
	public void setNotebook(String notebook) {
		this.notebook = notebook;
	}
	public notes(String title, String startDate, String endDate, String description, String status,
			String remainderDate, String username, String notebook) {
		super();
		this.title = title;
		this.startDate = startDate;
		this.endDate = endDate;
		this.description = description;
		this.status = status;
		this.remainderDate = remainderDate;
		this.username = username;
		this.notebook = notebook;
	}
	@Override
	public String toString() {
		return "notes [id=" + id + ", title=" + title + ", startDate=" + startDate + ", endDate=" + endDate
				+ ", description=" + description + ", status=" + status + ", remainderDate=" + remainderDate
				+ ", username=" + username + ", notebook=" + notebook + "]";
	}
		
}
