package com.example.HotelDemo.Controller;

import com.example.HotelDemo.Exception.CheckoutRoom;
import com.example.HotelDemo.Model.Dto.RoomDto;
import com.example.HotelDemo.Model.Room;
import com.example.HotelDemo.Service.RoomService;
import jakarta.websocket.server.PathParam;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/room")
@RequiredArgsConstructor
public class RoomController {
    @Autowired
    private final RoomService roomService;
    private final ModelMapper modelMapper;

    //add a new room
    @PostMapping("/add/new-room")
    public ResponseEntity<?> addNewRoom(@RequestBody RoomDto roomDto){
            if(roomDto != null){
                //convert dto to entity
                Room room = modelMapper.map(roomDto, Room.class);

                roomService.addNewRoomService(room);

                return ResponseEntity.ok().body(room);
            }
            return ResponseEntity.badRequest().build();
    }


    //get all rooms
    @GetMapping("/get-all-rooms")
    public ResponseEntity<List<RoomDto>> getAllRooms()
            throws IOException, SQLException{
            List<RoomDto> allRoomsDto = roomService.getAllRoomsService().stream()
                    .map(room -> modelMapper.map(room, RoomDto.class)).collect(Collectors
                            .toList());
        return ResponseEntity.ok().body(allRoomsDto);
    }


    //get a room
    @GetMapping("/get-room/{id}")
    public ResponseEntity<?> getRoomById(@PathVariable(name = "id") long roomId)
            throws IOException, SQLException{
        try{
            Room room = roomService.getRoomByIdService(roomId);

            //convert entity to Dto
            RoomDto roomDto = modelMapper.map(room, RoomDto.class);

            return ResponseEntity.ok().body(roomDto);

        }catch (CheckoutRoom e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }


    //get all room by status
    @GetMapping("/get-status-rooms")
    public ResponseEntity<List<RoomDto>> getStatusRooms(@PathParam("status") String status) throws IOException, SQLException{
        List<RoomDto> roomList =  roomService.findRoomByStatus(status).stream().map(
                room -> modelMapper.map(room,RoomDto.class)).collect(Collectors.toList());
        return ResponseEntity.ok().body(roomList);
    }

    //update a room
    @PutMapping("/update-room/{id}")
    public ResponseEntity<?> updateRoom(@PathVariable(name = "id") long roomId, @RequestBody RoomDto roomDto)
            throws IOException, SQLException{
        //convert dto to entity
        Room room = modelMapper.map(roomDto, Room.class);

        Room room1 = roomService.updateRoomService(roomId, room);

        //convert entity to dto
        RoomDto roomResponse = modelMapper.map(room1, RoomDto.class);

        return ResponseEntity.ok().body(roomResponse);
    }


    //delete a room
    @DeleteMapping("/delete-room/{id}")
    public ResponseEntity<?> deleteRoom(@PathVariable(name = "id") long roomId)
            throws IOException, SQLException{
        roomService.deleteRoomService(roomId);

        return ResponseEntity.ok("Delete room.");
    }

    //get room hotel by Id
    @GetMapping("/get-room-hotel/{id}")
    public ResponseEntity<List<RoomDto>> getHotelRoomsById(@PathVariable(name = "id") long roomId)
            throws IOException, SQLException{
        List<RoomDto> roomList =  roomService.findHotelRoomService(roomId).stream().
                map(room->modelMapper.map(room, RoomDto.class)).collect(Collectors
                .toList());
        return ResponseEntity.ok().body(roomList);
    }


}
