package com.kirankhanal.HotelAPI.room.service;

import com.kirankhanal.HotelAPI.room.Room;
import com.kirankhanal.HotelAPI.room.controller.Request.CreateRoomRequest;
import com.kirankhanal.HotelAPI.room.controller.Request.ViewRoomsRequest;
import com.kirankhanal.HotelAPI.room.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RoomServiceImpl implements RoomService {
    @Autowired
    private RoomRepository roomRepository;
    @Override
    public void createNewRoom(CreateRoomRequest createRoomRequest){
        Room room = new Room();
        room.setRoomType(createRoomRequest.getRoomType());
        room.setRoomDesc(createRoomRequest.getRoomDesc());
        room.setRoomStatus(createRoomRequest.getRoomStatus());
        room.setCapacity(createRoomRequest.getCapacity());
        room.setRates(createRoomRequest.getRates());
//        room.setAvailableDates(createRoomRequest.getAvailableDates());
        roomRepository.save(room);
    }

    @Override
    public List<ViewRoomsRequest> findAllRooms() {
        List<ViewRoomsRequest> viewRoomsRequests = new ArrayList<>();
        for(Room room: roomRepository.findAll()){
            ViewRoomsRequest viewRoomRequest = new ViewRoomsRequest();
            viewRoomRequest.setRoomType(room.getRoomType());
            viewRoomRequest.setRoomDesc(room.getRoomDesc());
            viewRoomRequest.setRoomStatus(room.getRoomStatus());
            viewRoomRequest.setCapacity(room.getCapacity());
            viewRoomRequest.setRates(room.getRates());
//            viewRoomRequest.setAvailableDates(room.getAvailableDates());
            viewRoomsRequests.add(viewRoomRequest);
        }
        return viewRoomsRequests;
    }
}
