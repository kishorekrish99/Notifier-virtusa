package com.notifier.DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.notifier.Model.notebook;
import com.notifier.Model.notes;

@Repository
public class noteDAOImpl implements noteDAO {
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<notes> getnotes() {
		Session session=sessionFactory.getCurrentSession();
		Query<notes> query=session.createQuery("from notes",notes.class);
		List<notes> book=query.getResultList();
		return book;
	}

	@Override
	public void savenote(notes note) {
		Session session=sessionFactory.getCurrentSession();
		session.saveOrUpdate(note);
	}

	@Override
	public notes getbook(int id) {
		Session session=sessionFactory.getCurrentSession();
		notes book=session.get(notes.class, id);
		return book;
	}

	@Override
	public void deletenote(int id) {
		Session session=sessionFactory.getCurrentSession();
		Query thequery=session.createQuery("delete from notes where id=:noteid");
		thequery.setParameter("noteid",id);
		thequery.executeUpdate();
		
	}
}
