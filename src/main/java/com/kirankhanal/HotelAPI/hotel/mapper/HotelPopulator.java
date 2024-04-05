package com.kirankhanal.HotelAPI.hotel.mapper;

import com.kirankhanal.HotelAPI.hotel.Hotel;
import com.kirankhanal.HotelAPI.hotel.dto.HotelDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface HotelPopulator {
    HotelPopulator hotelPopulatorInstance = Mappers.getMapper(HotelPopulator.class);
    Hotel populateHotel(HotelDto hotelDto);
}
