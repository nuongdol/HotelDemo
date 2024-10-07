package com.example.hotelDemo.service;


import com.example.hotelDemo.model.dto.HotelDto;
import com.example.hotelDemo.model.dto.IRoomBookingDto;
import com.example.hotelDemo.model.dto.RoomBookingDto;

import java.util.List;

public interface HotelService {

    void addNewHotel(HotelDto hotelDto);

    void updateHotel(HotelDto hotelDto);

    List<HotelDto> getAllHotels();

    HotelDto getHotelById(Long hotelId);

    void deleteHotel(Long hotelId);

    List<IRoomBookingDto> getDetailByHotelId(Long hotelId);
}
