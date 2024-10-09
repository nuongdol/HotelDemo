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
import java.util.stream.Collectors;

@RestController
@RequestMapping("/hotel")
@RequiredArgsConstructor
public class HotelController {
    @Autowired
    private final ModelMapper modelMapper;
    @Autowired
    private HotelService hotelService;


    @PostMapping("/create")
    @Operation(description = "add a new hotel")
    public void addNewHotel(@RequestBody @Validated HotelDto hotelDto) {
        hotelService.addNewHotel(hotelDto);
    }


    @PutMapping("/update")
    @Operation(description = "update a hotel")
    public void updateHotel(@RequestBody @Validated HotelDto hotelDto) {
        hotelService.updateHotel(hotelDto);
    }

    @GetMapping("/get-all-lst-hotel")
    @Operation(description = "get list all hotel")
    public List<HotelDto> getAllLstHotel() {
//        return hotelService.getAllLstHotel().
//                stream().map(hotel -> modelMapper.map(hotel, HotelDto.class))
//                .collect(Collectors.toList());
        return hotelService.getAllLstHotel();
    }

    @GetMapping("/lst-hotel/{hotelId}")
    @Operation(description = "get a hotel by hotelId")
    public HotelDto getHotelById(@PathVariable Long hotelId) {
        return hotelService.getHotelById(hotelId);
    }

    @DeleteMapping("/delete/{hotelId}")
    @Operation(description = "delete a hotel by hotelId")
    public void deleteHotelById(@PathVariable Long hotelId) {
        hotelService.deleteHotelById(hotelId);
    }

    @GetMapping("/get-lst-room/{hotelId}")
    @Operation(description = "Get room list with booking voucher by hotelId")
    public List<IRoomBookingDto> getAllLstRoomWithBookingVoucher(@PathVariable Long hotelId) {
        return hotelService.getAllLstRoomWithBookingVoucherByHotelId(hotelId);
    }
}
