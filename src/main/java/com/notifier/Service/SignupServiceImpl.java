package com.notifier.Service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.notifier.DAO.SignupDAO;
import com.notifier.Model.users;

@Service
public class SignupServiceImpl implements SignupService {

	@Autowired
	private SignupDAO signupdao;
	
	@Override
	@Transactional
	public void signupuser(users user) {
		signupdao.signupuser(user);
	}

}
