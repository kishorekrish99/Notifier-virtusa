package com.notifier.DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.notifier.Model.notebook;

@Repository
public class notebookDAOImpl implements notebookDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<notebook> getnotebooks() {
		Session session=sessionFactory.getCurrentSession();
		Query<notebook> query=session.createQuery("from notebook",notebook.class);
		List<notebook> notebook=query.getResultList();
		return notebook;
	}

	@Override
	public notebook getbook(int id) {
		Session session=sessionFactory.getCurrentSession();
		notebook notebook=session.get(notebook.class, id);
		return notebook;
	}

	@Override
	public void savenotebook(notebook notebook) {
		Session session=sessionFactory.getCurrentSession();
		session.saveOrUpdate(notebook);
		
	}

	@Override
	public void deletenotebook(int id) {
		Session session=sessionFactory.getCurrentSession();
		Query thequery=session.createQuery("delete from notebook where id=:noteid");
		thequery.setParameter("noteid",id);
		thequery.executeUpdate();
		
	}

	@Override
	public void savenewbook(notebook book) {
		Session session=sessionFactory.getCurrentSession();
		session.save(book);
		
	}
	
}
