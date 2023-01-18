package com.pnt.service;

import java.util.List;

import com.pnt.model.intern.Intern;
import com.pnt.model.user.User;

public interface InternService {
	public Intern addIntern(Intern internr);
	public Intern updateIntern(Intern intern);
	public List<Intern> getAll();
	public void deleteIntern(Long id);
}
