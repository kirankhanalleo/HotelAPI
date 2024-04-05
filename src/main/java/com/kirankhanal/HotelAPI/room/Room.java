package com.kirankhanal.HotelAPI.room;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="room")
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String roomType;
    private String roomDesc;
    private Integer capacity;
    private Integer rates;
//    @Enumerated(EnumType.STRING)
    private String roomStatus;
//    @ElementCollection
//    private List<String> availableDates;
}
