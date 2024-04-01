package com.kirankhanal.HotelAPI.service;
import com.kirankhanal.HotelAPI.controller.Request.CreateHotelRequest;
import com.kirankhanal.HotelAPI.controller.Request.ViewHotelRequest;
import com.kirankhanal.HotelAPI.controller.Request.ViewOneHotelRequest;
import com.kirankhanal.HotelAPI.model.hotel;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

public interface hotelservice {

    public void createNewHotel(CreateHotelRequest createHotelRequest);
    public void createNewHotels(List<CreateHotelRequest> createHotelRequest);
    public List<ViewHotelRequest> findAllHotels();
    public Optional<ViewOneHotelRequest> findHotelById(Long id);
    public List<hotel> findHotelByLocation(String location);

    public hotel updateHotel(Long id, hotel updatedHotel);

    public void deleteHotelById(Long id);
    @Transactional
    public void deleteAllHotels();
}
