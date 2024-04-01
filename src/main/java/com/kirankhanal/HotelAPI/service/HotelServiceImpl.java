package com.kirankhanal.HotelAPI.service;

import com.kirankhanal.HotelAPI.controller.Request.CreateHotelRequest;
import com.kirankhanal.HotelAPI.controller.Request.ViewHotelRequest;
import com.kirankhanal.HotelAPI.controller.Request.ViewOneHotelRequest;
import com.kirankhanal.HotelAPI.model.hotel;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import com.kirankhanal.HotelAPI.repository.hotelrepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
@Service
public class HotelServiceImpl implements hotelservice {
    @Autowired
    private hotelrepository hotelrepository;

    @Override
    public void createNewHotel(CreateHotelRequest createHotelRequest) {
        hotel hotel = new hotel();
        hotel.setHotelName(createHotelRequest.getHotelName());
        hotel.setContact(createHotelRequest.getContact());
        hotel.setLocation(createHotelRequest.getLocation());
        hotel.setNumberOfRooms(createHotelRequest.getNumberOfRooms());
        hotel.setRates(createHotelRequest.getRates());
        hotelrepository.save(hotel);
    }

    @Override
    public void createNewHotels(List<CreateHotelRequest> createHotelRequest) {
        for (CreateHotelRequest createHotelRequests : createHotelRequest) {
            hotel hotel = new hotel();
            hotel.setHotelName(createHotelRequests.getHotelName());
            hotel.setContact(createHotelRequests.getContact());
            hotel.setLocation(createHotelRequests.getLocation());
            hotel.setNumberOfRooms(createHotelRequests.getNumberOfRooms());
            hotel.setRates(createHotelRequests.getRates());
            hotelrepository.save(hotel);
        }
    }
    public List<ViewHotelRequest> findAllHotels(){
        List<ViewHotelRequest> viewHotelRequests = new ArrayList<>();
        for(hotel hotel : hotelrepository.findAll()){
            ViewHotelRequest viewHotelRequest = new ViewHotelRequest();
            viewHotelRequest.setHotelName(hotel.getHotelName());
            viewHotelRequest.setLocation(hotel.getLocation());
            viewHotelRequest.setContact(hotel.getContact());
            viewHotelRequest.setNumberOfRooms(hotel.getNumberOfRooms());
            viewHotelRequest.setRates(hotel.getRates());
            viewHotelRequests.add(viewHotelRequest);
        }
        return viewHotelRequests;
    }
    @Override
    public Optional<ViewOneHotelRequest> findHotelById(Long id){
        Optional<hotel>  optionalHotel=hotelrepository.findById(id);
        if(optionalHotel.isPresent()){
            hotel Hotel = optionalHotel.get();
            ViewOneHotelRequest viewOneHotelRequest = new ViewOneHotelRequest();
            viewOneHotelRequest.setHotelName(Hotel.getHotelName());
            viewOneHotelRequest.setContact(Hotel.getContact());
            viewOneHotelRequest.setLocation((Hotel.getLocation()));
            viewOneHotelRequest.setNumberOfRooms(Hotel.getNumberOfRooms());
            viewOneHotelRequest.setRates(Hotel.getRates());
            return Optional.of(viewOneHotelRequest);
        }
        return Optional.empty();
    }
    @Override
    public List<hotel> findHotelByLocation(String location){
        return hotelrepository.findByLocation(location);
    }
    @Override
    @Transactional
    public hotel updateHotel(Long id, hotel updatedHotel) {
        Optional<hotel> hotelInstance = hotelrepository.findById(id);
        if (hotelInstance.isPresent()) {
            hotel existingHotel = hotelInstance.get();
            if (updatedHotel.getHotelName() != null) {
                existingHotel.setHotelName(updatedHotel.getHotelName());
            }
            if (updatedHotel.getLocation() != null) {
                existingHotel.setLocation(updatedHotel.getLocation());
            }
            if (updatedHotel.getContact() != null) {
                existingHotel.setContact(updatedHotel.getContact());
            }
            if (updatedHotel.getNumberOfRooms() != null) {
                existingHotel.setNumberOfRooms(updatedHotel.getNumberOfRooms());
            }
            if (updatedHotel.getRates() != null) {
                existingHotel.setRates(updatedHotel.getRates());
            }
            return hotelrepository.save(existingHotel);
        } else {
            throw new NoSuchElementException("Hotel not found with the provided id: " + id);
        }
    }
    @Override
    @Transactional
    public void deleteHotelById(Long id){
        hotelrepository.deleteById(id);
    }
    @Override
    @Transactional
    public void deleteAllHotels(){
        hotelrepository.deleteAll();
    }
}
