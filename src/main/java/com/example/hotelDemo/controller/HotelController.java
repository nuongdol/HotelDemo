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

    //add a hotel
    @PostMapping("/add")

    public void addNewHotel(@RequestBody @Validated HotelDto hotelDto) {
        hotelService.addNewHotel(hotelDto);
    }

    //update a hotel
    @PutMapping("/update")

    public void updateHotel(@RequestBody @Validated HotelDto hotelDto) {
        hotelService.updateHotel(hotelDto);
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

    }

    //get room and booking by hotelId
    @GetMapping("/get-detail/{id}")
    @Operation(description = "get alls room and booking by using hotelId")

    public List<IRoomBookingDto> getDetail(@PathVariable("id") Long hotelId){
        return hotelService.getDetailByHotelId(hotelId);
    }
}
