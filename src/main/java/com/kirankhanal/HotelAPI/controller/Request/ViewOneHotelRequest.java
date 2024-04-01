package com.kirankhanal.HotelAPI.controller.Request;

import java.math.BigDecimal;

public class ViewOneHotelRequest {
    private String hotelName;
    private String location;
    private String contact;
    private Integer numberOfRooms;
    private BigDecimal rates;

    public String getHotelName() {
        return hotelName;
    }

    public String getLocation() {
        return location;
    }

    public String getContact() {
        return contact;
    }

    public Integer getNumberOfRooms() {
        return numberOfRooms;
    }

    public BigDecimal getRates() {
        return rates;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public void setNumberOfRooms(Integer numberOfRooms) {
        this.numberOfRooms = numberOfRooms;
    }

    public void setRates(BigDecimal rates) {
        this.rates = rates;
    }
}
