package com.notifier.Service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.notifier.DAO.UserDAO;
import com.notifier.Model.users;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDAO userdao;

	@Override
	@Transactional
	public List<users> getUsers() {
		return userdao.getUsers();
	}

	@Override
	@Transactional
	public void edituser(users user) {
		userdao.edituser(user);
		
	}
}
