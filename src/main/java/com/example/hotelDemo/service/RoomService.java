package com.example.hotelDemo.service;


import com.example.hotelDemo.model.dto.RoomDto;
import com.example.hotelDemo.model.dto.RoomHotelDto;
import java.util.List;


public interface RoomService {

    void addNewRoom(RoomDto roomDto);

    List<RoomDto> getAllRooms();

    RoomDto getRoomById(Long roomId);

    List<RoomHotelDto> getRoomByStatus(String status);

    void updateRoom(RoomDto roomDto);

    void deleteRoom(Long roomId);


}
