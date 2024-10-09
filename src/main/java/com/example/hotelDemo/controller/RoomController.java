package com.example.hotelDemo.controller;

import com.example.hotelDemo.model.dto.RoomDto;
import com.example.hotelDemo.model.dto.RoomHotelDto;
import com.example.hotelDemo.service.RoomService;
import io.swagger.v3.oas.annotations.Operation;
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


    @GetMapping("/get-lst-all-room/{hotelId}")
    @Operation(description = "add list all room")
    public List<RoomDto> getAllLstRoom(@PathVariable Long hotelId) {
        return roomService.getAllLstRoom(hotelId).stream()
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
    public List<RoomHotelDto> getLstRoomByStatus(@RequestParam("status") String status, @RequestParam("hotelId") Long hotelId) {
//        return roomService.getLstRoomByStatusAndHotelId(status,hotelId).stream().map(
//                roomHotel -> modelMapper.map(roomHotel, RoomHotelDto.class)).collect(Collectors.toList());
        return roomService.getLstRoomByStatusAndHotelId(status,hotelId);

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
