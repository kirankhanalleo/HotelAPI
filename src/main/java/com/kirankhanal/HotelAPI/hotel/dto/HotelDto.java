package com.kirankhanal.HotelAPI.hotel.dto;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HotelDto  {
    private String hotelName;
    private String location;
    private String contact;
    private Integer numberOfRooms;
    }
