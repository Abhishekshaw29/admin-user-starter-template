package com.exam.portal.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exam.portal.models.UserPackages;

public interface UserPackageRepository extends JpaRepository<UserPackages,Long>{

    List<UserPackages> findByUserUserId(Long userId);

}
