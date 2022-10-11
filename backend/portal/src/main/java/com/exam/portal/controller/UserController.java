package com.exam.portal.controller;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exam.portal.models.Role;
import com.exam.portal.models.User;
import com.exam.portal.models.UserRole;
import com.exam.portal.service.UserService;

@RestController
@CrossOrigin("*")
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;


    @PostMapping("/")
    public User createUser(@RequestBody User user) throws Exception {
        Set<UserRole> userRoleSet = new HashSet<>();
        Role role2 = new Role(2L, "USER");
        UserRole userRole = new UserRole(user, role2);
        userRoleSet.add(userRole);
        User temp = this.userService.createUser(user, userRoleSet);
        return temp;
    }
    @GetMapping("/{username}")
    public User getUser(@PathVariable("username") String username) throws Exception{
        return this.userService.getByUser(username);
    }
    @PutMapping("/update")
    public User updateUser(@RequestBody User user)throws Exception{
        return this.userService.updateUser(user);
    }

    @DeleteMapping("/delete/{username}")
    public ResponseEntity<?> deleteUser(@PathVariable("username") String username)throws Exception{
        this.userService.deleteByUsername(username);
        return ResponseEntity.ok("Deleted");
    }

    
}
