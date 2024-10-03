package com.example.HotelDemo.Service.imp;

import com.example.HotelDemo.Model.Room;
import com.example.HotelDemo.Repository.RoomRepository;
import com.example.HotelDemo.Service.RoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class RoomServiceImp implements RoomService {
    @Autowired
    private final RoomRepository roomRepository;

    @Override
    public List<Room> findRoomByStatus(String status) {
        return roomRepository.findRoomByStatus(status);
    }

    @Override
    public void addNewRoomService(Room room) {
        roomRepository.save(room);
    }

    @Override
    public List<Room> getAllRoomsService() {
        return roomRepository.findAll();
    }

    @Override
    public Room getRoomByIdService(long roomId) {
        Optional<Room> room = roomRepository.findById(roomId);
        return room.orElse(null);
    }

    @Override
    public Room updateRoomService(long roomId, Room roomRequest) {
        Optional<Room> room = roomRepository.findById(roomId);
        Room room1 = new Room();

        if(room.isPresent()) {
            room1 = room.get();
        }
        BeanUtils.copyProperties(roomRequest, room1,"roomId");

        return roomRepository.save(room1);
    }

    @Override
    public void deleteRoomService(long roomId) {
        Room room = roomRepository.findById(roomId).orElse(null);
        assert room != null;
        roomRepository.delete(room);
    }

    @Override
    public List<Room> findHotelRoomService(long roomId) {
        return roomRepository.findHotelAndRoom(roomId);
    }
}
