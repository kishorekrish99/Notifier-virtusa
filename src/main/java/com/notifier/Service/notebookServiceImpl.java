package com.notifier.Service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.notifier.DAO.notebookDAO;
import com.notifier.Model.notebook;

@Service
public class notebookServiceImpl implements notebookService {

	@Autowired
	private notebookDAO notebookdao;

	@Override
	@Transactional
	public List<notebook> getnotebooks() {
		return notebookdao.getnotebooks();
	}

	@Override
	@Transactional
	public notebook getbook(int id) {
		return notebookdao.getbook(id);
	}

	@Override
	@Transactional
	public void savenotebook(notebook notebook) {
		notebookdao.savenotebook(notebook);
		
	}

	@Override
	@Transactional
	public void deletenotebook(int id) {
		notebookdao.deletenotebook(id);
		
	}

	@Override
	@Transactional
	public void savenewbook(notebook book) {
		notebookdao.savenewbook(book);
		
	}

}
