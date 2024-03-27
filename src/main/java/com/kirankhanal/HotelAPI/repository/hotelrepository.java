package com.kirankhanal.HotelAPI.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.kirankhanal.HotelAPI.model.hotel;
public interface hotelrepository extends JpaRepository<hotel,Long> {
}
