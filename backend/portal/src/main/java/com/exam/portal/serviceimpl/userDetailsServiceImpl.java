package com.exam.portal.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.exam.portal.models.User;
import com.exam.portal.repo.UserRepository;
import com.exam.portal.service.UserService;

//get user by username spring security load name by name
@Service
public class userDetailsServiceImpl implements  UserDetailsService{
    
    @Autowired
    private UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // TODO Auto-generated method stub
        User user =  this.userRepository.findByUsername(username);
        if(user ==  null){
            System.out.println("user not found in db");
            throw new UsernameNotFoundException("no user found");
        }
        return user;
        
    }
    
}
