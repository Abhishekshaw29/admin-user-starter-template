package com.exam.portal.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.exam.portal.exception.PackageNotFoundException;
import com.exam.portal.models.Packages;

@Service
public interface PackagesService {

    Packages getPackageById(Long packageId);

    void createPackage(Packages packages);

    void deletePackage(Long packageId) throws PackageNotFoundException;

    List<Packages> findAllPackages();

    Packages updatePackage(Packages packages);

    Integer getTicketCount(Long packageId);
    
}
