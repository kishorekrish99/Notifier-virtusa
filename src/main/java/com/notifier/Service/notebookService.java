package com.notifier.Service;

import java.util.List;

import com.notifier.Model.notebook;

public interface notebookService {

	public List<notebook> getnotebooks();

	public notebook getbook(int id);

	public void savenotebook(notebook notebook);

	public void deletenotebook(int id);

	public void savenewbook(notebook book);

	

}
