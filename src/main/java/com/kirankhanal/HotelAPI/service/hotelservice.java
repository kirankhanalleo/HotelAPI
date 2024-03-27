package com.kirankhanal.HotelAPI.service;

import com.kirankhanal.HotelAPI.model.hotel;
import com.kirankhanal.HotelAPI.repository.hotelrepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class hotelservice {
    @Autowired
    private hotelrepository hotelrepository;

    public void createNewHotel(hotel hotel){
        hotelrepository.save(hotel);
    }
    public List<hotel> findAllHotels() {
        return hotelrepository.findAll();
    }

    public Optional<hotel> findHotelById(Long id){
        return hotelrepository.findById(id);
    }
    public List<hotel> findHotelByLocation(String location){
        return hotelrepository.findByLocation(location);
    }
}
