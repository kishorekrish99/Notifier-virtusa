package com.notifier.Service;

import java.util.List;

import com.notifier.Model.users;

public interface UserService {

	public List<users> getUsers();

	public void edituser(users user);

}
