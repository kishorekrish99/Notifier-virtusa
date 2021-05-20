package com.notifier.DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.notifier.Model.users;

@Repository
public class USerDAOImpl implements UserDAO {
		
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<users> getUsers() {
		Session session=sessionFactory.getCurrentSession();
		Query<users> query=session.createQuery("from users",users.class);
		List<users> users=query.getResultList();
		return users;
	}

	@Override
	public void edituser(users user) {
		Session session=sessionFactory.getCurrentSession();
		user.setEnabled(true);
		session.saveOrUpdate(user);
		
	}

	
}
