package com.example.hotelDemo.controller;

import com.example.hotelDemo.model.dto.RoomDto;
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


    @PostMapping("/create")
    @Operation(description = "add a new room")
    public void addNewRoom(@RequestBody @Validated RoomDto roomDto) {
        roomService.addNewRoom(roomDto);
    }


    @GetMapping("/get-lst-all-room")
    @Operation(description = "add list all room")
    public List<RoomDto> getAllLstRoom() {
        return roomService.getAllLstRoom().stream()
                .map(room -> modelMapper.map(room, RoomDto.class)).collect(Collectors
                        .toList());
    }


    @GetMapping("/lst-room/{roomId}")
    @Operation(description = "get a room by roomId")
    public RoomDto getRoomById(@PathVariable Long roomId) {
        return roomService.getRoomByRoomId(roomId);

    }

    @GetMapping("/get-lst-room")
    @Operation(description = "get room by status")
    public List<RoomDto> getLstRoomByStatus(@PathParam("status") String status, @PathParam("hotelId") Long hotelId) {
        return roomService.getLstRoomByStatus(status,hotelId).stream().map(
                room -> modelMapper.map(room, RoomDto.class)).collect(Collectors.toList());

    }

    @PutMapping("/update")
    @Operation(description = "update room")
    public void updateRoom(@RequestBody @Validated RoomDto roomDto) {
        roomService.updateRoom(roomDto);
    }


    @DeleteMapping("/delete/{roomId}")
    @Operation(description = "delete a room by roomId")
    public void deleteRoomById(@PathVariable Long roomId) {
        roomService.deleteRoomByRoomId(roomId);
    }

}
