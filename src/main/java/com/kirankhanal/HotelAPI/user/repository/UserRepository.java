package com.kirankhanal.HotelAPI.user.repository;

import com.kirankhanal.HotelAPI.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {
    Optional<User> findByEmail(String email);
}
