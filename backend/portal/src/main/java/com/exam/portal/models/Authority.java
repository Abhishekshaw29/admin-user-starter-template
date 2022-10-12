package com.exam.portal.models;

import org.springframework.security.core.GrantedAuthority;

//authority is giving role implment granted auth
public class Authority implements GrantedAuthority {

    private String authority;

    public void setAuthority(String authority) {
        this.authority = authority;
    }
    

    public Authority(String authority) {
        this.authority = authority;
    }


    public Authority() {
    }


    @Override
    public String getAuthority() {
        // TODO Auto-generated method stub
        return this.authority;
    } 


}
