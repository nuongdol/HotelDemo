package com.example.hotelDemo.service;


import com.example.hotelDemo.model.dto.RoomDto;
import com.example.hotelDemo.model.dto.RoomHotelDto;
import java.util.List;


public interface RoomService {

    void addNewRoomService(RoomDto roomDto);

    List<RoomDto> getAllRoomsService();

    RoomDto getRoomByIdService(Long roomId);

    List<RoomDto> getRoomByStatusService(String status);

    void updateRoomService(RoomDto roomDto);

    void deleteRoomService(Long roomId);

    RoomHotelDto getHotelRoomService(Long roomId);
}
