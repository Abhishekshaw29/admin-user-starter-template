package com.exam.portal.serviceimpl;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exam.portal.models.User;
import com.exam.portal.models.UserRole;
import com.exam.portal.repo.RoleRepository;
import com.exam.portal.repo.UserRepository;
import com.exam.portal.service.UserService;

@Service
public class userServiceimpl implements UserService{

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;

    //create user using role
    @Override
    public User createUser(User user, Set<UserRole> userRoles) throws Exception {
        // TODO Auto-generated method stub

       User local =  this.userRepository.findByUsername(user.getUserName());
       if(local != null){
        throw new Exception("user already present");
       }
       else{
        for (UserRole ur : userRoles) {
            roleRepository.save(ur.getRole());
        }
        user.getUserRoles().addAll(userRoles);
        local = this.userRepository.save(user);
       }
       return local;
    }

    @Override
    public User getByUser(String Username) throws Exception {
        // TODO Auto-generated method stub
        return this.userRepository.findByUsername(Username);
    }
    
}
