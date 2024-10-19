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

@RestController
@RequiredArgsConstructor
@RequestMapping("/bookings")
public class BookingController {
    private final BookingService bookingService;

    @PostMapping("/create")
    @Operation(description = "create new booking")
    public void addNewBooking(@RequestBody @Validated BookingDto bookingDto) {
        bookingService.addNewBooking(bookingDto);
    }

    @PutMapping("/update")
    @Operation(description = "update booking room")
    public void updateBooking(@RequestBody @Validated BookingDto bookingDto) {
        bookingService.updateBooking(bookingDto);
    }

    @GetMapping("/all-lst-bookings")
    @Operation(description = "get list all bookings in a hotel")
    public List<BookingDto> getAllLstBooking() {
        return bookingService.getAllLstBooking();
    }


    @GetMapping("/lst-booking/{bookingId}")
    @Operation(description = "get a booking by bookingId")
    public BookingDto getBookingById(@PathVariable Long bookingId) {
        return bookingService.getBookingById(bookingId);
    }


    @DeleteMapping("/{bookingId}")
    @Operation(description = "delete a booking by bookingId")
    public void deleteBookingById(@PathVariable Long bookingId) {
        bookingService.deleteBookingById(bookingId);
    }



}
