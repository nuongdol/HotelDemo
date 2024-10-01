package com.example.HotelDemo.Service;

import com.example.HotelDemo.Model.Room;

import java.util.List;

public interface IRoomService {
    List<Room> getAllRooms();
    Room getARoom(Integer idRoom);
    Room addRoom(Room room);

    List<Room> findRoomByStatus(String status);

    Room findRoomByIdRoom(Integer idRoom);

    void deleteRoomById(Room deleteRoom);
}
