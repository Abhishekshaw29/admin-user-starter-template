package com.exam.portal.models;

import javax.persistence.*;

@Entity
public class UserPackages {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long userPackageId;
    //one user can have many role
    @ManyToOne(fetch = FetchType.EAGER)
    private User user;
    @ManyToOne(fetch = FetchType.EAGER)
    private Packages packages;


    
    public UserPackages( User user, Packages packages) {
        this.user = user;
        this.packages = packages;
    }
    public UserPackages() {
    }
    public Long getUserPackageId() {
        return userPackageId;
    }
    public void setUserPackageId(Long userPackageId) {
        this.userPackageId = userPackageId;
    }
    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }
    public Packages getPackages() {
        return packages;
    }
    public void setPackages(Packages packages) {
        this.packages = packages;
    }



    
}
