package com.example.hotelDemo.service;


import com.example.hotelDemo.model.dto.HotelDto;
import com.example.hotelDemo.model.dto.IRoomBookingDto;
import com.example.hotelDemo.model.dto.RoomBookingDto;

import java.util.List;

public interface HotelService {

    void addNewHotel(HotelDto hotelDto);

    void updateHotel(HotelDto hotelDto);

    List<HotelDto> getAllLstHotel();

    HotelDto getHotelById(Long hotelId);

    void deleteHotelById(Long hotelId);

    List<IRoomBookingDto> getAllLstRoomWithBookingVoucherByHotelId(Long hotelId);

    void changeStatusHotelById(Long hotelId, String status);
}
