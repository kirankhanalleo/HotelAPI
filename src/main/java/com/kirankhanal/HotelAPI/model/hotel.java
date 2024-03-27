package com.kirankhanal.HotelAPI.model;

import jakarta.persistence.*;

import java.math.BigDecimal;


@Entity
@Table(name="hotel")
public class hotel {
    //Basic Fields
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long hotelID;
    @Column(name="hotelName")
    private String hotelName;
    @Column(name="location")
    private String location;
    @Column(name="contact")
    private String contact;
    @Column(name="numberOfRooms")
    private int numberOfRooms;
    @Column(name="rates")
    private BigDecimal rates;

    //GETTER METHODS

    public Long getHotelID() {
        return hotelID;
    }

    public String getHotelName() {
        return hotelName;
    }

    public String getLocation() {
        return location;
    }

    public String getContact() {
        return contact;
    }

    public int getNumberOfRooms() {
        return numberOfRooms;
    }

    public BigDecimal getRates() {
        return rates;
    }
    //SETTER METHODS

    public void setHotelID(Long hotelID) {
        this.hotelID = hotelID;
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

    public void setNumberOfRooms(int numberOfRooms) {
        this.numberOfRooms = numberOfRooms;
    }

    public void setRates(BigDecimal rates) {
        this.rates = rates;
    }
    //Parameterized Constructor

    public hotel(Long hotelID, String hotelName, String location, String contact, int numberOfRooms, BigDecimal rates) {
        this.hotelID = hotelID;
        this.hotelName = hotelName;
        this.location = location;
        this.contact = contact;
        this.numberOfRooms = numberOfRooms;
        this.rates = rates;
    }
    //Default Constructor
    public hotel(){
    }

    //Method for printing
    @Override
    public String toString() {
        return "hotel{" +
                "hotelID=" + hotelID +
                ", hotelName='" + hotelName + '\'' +
                ", location='" + location + '\'' +
                ", contact='" + contact + '\'' +
                ", numberOfRooms=" + numberOfRooms +
                ", rates=" + rates +
                '}';
    }
}
