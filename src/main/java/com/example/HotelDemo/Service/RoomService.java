package com.example.HotelDemo.Service;

import com.example.HotelDemo.Model.Room;
import com.example.HotelDemo.Repository.RoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.sql.rowset.serial.SerialBlob;
import java.io.IOException;
import java.lang.management.MemoryUsage;
import java.sql.Blob;
import java.sql.SQLException;
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
                room.getRoomCapacity(), room.getRoomPrice(), room.getRoomDescription(), room.getRoomStatus(), room.getRoomImage());
        return roomRepository.save(newRoom);
    }
    public Room addRoomWithImage(MultipartFile file) throws IOException, SQLException {
        Room newRoom = new Room();
        if(!file.isEmpty()) {
            byte[] photoBytes = file.getBytes();
            Blob photoBlob = new SerialBlob(photoBytes);
            newRoom.setRoomImage(photoBlob);

        }
        return roomRepository.save(newRoom);
    }

    @Override
    public List<Room> findRoomByStatus(String status) {
        if(status.equals("empty") ||status.equals("full")){
            return roomRepository.findARoomByStatus(status);
        }
        return null;
    }

    @Override
    public Room findRoomByIdRoom(Integer idRoom) {
        return roomRepository.findARoomById(idRoom);
    }

    @Override
    public void deleteRoomById(Room deleteRoom) {
        roomRepository.deleteById(deleteRoom.getRoomId());
    }
}
