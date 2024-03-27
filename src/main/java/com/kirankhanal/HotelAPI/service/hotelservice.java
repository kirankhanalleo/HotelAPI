package com.kirankhanal.HotelAPI.service;

import com.kirankhanal.HotelAPI.model.hotel;
import com.kirankhanal.HotelAPI.repository.hotelrepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
}
