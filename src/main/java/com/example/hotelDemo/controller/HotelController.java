package com.example.hotelDemo.controller;


import com.example.hotelDemo.model.dto.HotelDto;
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
    @Operation(summary = "add new hotel")

    public void addNewHotel(@RequestBody @Validated HotelDto hotelDto) {
        hotelService.addNewHotelService(hotelDto);
    }

    //update a hotel
    @PutMapping("/update")
    @Operation(summary = "update hotel")

    public void updateHotel(@RequestBody @Validated HotelDto hotelDto) {
        hotelService.updateHotelService(hotelDto);
    }

    //get all hotel
    @GetMapping("/get-all")
    @Operation(summary = "get all hotels")

    public List<HotelDto> getAllHotels() {
        return hotelService.getAllHotelsService().
                stream().map(hotel -> modelMapper.map(hotel, HotelDto.class))
                .collect(Collectors.toList());
    }

    //get a hotel
    @GetMapping("/get/{id}")
    @Operation(summary = "get a hotel")

    public HotelDto getHotelById(@PathVariable(name = "id") Long hotelId) {
        return hotelService.getHotelByIdService(hotelId);
    }

    // delete a hotel
    @DeleteMapping("/delete/{id}")
    @Operation(summary = "delete room by Id")

    public void deleteHotel(@PathVariable(name = "id") Long hotelId) {
        hotelService.deleteHotelService(hotelId);

    }
}
