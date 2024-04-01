package com.kirankhanal.HotelAPI.controller.Request;

import jakarta.validation.Valid;
import jakarta.validation.constraints.*;

import java.math.BigDecimal;

public class CreateHotelRequest {
    @Valid
    @NotEmpty(message = "The hotel name field cannot be empty")
    private String hotelName;
    @NotEmpty(message = "Location field cannot be empty")
    private String location;
    @NotEmpty(message = "Contact field cannot be empty")
    private String contact;
    @NotNull(message = "Number of rooms cannot be empty")
    @Min(1)
    private Integer numberOfRooms;
    @NotNull(message = "Rates cannot be empty")
    @Positive
    private BigDecimal rates;

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public Integer getNumberOfRooms() {
        return numberOfRooms;
    }

    public void setNumberOfRooms(Integer numberOfRooms) {
        this.numberOfRooms = numberOfRooms;
    }

    public BigDecimal getRates() {
        return rates;
    }

    public void setRates(BigDecimal rates) {
        this.rates = rates;
    }

    public CreateHotelRequest(String hotelName, String location, String contact, Integer numberOfRooms, BigDecimal rates) {
        this.hotelName = hotelName;
        this.location = location;
        this.contact = contact;
        this.numberOfRooms = numberOfRooms;
        this.rates = rates;
    }

}
