package com.notifier.DAO;

import java.util.List;

import com.notifier.Model.users;

public interface UserDAO {

	public List<users> getUsers();

	public void edituser(users user);

	

}
