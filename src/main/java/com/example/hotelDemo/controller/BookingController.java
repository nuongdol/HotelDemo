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

<<<<<<< HEAD
    @PostMapping("/create")
    @Operation(description = "create new booking")
=======
    // add booking
    @PostMapping("/add")
>>>>>>> 17fb990 (eight commit)
    public void addNewBooking(@RequestBody @Validated BookingDto bookingDto) {
        bookingService.addNewBooking(bookingDto);
    }

    @PutMapping("/update")
<<<<<<< HEAD
    @Operation(description = "update booking room")
=======

>>>>>>> 17fb990 (eight commit)
    public void updateBooking(@RequestBody @Validated BookingDto bookingDto) {
        bookingService.updateBooking(bookingDto);
    }

<<<<<<< HEAD
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
=======
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
>>>>>>> 17fb990 (eight commit)
    }

}
