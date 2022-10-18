package com.exam.portal.models;

import java.util.Date;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.*;


@JsonIgnoreProperties({"hibernateLazyInitializer"})
@Entity
public class Packages {
    
    @Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String packagename;
    private String startpoint;
    private String destination;
    private String date;
    private Long price;



    private String photo="https://res.cloudinary.com/dxssqb6l8/image/upload/v1605293736/james-wheeler_xqmq2y.jpg";
    private Integer ticketCount;
    private String Description;
    private String Duration;
    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy = "packages")
	private Set<UserPackages> UserPackages = new HashSet<>();
    public String getPhoto() {
        return photo;
    }
    public void setPhoto(String photo) {
        this.photo = photo;
    }

    

    public Packages() {
    }
    public Set<UserPackages> getUserPackages() {
        return UserPackages;
    }
    public void setUserPackages(Set<UserPackages> userPackages) {
        UserPackages = userPackages;
    }
    public String getDate() {
        return date;
    }
    public void setDate(String date) {
        this.date = date;
    }
    public String getPackagename() {
        return packagename;
    }
    public void setPackagename(String packagename) {
        this.packagename = packagename;
    }
    public String getStartpoint() {
        return startpoint;
    }
    public void setStartpoint(String startpoint) {
        this.startpoint = startpoint;
    }
    public String getDestination() {
        return destination;
    }
    public void setDestination(String destination) {
        this.destination = destination;
    }
    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }


    public Integer getTicketCount() {
        return ticketCount;
    }


    public void setTicketCount(Integer ticketCount) {
        this.ticketCount = ticketCount;
    }


    public String getDescription() {
        return Description;
    }


    public void setDescription(String description) {
        Description = description;
    }


    public String getDuration() {
        return Duration;
    }


    public void setDuration(String duration) {
        Duration = duration;
    }


    public Packages(String duration) {
        Duration = duration;
    }


    public Packages(Long id, String packagename, String startpoint, String destination, String date, Long price,
            Integer ticketCount, String description, String duration) {
        this.id = id;
        this.packagename = packagename;
        this.startpoint = startpoint;
        this.destination = destination;
        this.date = date;
        this.price = price;
        this.ticketCount = ticketCount;
        Description = description;
        Duration = duration;
    }
    public Long getId() {
        return id;
    }


    public void setId(Long id) {
        this.id = id;
    }

}
