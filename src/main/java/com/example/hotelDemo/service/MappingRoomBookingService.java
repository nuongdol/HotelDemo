package com.example.hotelDemo.service;

import com.example.hotelDemo.model.dto.BookingDto;
import com.example.hotelDemo.model.dto.RoomBookingDto;

import java.util.List;

public interface MappingRoomBookingService {

    List<RoomBookingDto> getRoomAndBooking(Long roomId);
}
