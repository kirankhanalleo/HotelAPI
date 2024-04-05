package com.kirankhanal.HotelAPI.hotel.service;

import com.kirankhanal.HotelAPI.hotel.controller.Request.CreateHotelRequest;
import com.kirankhanal.HotelAPI.hotel.controller.Request.ViewHotelRequest;
import com.kirankhanal.HotelAPI.hotel.controller.Request.ViewOneHotelRequest;
import com.kirankhanal.HotelAPI.hotel.Hotel;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import com.kirankhanal.HotelAPI.hotel.repository.HotelRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
@Service
public class HotelServiceImpl implements HotelService {
    @Autowired
    private HotelRepository hotelRepository;
    @Override
    public void createNewHotel(CreateHotelRequest createHotelRequest) {
        Hotel hotel = new Hotel();
        hotel.setHotelName(createHotelRequest.getHotelName());
        hotel.setContact(createHotelRequest.getContact());
        hotel.setLocation(createHotelRequest.getLocation());
        hotel.setNumberOfRooms(createHotelRequest.getNumberOfRooms());
        hotelRepository.save(hotel);
    }

    @Override
    public void createNewHotels(List<CreateHotelRequest> createHotelRequest) {
        for (CreateHotelRequest createHotelRequests : createHotelRequest) {
            Hotel hotel = new Hotel();
            hotel.setHotelName(createHotelRequests.getHotelName());
            hotel.setContact(createHotelRequests.getContact());
            hotel.setLocation(createHotelRequests.getLocation());
            hotel.setNumberOfRooms(createHotelRequests.getNumberOfRooms());
            hotelRepository.save(hotel);
        }
    }
    public List<ViewHotelRequest> findAllHotels(){
        List<ViewHotelRequest> viewHotelRequests = new ArrayList<>();
        for(Hotel hotel : hotelRepository.findAll()){
            ViewHotelRequest viewHotelRequest = new ViewHotelRequest();
            viewHotelRequest.setHotelName(hotel.getHotelName());
            viewHotelRequest.setLocation(hotel.getLocation());
            viewHotelRequest.setContact(hotel.getContact());
            viewHotelRequest.setNumberOfRooms(hotel.getNumberOfRooms());
            viewHotelRequests.add(viewHotelRequest);
        }
        return viewHotelRequests;
    }
    @Override
    public Optional<ViewOneHotelRequest> findHotelById(Long id){
        Optional<Hotel>  optionalHotel= hotelRepository.findById(id);
        if(optionalHotel.isPresent()){
            Hotel Hotel = optionalHotel.get();
            ViewOneHotelRequest viewOneHotelRequest = new ViewOneHotelRequest();
            viewOneHotelRequest.setHotelName(Hotel.getHotelName());
            viewOneHotelRequest.setContact(Hotel.getContact());
            viewOneHotelRequest.setLocation((Hotel.getLocation()));
            viewOneHotelRequest.setNumberOfRooms(Hotel.getNumberOfRooms());
            return Optional.of(viewOneHotelRequest);
        }
        return Optional.empty();
    }
    @Override
    public List<Hotel> findHotelByLocation(String location){
        return hotelRepository.findByLocation(location);
    }
    @Override
    @Transactional
    public Hotel updateHotel(Long id, Hotel updatedHotel) {
        Optional<Hotel> hotelInstance = hotelRepository.findById(id);
        if (hotelInstance.isPresent()) {
            Hotel existingHotel = hotelInstance.get();
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
            return hotelRepository.save(existingHotel);
        } else {
            throw new NoSuchElementException("Hotel not found with the provided id: " + id);
        }
    }
    @Override
    @Transactional
    public void deleteHotelById(Long id){
        hotelRepository.deleteById(id);
    }
    @Override
    @Transactional
    public void deleteAllHotels(){
        hotelRepository.deleteAll();
    }
}
