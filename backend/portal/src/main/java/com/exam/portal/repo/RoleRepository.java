package com.exam.portal.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.exam.portal.models.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role,Long> {
    
}