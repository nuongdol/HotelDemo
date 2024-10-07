package com.example.hotelDemo.service.imp;


import com.example.hotelDemo.exception.ResourceNotFoundException;
import com.example.hotelDemo.model.Room;
import com.example.hotelDemo.model.dto.RoomDto;
import com.example.hotelDemo.model.dto.RoomHotelDto;
import com.example.hotelDemo.repository.RoomRepository;
import com.example.hotelDemo.service.RoomService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class RoomServiceImp implements RoomService {

    private final RoomRepository roomRepository;
    private final ModelMapper modelMapper;

    @Override
    public void addNewRoom(RoomDto roomDto) {
        Room room = new Room();
        BeanUtils.copyProperties(roomDto, room);
        roomRepository.save(room);
    }

    @Override
<<<<<<< HEAD
    public List<RoomDto> getAllLstRoom(Long hotelId) {
        return roomRepository.findByHotelId(hotelId).stream()
=======
    public List<RoomDto> getAllRooms() {
        return roomRepository.findAll().stream()
>>>>>>> 17fb990 (eight commit)
                .map(room -> modelMapper.map(room, RoomDto.class)).collect(Collectors.toList());
    }

    @Override
<<<<<<< HEAD
    public RoomDto getRoomByRoomId(Long roomId) {
        Optional<Room> room = Optional.of(roomRepository.findById(roomId)
                .orElseThrow(() -> new IllegalStateException("Room not found")));
=======
    public RoomDto getRoomById(Long roomId) {
        Optional<Room> room = roomRepository.findById(roomId);
>>>>>>> 17fb990 (eight commit)
        RoomDto roomDto = new RoomDto();
        room.ifPresent(value -> BeanUtils.copyProperties(value, roomDto));
        return roomDto;
    }

    @Override
<<<<<<< HEAD
    public List<RoomHotelDto> getLstRoomByStatusAndHotelId(String status, Long hotelId) {
        return roomRepository.findLstRoomByStatusAndHotelId(status, hotelId);
=======
    public List<RoomHotelDto> getRoomByStatus(String status) {
        return roomRepository.findHotelAndRoom(status);
>>>>>>> 17fb990 (eight commit)
    }

    @Override
    public void updateRoom(RoomDto roomDto) {
<<<<<<< HEAD
        Optional<Room> room = Optional.of(roomRepository.findById(roomDto.getRoomId())
                .orElseThrow(() -> new IllegalStateException("Room not found")));
=======
        Optional<Room> room = roomRepository.findById(roomDto.getRoomId());
>>>>>>> 17fb990 (eight commit)
        Room roomUpdate = new Room();
        roomUpdate = room.get();
        BeanUtils.copyProperties(roomDto, roomUpdate);
        roomRepository.save(roomUpdate);
    }

    @Override
<<<<<<< HEAD
    public void deleteRoomByRoomId(Long roomId) {
=======
    public void deleteRoom(Long roomId) {
>>>>>>> 17fb990 (eight commit)
        Optional<Room> room = roomRepository.findById(roomId);
        if (room.isPresent()) {
            roomRepository.deleteById(roomId);
        } else {
            throw new ResourceNotFoundException("Room not found");
        }
    }
<<<<<<< HEAD
=======

>>>>>>> 17fb990 (eight commit)
}
