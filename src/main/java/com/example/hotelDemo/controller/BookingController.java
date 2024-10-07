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
    @PostMapping("/add")
    public void addNewBooking(@RequestBody @Validated BookingDto bookingDto) {
        bookingService.addNewBooking(bookingDto);
    }

    //update booking room
    @PutMapping("/update")

    public void updateBooking(@RequestBody @Validated BookingDto bookingDto) {
        bookingService.updateBooking(bookingDto);
    }

    //get all bookings
    @GetMapping("/get-all")

    public List<BookingDto> getAllBooking() {
        return bookingService.getAllBookings().stream()
                .map(room -> modelMapper.map(room, BookingDto.class)).collect(Collectors
                        .toList());
    }

    //get a booking room
    @GetMapping("/get/{id}")
    @Operation(description = "get booking by bookingId")

    public BookingDto getBookingById(@PathVariable(name = "id") Long bookingId) {
        return bookingService.getBookingById(bookingId);
    }

    //delete a booking
    @DeleteMapping("/delete/{id}")
    public void deleteBooking(@PathVariable(name = "id") Long bookingId) {
        bookingService.deleteBooking(bookingId);
    }

}
