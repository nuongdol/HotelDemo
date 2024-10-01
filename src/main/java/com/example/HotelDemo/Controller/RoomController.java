package com.example.HotelDemo.Controller;

import com.example.HotelDemo.Exception.CheckoutRoom;
import com.example.HotelDemo.Model.Room;
import com.example.HotelDemo.Service.RoomService;
import jakarta.websocket.server.PathParam;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/room")
@RequiredArgsConstructor
public class RoomController {
    private final RoomService roomService;

    //add a new room
    @PostMapping("/add/new-room")
    public ResponseEntity<?> addNewRoom(@RequestBody Room room){
            if(room != null){
                Room add = roomService.addRoom(room);
                return ResponseEntity.ok(add);
            }
            return ResponseEntity.badRequest().build();
    }
    //get all rooms
    @GetMapping("/get-all-rooms")
    public ResponseEntity<List<Room>> getAllRooms() throws IOException, SQLException{
            List<Room> getAll = roomService.getAllRooms();
        return ResponseEntity.ok(getAll);
    }
    //get a room
    @GetMapping("/get-a-room/{id}")
    public ResponseEntity<?> getARoom(@PathVariable(name = "id") Integer idRoom) throws IOException, SQLException{
        try{
            Room room = roomService.getARoom(idRoom);
            return ResponseEntity.ok(room);

        }catch (CheckoutRoom e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    //get all room with status
    @GetMapping("/get-status-rooms")
    public ResponseEntity<List<Room>> getStatusRooms(@PathParam("status") String status) throws IOException, SQLException{
        List<Room> roomList =  roomService.findRoomByStatus(status);
        return ResponseEntity.ok(roomList);
    }

    //update a room
    @PutMapping("/update-room/{id}")
    public ResponseEntity<?> updateRoom(@PathVariable(name = "id") Integer idRoom, @RequestBody Room room)
            throws IOException, SQLException{
        Room updateRoom = roomService.findRoomByIdRoom(idRoom);
        if(updateRoom.getRoomCapacity() != room.getRoomCapacity() || updateRoom.getRoomStatus() == null){
            updateRoom.setRoomCapacity(room.getRoomCapacity());
        }
        if(updateRoom.getRoomStatus() == null || updateRoom.getRoomStatus() != room.getRoomStatus()){
            updateRoom.setRoomStatus(room.getRoomStatus());
        }
        if(updateRoom.getRoomName() == null || updateRoom.getRoomName() != room.getRoomName()){
            updateRoom.setRoomName(room.getRoomName());
        }
        if(updateRoom.getRoomType() == null || updateRoom.getRoomType() != room.getRoomType()){
            updateRoom.setRoomType(room.getRoomType());
        }
        if (updateRoom.getRoomPrice() == null || updateRoom.getRoomPrice() != room.getRoomPrice()){
            updateRoom.setRoomPrice(room.getRoomPrice());
        }
        if(updateRoom.getRoomDescription() == null || updateRoom.getRoomDescription() != room.getRoomDescription()){
            updateRoom.setRoomDescription(room.getRoomDescription());
        }
        if (updateRoom.getRoomCapacity() == null || updateRoom.getRoomCapacity() != room.getRoomCapacity()){
            updateRoom.setRoomCapacity(room.getRoomCapacity());
        }
        return ResponseEntity.ok(updateRoom);
    }
    //delete a room
    @DeleteMapping("/delete/room/{id}")
    public ResponseEntity<?> deleteRoom(@PathVariable(name = "id") Integer idRoom) throws IOException, SQLException{
        Room deleteRoom = roomService.findRoomByIdRoom(idRoom);
        if(deleteRoom != null){
            roomService.deleteRoomById(deleteRoom);
        }
        return ResponseEntity.ok("Delete room " + deleteRoom);
    }
}
