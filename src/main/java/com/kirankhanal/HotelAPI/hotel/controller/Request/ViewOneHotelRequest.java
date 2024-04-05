package com.kirankhanal.HotelAPI.hotel.controller.Request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ViewOneHotelRequest {
    private String hotelName;
    private String location;
    private String contact;
    private Integer numberOfRooms;
    private BigDecimal rates;

}
