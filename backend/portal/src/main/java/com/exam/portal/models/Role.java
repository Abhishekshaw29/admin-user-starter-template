package com.exam.portal.models;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "roles")
public class Role {
    
    @Override
    public String toString() {
        return "Role [roleID=" + roleID + ", roleName=" + roleName + ", userRoles=" + userRoles + "]";
    }
    @Id
    private Long roleID;
    public Set<UserRole> getUserRoles() {
        return userRoles;
    }
    public void setUserRoles(Set<UserRole> userRoles) {
        this.userRoles = userRoles;
    }
    private String roleName;
    
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy = "role")
	@JsonIgnore
	private Set<UserRole> userRoles = new HashSet<>();

    public Role(Long roleID, String roleName) {
        this.roleID = roleID;
        this.roleName = roleName;
    }
    public Role() {
    }
    public Long getRoleID() {
        return roleID;
    }
    public void setRoleID(Long roleID) {
        this.roleID = roleID;
    }
    public String getRoleName() {
        return roleName;
    }
    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

}
