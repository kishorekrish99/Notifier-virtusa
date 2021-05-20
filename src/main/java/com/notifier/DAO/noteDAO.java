package com.notifier.DAO;

import java.util.List;

import com.notifier.Model.notes;

public interface noteDAO {

	public List<notes> getnotes();

	public void savenote(notes note);

	public notes getbook(int id);

	public void deletenote(int id);

}
