package com.example.HotelDemo.Service;

import com.example.HotelDemo.Model.Room;
import com.example.HotelDemo.Repository.RoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
@RequiredArgsConstructor
public class RoomService implements IRoomService{
    @Autowired
    private final RoomRepository roomRepository;
    @Override
    public List<Room> getAllRooms() {
        List<Room> rooms = new ArrayList<Room>();
        roomRepository.findAllRooms().forEach(room -> rooms.add(room));
        return rooms;
    }

    @Override
    public Room getARoom(Integer idRoom) {
        Room room = new Room();
        room = roomRepository.findARoomById(idRoom);
        return room;
    }

    @Override
    public Room addRoom(Room room) {
        Room newRoom = new Room(room.getRoomId(), room.getRoomName(), room.getRoomType(),
                room.getRoomCapacity(), room.getRoomPrice(), room.getRoomDescription(), room.getRoomStatus());
        return roomRepository.save(newRoom);
    }

    @Override
    public List<Room> findRoomByStatus(String status) {
        if(status == "empty"||status == "full"){
            List<Room> rooms = roomRepository.findARoomByStatus(status);
            return rooms;
        }
        return null;
    }

    @Override
    public Room findRoomByIdRoom(Integer idRoom) {
        Room room = roomRepository.findARoomById(idRoom);
        return room;
    }

    @Override
    public void deleteRoomById(Room deleteRoom) {
        roomRepository.deleteById(deleteRoom.getRoomId());
    }
}
