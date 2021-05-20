package com.notifier.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="users")
public class users {
	@Id
	@Column(name="username")
	private String username;
	@Column(name="password")
	private String password;
	@Column(name="mobile")
	private int mobile;
	@Column(name="enabled")
	private boolean enabled;
	@Column(name="email")
	private String email;
	
	public users() {
		
	}

	@Override
	public String toString() {
		return "users [username=" + username + ", password=" + password + ", mobile=" + mobile + ", enabled=" + enabled
				+ ", email=" + email + "]";
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getMobile() {
		return mobile;
	}

	public void setMobile(int mobile) {
		this.mobile = mobile;
	}

	public boolean isEnabled(boolean b) {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public users(String username, String password, int mobile, boolean enabled, String email) {
		super();
		this.username = username;
		this.password = password;
		this.mobile = mobile;
		this.enabled = enabled;
		this.email = email;
	}
	
}
