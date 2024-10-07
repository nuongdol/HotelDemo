package com.example.HotelDemo.Controller;

import com.example.HotelDemo.Exception.CheckoutBooking;
import com.example.HotelDemo.Model.Booking;
import com.example.HotelDemo.Model.Dto.*;
import com.example.HotelDemo.Service.BookingService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.sql.SQLException;
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
    @PostMapping("/add-booking")
    public ResponseEntity<?> addNewBooking(@RequestBody BookingDto bookingDto) {
        if(bookingDto != null) {

            Booking booking = new Booking();
            BeanUtils.copyProperties(bookingDto,booking);
            bookingService.addNewBookingService(booking);
            return ResponseEntity.ok().body(booking);
        }
        return ResponseEntity.badRequest().build();
    }

    //update booking room
    @PutMapping("/update-booking/{id}")
    public ResponseEntity<?> updateBooking(@PathVariable(name = "id") long bookingId,
                                           @RequestBody BookingDto bookingDto) throws IOException, SQLException{
        Booking booking = new Booking();
        BeanUtils.copyProperties(bookingDto,booking,"bookingId");

        bookingService.updateBookingService(bookingId, booking);

        BookingDto bookingDto1 = new BookingDto();
        BeanUtils.copyProperties(bookingDto,bookingDto1);

        return ResponseEntity.ok().body(bookingDto1);
    }


    //get all bookings
    @GetMapping("/get-all-bookings")
    public ResponseEntity<List<BookingDto>> getAllBooking() throws IOException, SQLException {
        List<BookingDto> allBookingsDto = bookingService.getAllBookingsService().stream()
                .map(room -> modelMapper.map(room, BookingDto.class)).collect(Collectors
                        .toList());

        return ResponseEntity.ok().body(allBookingsDto);
    }

    //get a booking room
    @GetMapping("/get-booking/{id}")
    public ResponseEntity<?> getBookingById(@PathVariable(name = "id") long bookingId)
            throws IOException, SQLException{
        try{

            Booking booking = bookingService.getBookingByIdService(bookingId);

            BookingDto bookingDto = new BookingDto();
            BeanUtils.copyProperties(booking,bookingDto);

            return ResponseEntity.ok().body(bookingDto);

        }catch (CheckoutBooking e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    //delete a booking
    @DeleteMapping("/delete-booking/{id}")
    public ResponseEntity<?> deleteBooking(@PathVariable(name = "id") long bookingId)
            throws IOException, SQLException{
        bookingService.deleteBookingService(bookingId);

        return ResponseEntity.ok("Deleted booking.");
    }

    //get room and booking by bookingId
    @GetMapping("/get-room-booking/{id}")
    public ResponseEntity<?> getRoomAndBookingById(@PathVariable(name = "id") long bookingId) throws
            IOException, SQLException{

        RoomBookingDto roomBookingDto = bookingService.getRoomAndBookingByIdService(bookingId);

        return ResponseEntity.ok().body(roomBookingDto);
    }

    //get user and booking by bookingId
    @GetMapping("/get-user-booking/{id}")
    public ResponseEntity<?> getUserAndBookingById(@PathVariable(name = "id") long bookingId) throws
            IOException, SQLException{

        UserBookingDto userBookingDto = bookingService.getUserAndBookingService(bookingId);

        return ResponseEntity.ok().body(userBookingDto);
    }

    //get all detailed booking by bookingId
    @GetMapping("/get-all-detailed-bookings")
    public ResponseEntity<?> getAllDetailedBookingsById() throws
            IOException, SQLException{

        DetailedBookingDto detailedBookingDto = bookingService.getAllDetailedBookingService();

        return ResponseEntity.ok().body(detailedBookingDto);
    }

    //get detailed booking by bookingId
    @GetMapping("/get-detailed-bookings/{id}")
    public ResponseEntity<?> getDetailedBookingsById(@PathVariable(name = "id") long bookingId) throws
            IOException, SQLException{

        DetailedBookingDto detailedBookingDto = bookingService.getDetailedBookingService(bookingId);

        return ResponseEntity.ok().body(detailedBookingDto);
    }

    //get room, user and booking by bookingId
    @GetMapping("/get-room-user-bookings/{id}")
    public ResponseEntity<?> getRoomUserBookingsById(@PathVariable(name = "id") long bookingId) throws
            IOException, SQLException{

        RoomUserBookingDto roomUserBookingDto = bookingService.getRoomUserBookingService(bookingId);

        return ResponseEntity.ok().body(roomUserBookingDto);
    }
}
