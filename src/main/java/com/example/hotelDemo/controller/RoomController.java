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

<<<<<<< HEAD

    @PostMapping("/create")
    @Operation(description = "add a new room")
=======
    //add a new room
    @PostMapping("/add")

>>>>>>> 17fb990 (eight commit)
    public void addNewRoom(@RequestBody @Validated RoomDto roomDto) {
        roomService.addNewRoom(roomDto);
    }

<<<<<<< HEAD

    @GetMapping("/get-lst-all-room/{hotelId}")
    @Operation(description = "add list all room")
    public List<RoomDto> getAllLstRoom(@PathVariable Long hotelId) {
<<<<<<< HEAD
        return roomService.getAllLstRoom(hotelId);
=======
        return roomService.getAllLstRoom(hotelId).stream()
=======
    //get all rooms
    @GetMapping("/get-all")

    public List<RoomDto> getAllRooms() {
        return roomService.getAllRooms().stream()
>>>>>>> 17fb990 (eight commit)
                .map(room -> modelMapper.map(room, RoomDto.class)).collect(Collectors
                        .toList());
>>>>>>> e32e7fb (twelve)
    }

    @GetMapping("/lst-room/{roomId}")
    @Operation(description = "get a room by roomId")
    public RoomDto getRoomById(@PathVariable Long roomId) {
        return roomService.getRoomByRoomId(roomId);

    }

<<<<<<< HEAD
    @GetMapping("/get-lst-room")
    @Operation(description = "get room by status")
    public List<RoomHotelDto> getLstRoomByStatus(@RequestParam("status") String status, @RequestParam("hotelId") Long hotelId) {
<<<<<<< HEAD
=======
//        return roomService.getLstRoomByStatusAndHotelId(status,hotelId).stream().map(
//                roomHotel -> modelMapper.map(roomHotel, RoomHotelDto.class)).collect(Collectors.toList());
>>>>>>> e32e7fb (twelve)
        return roomService.getLstRoomByStatusAndHotelId(status,hotelId);

    }

=======
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
>>>>>>> 17fb990 (eight commit)
    @PutMapping("/update")
    @Operation(description = "update room")
    public void updateRoom(@RequestBody @Validated RoomDto roomDto) {
        roomService.updateRoom(roomDto);
    }

<<<<<<< HEAD
=======
    //delete a room
    @DeleteMapping("/delete/{id}")
    public void deleteRoom(@PathVariable(name = "id") Long roomId){
        roomService.deleteRoom(roomId);
    }
>>>>>>> 17fb990 (eight commit)

    @DeleteMapping("/delete/{roomId}")
    @Operation(description = "delete a room by roomId")
    public void deleteRoomById(@PathVariable Long roomId) {
        roomService.deleteRoomByRoomId(roomId);
    }

}
