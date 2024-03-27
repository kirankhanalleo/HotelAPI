package com.kirankhanal.HotelAPI.service;

import com.kirankhanal.HotelAPI.model.hotel;
import com.kirankhanal.HotelAPI.repository.hotelrepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
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
    @Transactional
    public hotel updateHotel(Long id, hotel updatedHotel){
        Optional<hotel> hotelInstance = hotelrepository.findById(id);
        if(hotelInstance.isPresent()){
            hotel existingHotel=hotelInstance.get();
            existingHotel.setHotelName(updatedHotel.getHotelName());
            existingHotel.setLocation(updatedHotel.getLocation());
            existingHotel.setContact(updatedHotel.getContact());
            existingHotel.setNumberOfRooms(updatedHotel.getNumberOfRooms());
            existingHotel.setRates(updatedHotel.getRates());
            return hotelrepository.save(existingHotel);
        }
        else{
            throw new NoSuchElementException("Hotel not found with the provided it"+id);
        }
    }
}
