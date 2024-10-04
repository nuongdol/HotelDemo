package com.example.hotelDemo.controller;


import com.example.hotelDemo.model.dto.*;
import com.example.hotelDemo.service.BookingService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/booking")
public class BookingController {

    @Autowired
    private final BookingService bookingService;
    @Autowired
    private final ModelMapper modelMapper;

    // add booking
    @PostMapping("/add/{id}")
    @Operation(summary = "add booking", description = "Booking must exist")

    public void addNewBooking(@PathVariable("id") Long roomId,
                              @RequestBody @Validated BookingDto bookingDto) {
        bookingService.addNewBookingService(roomId, bookingDto);
    }

    //update booking room
    @PutMapping("/update")
    @Operation(summary = "update booking", description = "Booking must exist")

    public void updateBooking(@RequestBody @Validated BookingDto bookingDto) {
        bookingService.updateBookingService(bookingDto);
    }

    //get all bookings
    @GetMapping("/get-all")
    @Operation(summary = "get all bookings")

    public List<BookingDto> getAllBooking() {
        return bookingService.getAllBookingsService().stream()
                .map(room -> modelMapper.map(room, BookingDto.class)).collect(Collectors
                        .toList());
    }

    //get a booking room
    @GetMapping("/get/{id}")
    @Operation(summary = "get booking by Id", description = "Booking exist")

    public BookingDto getBookingById(@PathVariable(name = "id") Long bookingId) {
        return bookingService.getBookingByIdService(bookingId);
    }

    //delete a booking
    @DeleteMapping("/delete/{id}")
    @Operation(summary = "delete booking by Id")

    public void deleteBooking(@PathVariable(name = "id") Long bookingId) {
        bookingService.deleteBookingService(bookingId);
    }

}
