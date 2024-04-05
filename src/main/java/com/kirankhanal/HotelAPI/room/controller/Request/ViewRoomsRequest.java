package com.kirankhanal.HotelAPI.room.controller.Request;

import com.kirankhanal.HotelAPI.room.RoomStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ViewRoomsRequest {
    public String roomType;
    private String roomDesc;
    private Integer capacity;
    private Integer rates;
    private String roomStatus;
//    private List<String> availableDates;
}
