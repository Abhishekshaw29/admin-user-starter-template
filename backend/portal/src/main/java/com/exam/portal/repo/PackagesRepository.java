package com.exam.portal.repo;
import com.exam.portal.models.Packages;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PackagesRepository  extends JpaRepository<Packages,Long>{
    
}
