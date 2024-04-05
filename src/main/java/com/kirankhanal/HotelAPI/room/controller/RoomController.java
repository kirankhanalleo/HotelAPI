package com.kirankhanal.HotelAPI.room.controller;

import com.kirankhanal.HotelAPI.room.controller.Request.CreateRoomRequest;
import com.kirankhanal.HotelAPI.room.controller.Request.ViewRoomsRequest;
import com.kirankhanal.HotelAPI.room.service.RoomService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/rooms")
public class RoomController {
    @Autowired
    private RoomService roomService;
    @PostMapping("/create")
    public ResponseEntity<String> createNewRoom(@Valid @RequestBody CreateRoomRequest createRoomRequest){
        roomService.createNewRoom(createRoomRequest);
        return ResponseEntity.status(HttpStatus.OK).body("Room created successfully");
    }
    @GetMapping("/find")
    public ResponseEntity<List<ViewRoomsRequest>> findAllRooms(){
        List<ViewRoomsRequest> rooms = roomService.findAllRooms();
        return new ResponseEntity<>(rooms,HttpStatus.OK);
    }
}
