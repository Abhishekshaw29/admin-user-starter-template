package com.exam.portal.models;

import java.util.Date;

public class Travel {

    private String id;
    private String busname;
    private String startPoint;
    private String endPoint;
    private Date date;
    private Long price;
    private Long ticketCount;
    private String startime;
    private String endtime;
    
    public Travel() {
    }
    public Travel(String id, String busname, String startPoint, String endPoint, Date date, Long price,
            Long ticketCount, String startime, String endtime) {
        this.id = id;
        this.busname = busname;
        this.startPoint = startPoint;
        this.endPoint = endPoint;
        this.date = date;
        this.price = price;
        this.ticketCount = ticketCount;
        this.startime = startime;
        this.endtime = endtime;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getBusname() {
        return busname;
    }
    public void setBusname(String busname) {
        this.busname = busname;
    }
    public String getStartPoint() {
        return startPoint;
    }
    public void setStartPoint(String startPoint) {
        this.startPoint = startPoint;
    }
    public String getEndPoint() {
        return endPoint;
    }
    public void setEndPoint(String endPoint) {
        this.endPoint = endPoint;
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
    public String getStartime() {
        return startime;
    }
    public void setStartime(String startime) {
        this.startime = startime;
    }
    public String getEndtime() {
        return endtime;
    }
    public void setEndtime(String endtime) {
        this.endtime = endtime;
    }


}
