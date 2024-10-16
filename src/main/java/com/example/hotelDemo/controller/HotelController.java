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
@RequestMapping("/hotel")
@RequiredArgsConstructor
public class HotelController {
    @Autowired
    private final ModelMapper modelMapper;
    @Autowired
    private HotelService hotelService;

    //add a hotel
    @PostMapping("/add")


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

    //get all hotel
    @GetMapping("/get-all")

    public List<HotelDto> getAllHotels() {
        return hotelService.getAllHotels().
                stream().map(hotel -> modelMapper.map(hotel, HotelDto.class))
                .collect(Collectors.toList());
    }

    //get a hotel
    @GetMapping("/get/{id}")

    public HotelDto getHotelById(@PathVariable(name = "id") Long hotelId) {
        return hotelService.getHotelById(hotelId);
    }

    // delete a hotel
    @DeleteMapping("/delete/{id}")

    public void deleteHotel(@PathVariable(name = "id") Long hotelId) {
        hotelService.deleteHotel(hotelId);


    @PutMapping("/{hotelId}")
    @Operation(description = "Change status of hotel by hotelId")
    public void changeStatusHotel(@PathVariable Long hotelId, @RequestBody String status) {
        hotelService.changeStatusHotelById(hotelId, status);
    }

    //get room and booking by hotelId
    @GetMapping("/get-detail/{id}")
    @Operation(description = "get alls room and booking by using hotelId")

    public List<IRoomBookingDto> getDetail(@PathVariable("id") Long hotelId){
        return hotelService.getDetailByHotelId(hotelId);
    }
}
