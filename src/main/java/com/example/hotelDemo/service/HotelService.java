package com.example.hotelDemo.service;


import com.example.hotelDemo.model.dto.HotelDto;
import java.util.List;

public interface HotelService {

    void addNewHotelService(HotelDto hotelDto);

    void updateHotelService(HotelDto hotelDto);

    List<HotelDto> getAllHotelsService();

    HotelDto getHotelByIdService(Long hotelId);

    void deleteHotelService(Long hotelId);
}
