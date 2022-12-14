package com.exam.portal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.exam.portal.config.JwtUtils;
import com.exam.portal.models.Packages;
import com.exam.portal.models.Role;
import com.exam.portal.models.User;
import com.exam.portal.models.UserPackages;
import com.exam.portal.models.UserRole;
import com.exam.portal.repo.PackagesRepository;
import com.exam.portal.repo.UserRepository;
import com.exam.portal.service.UserPackageService;
import java.util.*;

@RestController
public class UserPackageController {
    
    @Autowired
    private UserPackageService userPackageService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PackagesRepository packagesRepository;
}
