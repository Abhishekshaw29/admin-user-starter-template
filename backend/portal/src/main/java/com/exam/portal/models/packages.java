package com.exam.portal.models;

import java.util.Date;

public class packages {
    
    private String id;
    private String packagename;
    private String startpoint;
    private String destination;
    private Date date;
    private Long price;
    private Long ticketCount;
    private String Description;
    private String Duration;


    

    
    public String getId() {
        return id;
    }


    public void setId(String id) {
        this.id = id;
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


    public Date getDate() {
        return date;
    }


    public void setDate(Date date) {
        this.date = date;
    }


    public Long getPrice() {
        return price;
    }


    public void setPrice(Long price) {
        this.price = price;
    }


    public Long getTicketCount() {
        return ticketCount;
    }


    public void setTicketCount(Long ticketCount) {
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


    public packages(String duration) {
        Duration = duration;
    }


    public packages(String id, String packagename, String startpoint, String destination, Date date, Long price,
            Long ticketCount, String description, String duration) {
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



}
