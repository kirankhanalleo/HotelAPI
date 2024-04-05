package com.kirankhanal.HotelAPI.hotel;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@Entity
@Table(name="hotel")
public class Hotel implements Serializable {
    //Basic Fields
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long hotelID;
    @Column(name="hotel_name")
    private String hotelName;
    @Column(name="location")
    private String location;
    @Column(name="contact")
    private String contact;
    @Column(name="number_of_rooms")
    private Integer numberOfRooms;
}
