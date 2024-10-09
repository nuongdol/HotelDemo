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
@RequestMapping("/booking")
public class BookingController {

    @Autowired
    private final BookingService bookingService;
    @Autowired
    private final ModelMapper modelMapper;

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

    @GetMapping("/get-all-lst-booking")
    @Operation(description = "get list all booking in a hotel")
    public List<BookingDto> getAllLstBooking() {
<<<<<<< HEAD
=======
//        return bookingService.getAllLstBooking().stream()
//                .map(room -> modelMapper.map(room, BookingDto.class)).collect(Collectors
//                        .toList());
>>>>>>> e32e7fb (twelve)
        return bookingService.getAllLstBooking();
    }


    @GetMapping("/lst-booking/{bookingId}")
    @Operation(description = "get a booking by bookingId")
    public BookingDto getBookingById(@PathVariable Long bookingId) {
        return bookingService.getBookingById(bookingId);
    }


    @DeleteMapping("/delete/{bookingId}")
    @Operation(description = "delete a booking by bookingId")
    public void deleteBookingById(@PathVariable Long bookingId) {
        bookingService.deleteBookingById(bookingId);
    }

}
