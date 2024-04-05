package com.kirankhanal.HotelAPI.room.service;

import com.kirankhanal.HotelAPI.room.controller.Request.CreateRoomRequest;
import com.kirankhanal.HotelAPI.room.controller.Request.ViewRoomsRequest;

import java.util.List;

public interface RoomService {
    public void createNewRoom(CreateRoomRequest createRoomRequest);
    public List<ViewRoomsRequest> findAllRooms();
}
