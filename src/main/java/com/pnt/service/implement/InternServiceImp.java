package com.pnt.service.implement;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pnt.model.intern.Intern;
import com.pnt.model.user.User;
import com.pnt.repository.InternRepo;
import com.pnt.service.InternService;

@Service
@Transactional
public class InternServiceImp implements InternService{
	@Autowired
	private InternRepo internrepo;
	
	@Override
	public Intern addIntern(Intern intern) {
		// TODO Auto-generated method stub	
		return this.internrepo.save(intern);
	}

	@Override
	public Intern updateIntern(Intern intern) {
		// TODO Auto-generated method stub
		return this.internrepo.save(intern);
	}

	@Override
	public List<Intern> getAll() {
		// TODO Auto-generated method stub
		return this.internrepo.findAll();
	}

	@Override
	public void deleteIntern(Long id) {
		// TODO Auto-generated method stub
		this.internrepo.delete(id);
	}

}
