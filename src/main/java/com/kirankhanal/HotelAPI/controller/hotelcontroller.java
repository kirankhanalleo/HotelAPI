package com.kirankhanal.HotelAPI.controller;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.kirankhanal.HotelAPI.repository.hotelrepository;
import com.kirankhanal.HotelAPI.model.hotel;
import com.kirankhanal.HotelAPI.service.hotelservice;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/hotels")
public class hotelcontroller {
    @Autowired
    private hotelservice hotelservice;

    @PostMapping("/create")
    public ResponseEntity<String> createNewHotel(@RequestBody hotel hotel) {
        hotelservice.createNewHotel(hotel);
        return ResponseEntity.status(HttpStatus.OK).body("Hotel created successfully.");
    }
    @GetMapping("/find")
    public ResponseEntity<List<hotel>> findAllHotels(){
        List<hotel> Hotels = new ArrayList<>(hotelservice.findAllHotels());
        return new ResponseEntity<>(Hotels,HttpStatus.OK);
    }
    @GetMapping("/find/{id}")
    public ResponseEntity<hotel> findHotelById(@PathVariable Long id){
        Optional<hotel> Hotel=hotelservice.findHotelById(id);
        return Hotel.map(hotel -> new ResponseEntity<>(hotel, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    @GetMapping("/search")
    public ResponseEntity<List<hotel>> findHotelByLocation(@RequestParam String location){
        List<hotel> Hotels = new ArrayList<>(hotelservice.findHotelByLocation(location));
        return new ResponseEntity<>(Hotels,HttpStatus.OK);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<hotel> updateHotel(@PathVariable Long id, @RequestBody hotel updatedHotel){
        hotel updated = hotelservice.updateHotel(id,updatedHotel);
        return new ResponseEntity<>(updated,HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteHotelById(@PathVariable Long id){
        hotelservice.deleteHotelById(id);
        return ResponseEntity.status(HttpStatus.OK).body("Hotel with id "+id+" deleted successfully");
    }
}
