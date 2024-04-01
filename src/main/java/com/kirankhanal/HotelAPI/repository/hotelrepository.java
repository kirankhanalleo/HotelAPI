package com.kirankhanal.HotelAPI.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.kirankhanal.HotelAPI.model.hotel;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface hotelrepository extends JpaRepository<hotel,Long> {
    List<hotel> findByLocation(String location);
}
