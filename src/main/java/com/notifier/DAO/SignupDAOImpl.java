package com.notifier.DAO;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.notifier.Model.authorities;
import com.notifier.Model.users;

@Repository
public class SignupDAOImpl implements SignupDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void signupuser(users user) {
		user.setEnabled(true);
		String password="{noop}"+user.getPassword();
		user.setPassword(password);
		Session session=sessionFactory.getCurrentSession();
		authorities auth=new authorities();
		auth.setName(user.getUsername());
		auth.setAuthority("ROLE_USER");
		session.saveOrUpdate(user);
		session.saveOrUpdate(auth);
		
	}

}
