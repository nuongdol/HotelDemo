package com.example.hotelDemo.service;


import com.example.hotelDemo.model.dto.RoomDto;
import com.example.hotelDemo.model.dto.RoomHotelDto;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface RoomService {

    void addNewRoom(RoomDto roomDto);

    List<RoomDto> getAllLstRoom(Long hotelId);

    RoomDto getRoomByRoomId(Long roomId);

    List<RoomHotelDto> getLstRoomByStatusAndHotelId(String status, Long hotelId);

    void updateRoom(RoomDto roomDto);

    void deleteRoomByRoomId(Long roomId);

    List<RoomHotelDto> searchRoomKeyWord( String keyWord, String hotelName);
}
