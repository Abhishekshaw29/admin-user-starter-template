package com.exam.portal.serviceimpl;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exam.portal.models.Packages;
import com.exam.portal.models.User;
import com.exam.portal.models.UserPackages;
import com.exam.portal.models.UserRole;
import com.exam.portal.repo.PackagesRepository;
import com.exam.portal.repo.RoleRepository;
import com.exam.portal.repo.UserRepository;
import com.exam.portal.service.UserService;

@Service
public class userServiceimpl implements UserService{

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PackagesRepository packagesRepository;

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

    @Override
    public User updateUser(User user) throws Exception {
        User local = getByUser(user.getUserName());
        
        local.setProfile(user.getProfile());
        local.setEmail(user.getEmail());
        local.setFirstName(user.getFirstName());
        local.setLastName(user.getLastName());
        local.setPhone(user.getPhone());
        local.setPassword(user.getPassword());
        this.userRepository.save(local);
        return local;
    }

    @Override
    public void deleteByUsername(String username) throws Exception {
        // TODO Auto-generated method stub

        User user = this.getByUser(username);
        this.userRepository.delete(user);
    }

    @Override
    public List<User> getAllUserService() {
        // TODO Auto-generated method stub
        List<User> list = this.userRepository.findAll();
        return list;
    }

    @Override
    public User bookPackage(Long userId, Long packageId) {
        // TODO Auto-generated method stub
        User user = this.userRepository.findById(userId).get();
        Packages pack = this.packagesRepository.findById(packageId).get();
        pack.setTicketCount(pack.getTicketCount()-1);
        user.addPackage(pack);
        return userRepository.save(user);
       
    }

    @Override
    public List<Packages> getAllBookings(Long userId) {
        User user = this.userRepository.findById(userId).get();
        return user.getPackageList();
    }
    
}
