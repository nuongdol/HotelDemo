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
    public List<RoomDto> getAllRooms() {
        return roomRepository.findAll().stream()
                .map(room -> modelMapper.map(room, RoomDto.class)).collect(Collectors.toList());
    }

    @Override
    public RoomDto getRoomById(Long roomId) {
        Optional<Room> room = roomRepository.findById(roomId);
        RoomDto roomDto = new RoomDto();
        room.ifPresent(value -> BeanUtils.copyProperties(value, roomDto));
        return roomDto;
    }

    @Override
    public List<RoomHotelDto> getRoomByStatus(String status) {
        return roomRepository.findHotelAndRoom(status);
    }

    @Override
    public void updateRoom(RoomDto roomDto) {
        Optional<Room> room = roomRepository.findById(roomDto.getRoomId());
        Room roomUpdate = new Room();
        if(room.isPresent()){
            roomUpdate = room.get();
        }
        BeanUtils.copyProperties(roomDto, roomUpdate);
        roomRepository.save(roomUpdate);
    }

    @Override
    public void deleteRoom(Long roomId) {
        Optional<Room> room = roomRepository.findById(roomId);
        if(room.isPresent()){
            roomRepository.deleteById(roomId);
        }else{
            throw new ResourceNotFoundException("Room not found");
        }
    }

}
