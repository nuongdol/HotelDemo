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
    public List<RoomDto> getAllLstRoom(Long hotelId) {
        return roomRepository.findByHotelId(hotelId).stream()
                .map(room -> modelMapper.map(room, RoomDto.class)).collect(Collectors.toList());
    }

    @Override
    public RoomDto getRoomByRoomId(Long roomId) {
        Optional<Room> room = Optional.of(roomRepository.findById(roomId)
                .orElseThrow(() -> new IllegalStateException("Room not found")));
        RoomDto roomDto = new RoomDto();
        room.ifPresent(value -> BeanUtils.copyProperties(value, roomDto));
        return roomDto;
    }

    @Override
    public List<RoomHotelDto> getLstRoomByStatusAndHotelId(String status, Long hotelId) {
        return roomRepository.findLstRoomByStatusAndHotelId(status, hotelId);
    }

    @Override
    public void updateRoom(RoomDto roomDto) {
        Optional<Room> room = Optional.of(roomRepository.findById(roomDto.getRoomId())
                .orElseThrow(() -> new IllegalStateException("Room not found")));
        Room roomUpdate = new Room();
        roomUpdate = room.get();
        BeanUtils.copyProperties(roomDto, roomUpdate);
        roomRepository.save(roomUpdate);
    }

    @Override
    public void deleteRoomByRoomId(Long roomId) {
        Optional<Room> room = roomRepository.findById(roomId);
        if (room.isPresent()) {
            roomRepository.deleteById(roomId);
        } else {
            throw new ResourceNotFoundException("Room not found");
        }
    }
}
