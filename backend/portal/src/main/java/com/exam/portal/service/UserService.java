package com.exam.portal.service;

import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.exam.portal.models.Packages;
import com.exam.portal.models.User;
import com.exam.portal.models.UserRole;

@Service
public interface UserService {

    // creating user
    public User createUser(User user, Set<UserRole> userroles)throws Exception;

    //get user by username
    public User getByUser(String Username) throws Exception;

    public User updateUser(User user) throws Exception;

    public void deleteByUsername(String username) throws Exception;

    public List<User> getAllUserService();

    public void bookPackage(Packages packages, String username);

}
