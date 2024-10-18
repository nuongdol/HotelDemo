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
@RequestMapping("/rooms")
@RequiredArgsConstructor
public class RoomController {
    private final RoomService roomService;


    @PostMapping("/create")
    @Operation(description = "add a new room")
    public void addNewRoom(@RequestBody RoomDto roomDto) {
        roomService.addNewRoom(roomDto);
    }


    @GetMapping("/lst-all/{hotelId}")
    @Operation(description = "add list all room")
    public List<RoomDto> getAllLstRoom(@PathVariable Long hotelId) {
        return roomService.getAllLstRoom(hotelId);
    }

    @GetMapping("/lst/{roomId}")
    @Operation(description = "get a room by roomId")
    public RoomDto getRoomById(@PathVariable Long roomId) {
        return roomService.getRoomByRoomId(roomId);

    }

    @GetMapping("/lst-rooms")
    @Operation(description = "get rooms by status")
    public List<RoomHotelDto> getLstRoomByStatus(@RequestParam(value = "status") String status, @RequestParam(defaultValue = "hotelId") Long hotelId) {
        return roomService.getLstRoomByStatusAndHotelId(status,hotelId);

    }

    @PutMapping("/update")
    @Operation(description = "update room")
    public void updateRoom(@RequestBody RoomDto roomDto) {
        roomService.updateRoom(roomDto);
    }


    @DeleteMapping("/{roomId}")
    @Operation(description = "delete a room by roomId")
    public void deleteRoomById(@PathVariable Long roomId) {
        roomService.deleteRoomByRoomId(roomId);
    }

}
