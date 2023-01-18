package com.pnt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pnt.model.intern.Intern;

public interface InternRepo extends JpaRepository<Intern, Long>{

}
