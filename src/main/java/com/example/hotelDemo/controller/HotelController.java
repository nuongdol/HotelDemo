package com.example.hotelDemo.controller;


import com.example.hotelDemo.model.dto.HotelDto;
import com.example.hotelDemo.model.dto.IRoomBookingDto;
import com.example.hotelDemo.service.HotelService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/hotels")
@RequiredArgsConstructor
public class HotelController {
    private final HotelService hotelService;

    @PostMapping("/create")
    @Operation(description = "add a new hotel")
    public void addNewHotel(@RequestBody HotelDto hotelDto) {
        hotelService.addNewHotel(hotelDto);
    }


    @PutMapping("/update")
    @Operation(description = "update a hotel")
    public void updateHotel(@RequestBody HotelDto hotelDto) {
        hotelService.updateHotel(hotelDto);
    }

    @GetMapping("/all-lst")
    @Operation(description = "get list all hotels")
    public List<HotelDto> getAllLstHotel() {
        return hotelService.getAllLstHotel();
    }

    @GetMapping("/lst/{hotelId}")
    @Operation(description = "get a hotel by hotelId")
    public HotelDto getHotelById(@PathVariable Long hotelId) {
        return hotelService.getHotelById(hotelId);
    }

    @DeleteMapping("/{hotelId}")
    @Operation(description = "delete a hotel by hotelId")
    public void deleteHotelById(@PathVariable Long hotelId) {
        hotelService.deleteHotelById(hotelId);
    }

    @GetMapping("/lst-room/{hotelId}")
    @Operation(description = "Get room list with booking voucher by hotelId")
    public List<IRoomBookingDto> getAllLstRoomWithBookingVoucher(@PathVariable Long hotelId) {
        return hotelService.getAllLstRoomWithBookingVoucherByHotelId(hotelId);
    }

    @PutMapping("/{hotelId}")
    @Operation(description = "Change status of hotel by hotelId")
    public void changeStatusHotel(@PathVariable Long hotelId, @RequestBody String status) {
        hotelService.changeStatusHotelById(hotelId, status);
    }
}
