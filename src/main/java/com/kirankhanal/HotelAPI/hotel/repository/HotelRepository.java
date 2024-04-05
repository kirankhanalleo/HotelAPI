package com.kirankhanal.HotelAPI.hotel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.kirankhanal.HotelAPI.hotel.Hotel;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HotelRepository extends JpaRepository<Hotel,Long> {
    List<Hotel> findByLocation(String location);
}
