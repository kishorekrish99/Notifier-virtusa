package com.notifier.DAO;

import java.util.List;

import com.notifier.Model.notebook;

public interface notebookDAO {

	public List<notebook> getnotebooks();

	public notebook getbook(int id);

	public void savenotebook(notebook notebook);

	public void deletenotebook(int id);

	public void savenewbook(notebook book);


}
