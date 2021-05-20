package com.notifier.Service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.notifier.DAO.noteDAO;
import com.notifier.Model.notes;

@Service
public class noteserviceImpl implements noteservice {
	
	@Autowired
	private noteDAO notedao;
	
	@Override
	@Transactional
	public List<notes> getnotes() {
		return notedao.getnotes();
	}

	@Override
	@Transactional
	public void savenote(notes note) {
		notedao.savenote(note);
		
	}

	@Override
	@Transactional
	public notes getbook(int id) {
		return notedao.getbook(id);
	}

	@Override
	@Transactional
	public void deletenote(int id) {
		notedao.deletenote(id);
	}

}
