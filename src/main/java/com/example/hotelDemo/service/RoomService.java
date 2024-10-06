package com.example.HotelDemo.Service;

import com.example.HotelDemo.Model.Room;
import java.util.List;


public interface RoomService {


    List<Room> findRoomByStatus(String status);

    void addNewRoomService(Room room);

    List<Room> getAllRoomsService();

    Room getRoomByIdService(long roomId);

    Room updateRoomService(long roomId, Room room);

    void deleteRoomService(long roomId);

    List<Room> findHotelRoomService(long roomId);
}
