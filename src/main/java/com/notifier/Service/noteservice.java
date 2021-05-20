package com.notifier.Service;

import java.util.List;

import com.notifier.Model.notes;

public interface noteservice {

	public List<notes> getnotes();

	public void savenote(notes note);

	public notes getbook(int id);

	public void deletenote(int id);

}
