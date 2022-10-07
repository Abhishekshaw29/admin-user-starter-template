package com.exam.portal.models;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class UserRole {
    
    public UserRole() {
    }

    public UserRole(User user, Role role) {
  
        this.user = user;
        this.role = role;
    }

    @Override
    public String toString() {
        return "UserRole [userRoleId=" + userRoleId + ", user=" + user + ", role=" + role + "]";
    }

    public Long getUserRoleId() {
        return userRoleId;
    }

    public void setUserRoleId(Long userRoleId) {
        this.userRoleId = userRoleId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long userRoleId;
    //one user can have many role

    @ManyToOne(fetch = FetchType.EAGER)
    private User user;

    //one role can have many user
    @ManyToOne(fetch = FetchType.EAGER)
    private Role role;


}
