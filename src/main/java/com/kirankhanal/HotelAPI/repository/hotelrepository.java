package com.kirankhanal.HotelAPI.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.kirankhanal.HotelAPI.model.hotel;
import org.springframework.stereotype.Repository;

@Repository
public interface hotelrepository extends JpaRepository<hotel,Long> {
}
