package com.kirankhanal.HotelAPI.room.controller.Request;

import com.kirankhanal.HotelAPI.room.RoomStatus;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateRoomRequest {
    @Valid
    @NotEmpty(message="The room type field cannot be empty")
    private String roomType;
    @NotEmpty(message = "The room description field cannot be empty")
    private String roomDesc;
    @NotEmpty(message = "The capacity field cannot be empty")
    private Integer capacity;
    @NotEmpty(message = "The rates field cannot be empty")
    private Integer rates;
    private String roomStatus;
//    private List<String> availableDates;
}
