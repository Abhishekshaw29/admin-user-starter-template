package com.exam.portal.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exam.portal.exception.PackageNotFoundException;
import com.exam.portal.models.Packages;
import com.exam.portal.models.User;
import com.exam.portal.repo.PackagesRepository;
import com.exam.portal.service.PackagesService;


@Service
public class PackagesServiceimpl implements PackagesService{
    
    @Autowired
    private PackagesRepository packagesRepository;

    @Override
    public Packages getPackageById(Long packageId) {
        // TODO Auto-generated method stub
        return this.packagesRepository.getById(packageId);
    }

    @Override
    public void createPackage(Packages packages) {
        // TODO Auto-generated method stub
        this.packagesRepository.save(packages);

    }

    @Override
    public void deletePackage(Long packageId) throws PackageNotFoundException {
        Packages local = this.getPackageById(packageId);
        this.packagesRepository.delete(local);
    }

    @Override
    public List<Packages> findAllPackages() {
        // TODO Auto-generated method stub
        return this.packagesRepository.findAll();
    }

    @Override
    public Packages updatePackage(Packages packages) {
        // TODO Auto-generated method stub
        Packages local  = this.getPackageById(packages.getId());
        local.setDescription(packages.getDescription());
        local.setPrice(packages.getPrice());
        return local;
    }

    @Override
    public Integer getTicketCount(Long packageId) {
        // TODO Auto-generated method stub
        Packages local  = this.getPackageById(packageId);
        return local.getTicketCount();
    }
    
}
