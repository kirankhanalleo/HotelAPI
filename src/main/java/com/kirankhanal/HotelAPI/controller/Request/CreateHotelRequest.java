package com.kirankhanal.HotelAPI.controller.Request;

import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateHotelRequest {
    @Valid
    @NotEmpty(message = "The hotel name field cannot be empty")
    private String hotelName;
    @NotEmpty(message = "Location field cannot be empty")
    private String location;
    @NotEmpty(message = "Contact field cannot be empty")
    private String contact;
    @NotNull(message = "Number of rooms cannot be empty")
    @Min(1)
    private Integer numberOfRooms;
    @NotNull(message = "Rates cannot be empty")
    @Positive
    private BigDecimal rates;

}
