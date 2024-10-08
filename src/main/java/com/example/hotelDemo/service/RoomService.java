package com.example.hotelDemo.service;


import com.example.hotelDemo.model.dto.RoomDto;
import com.example.hotelDemo.model.dto.RoomHotelDto;
import java.util.List;


public interface RoomService {

    void addNewRoom(RoomDto roomDto);

    List<RoomDto> getAllLstRoom();

    RoomDto getRoomByRoomId(Long roomId);

    List<RoomHotelDto> getLstRoomByStatus(String status, Long hotelId);

    void updateRoom(RoomDto roomDto);

    void deleteRoomByRoomId(Long roomId);

}
