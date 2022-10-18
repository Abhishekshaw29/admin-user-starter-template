package com.exam.portal.controller;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.exam.portal.exception.PackageNotFoundException;
import com.exam.portal.models.Packages;
import com.exam.portal.service.PackagesService;

@RestController
@CrossOrigin("*")
@RequestMapping("/packages")
public class PackagesController {

    @Autowired
    private PackagesService packagesService;

    @GetMapping("/{packageId}")
    public Packages getPackage(@PathVariable("packageId") Long packageId) throws PackageNotFoundException{
       return this.packagesService.getPackageById(packageId);
       
    }
    
    @PostMapping("/")
    public ResponseEntity<?> createPackage(@RequestBody Packages packages) throws Exception{
        this.packagesService.createPackage(packages);
        return ResponseEntity.ok("created");
    }
    @DeleteMapping("delete/{packageId}")
    public ResponseEntity<?> deletePackage(@PathVariable("packageId") Long packageId) throws PackageNotFoundException{
        this.packagesService.deletePackage(packageId);
        return ResponseEntity.ok("Deleted Successfully");
       
    }

    @GetMapping("/all")
    public List<Packages> getAllPackages() throws Exception{
        return this.packagesService.findAllPackages();
    }

    @PutMapping("/update")
    public Packages updatePackages(@RequestBody Packages packages ) throws Exception{
        return this.packagesService.updatePackage(packages);
    }
    @GetMapping("/getpackagecount/{packageId}")
    public Integer getPackageTickets(@PathVariable("PackageId") Long packageId){
        return this.packagesService.getTicketCount(packageId);
    }
}
