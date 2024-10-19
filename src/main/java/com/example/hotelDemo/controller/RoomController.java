package com.example.hotelDemo.controller;

import com.example.hotelDemo.model.dto.RoomDto;
import com.example.hotelDemo.model.dto.RoomHotelDto;
import com.example.hotelDemo.service.RoomService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/rooms")
@RequiredArgsConstructor
public class RoomController {
    private final RoomService roomService;


    @PostMapping("/create")
    @Operation(description = "add a new room")
    public void addNewRoom(@RequestBody @Validated RoomDto roomDto) {
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

    @GetMapping("/lst")
    @Operation(description = "get rooms by status")
    public List<RoomHotelDto> getLstRoomByStatus(@RequestParam("status") String status, @RequestParam("hotelId") Long hotelId) {
        return roomService.getLstRoomByStatusAndHotelId(status,hotelId);

    }

    @PutMapping("/update")
    @Operation(description = "update room")
    public void updateRoom(@RequestBody @Validated RoomDto roomDto) {
        roomService.updateRoom(roomDto);
    }


    @DeleteMapping("/{roomId}")
    @Operation(description = "delete a room by roomId")
    public void deleteRoomById(@PathVariable Long roomId) {
        roomService.deleteRoomByRoomId(roomId);
    }

    /*
    tìm kiếm phòng theo từ khóa và có sẵn tên khách sạn
     */

    @GetMapping("/search")
    @Operation(description = "search rooms by keyWord")
    public List<RoomHotelDto> searchRoomByKeyWord(@RequestParam String keyWord, @RequestParam String hotelName){
        return roomService.searchRoomKeyWord(keyWord, hotelName);
    }

    /*
    Tìm kiếm phòng theo địa điểm và ngày checkin, checkout, số người lớn và trẻ em
    */
    @GetMapping("/addresses/search")
    @Operation(description = "search rooms by address and checkin and checkout and number of adults and children")
    public List<RoomHotelDto> searchRoomByAddressAndDate(@RequestParam String address, @RequestParam LocalDate checkinDate,
                                                                  @RequestParam LocalDate checkoutDate){
        return roomService.searchRoomByAddressAndDate(address, checkinDate, checkoutDate);
    }


}
