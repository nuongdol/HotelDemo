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
    @Operation(summary = "add new room")
    public void addNewRoom(@RequestBody @Validated RoomDto roomDto) {
        roomService.addNewRoomService(roomDto);
    }

    //get all rooms
    @GetMapping("/get-all")
    @Operation(summary = "get all room")

    public List<RoomDto> getAllRooms() {
        return roomService.getAllRoomsService().stream()
                .map(room -> modelMapper.map(room, RoomDto.class)).collect(Collectors
                        .toList());

    }

    //get a room
    @GetMapping("/get/{id}")
    @Operation(summary = "get room by Id")

    public RoomDto getRoomById(@PathVariable(name = "id") Long roomId) {
        return roomService.getRoomByIdService(roomId);

    }


    //get all room by status
    @GetMapping("/get-status-rooms")
    @Operation(summary = "get room by status")

    public List<RoomDto> getStatusRooms(@PathParam("status") String status) {
        return roomService.getRoomByStatusService(status).stream().map(
                room -> modelMapper.map(room, RoomDto.class)).collect(Collectors.toList());

    }

    //update a room
    @PutMapping("/update")
    @Operation(summary = "update room")

    public void updateRoom(@RequestBody @Validated RoomDto roomDto) {
        roomService.updateRoomService(roomDto);
    }

    //delete a room
    @DeleteMapping("/delete/{id}")
    public void deleteRoom(@PathVariable(name = "id") Long roomId){
        roomService.deleteRoomService(roomId);
    }

    //get room hotel by Id
    @GetMapping("/get-room-hotel/{id}")
    @Operation(summary = "get hotel and room")

    public RoomHotelDto getHotelRoomsById(@PathVariable(name = "id") Long roomId){
        return null;
    }

}
