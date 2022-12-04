package com.pnt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pnt.model.user.Role;

public interface RoleRepo extends JpaRepository<Role, Long>{

}
