package com.example.hotelDemo.controller;

import com.example.hotelDemo.model.dto.RoomDto;
import com.example.hotelDemo.model.dto.RoomHotelDto;
import com.example.hotelDemo.service.RoomService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.websocket.server.PathParam;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/room")
@RequiredArgsConstructor
public class RoomController {
    @Autowired
    private final RoomService roomService;
    @Autowired
    private final ModelMapper modelMapper;

    //add a new room
    @PostMapping("/add")

    public void addNewRoom(@RequestBody @Validated RoomDto roomDto) {
        roomService.addNewRoom(roomDto);
    }

    //get all rooms
    @GetMapping("/get-all")

    public List<RoomDto> getAllRooms() {
        return roomService.getAllRooms().stream()
                .map(room -> modelMapper.map(room, RoomDto.class)).collect(Collectors
                        .toList());

    }

    //get a room
    @GetMapping("/get/{id}")

    public RoomDto getRoomById(@PathVariable(name = "id") Long roomId) {
        return roomService.getRoomById(roomId);

    }


    //get all room by status
    @GetMapping("/get-rooms/{status}")
    @Operation(summary = "get room by status")

    public List<RoomDto> getStatusRooms(@PathVariable("status") String status) {
        return roomService.getRoomByStatus(status).stream().map(
                room -> modelMapper.map(room, RoomDto.class)).collect(Collectors.toList());

    }

    //update a room
    @PutMapping("/update")
    @Operation(summary = "update room")

    public void updateRoom(@RequestBody @Validated RoomDto roomDto) {
        roomService.updateRoom(roomDto);
    }

    //delete a room
    @DeleteMapping("/delete/{id}")
    public void deleteRoom(@PathVariable(name = "id") Long roomId){
        roomService.deleteRoom(roomId);
    }

    //get room hotel by Id
    @GetMapping("/get-room-hotel/{id}")
    @Operation(summary = "get hotel and room")

    public RoomHotelDto getHotelRoomsById(@PathVariable(name = "id") Long roomId){
        return null;
    }

}
