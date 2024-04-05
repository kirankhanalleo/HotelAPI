package com.kirankhanal.HotelAPI.room.repository;

import com.kirankhanal.HotelAPI.room.Room;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomRepository extends JpaRepository<Room, Long> {
}
