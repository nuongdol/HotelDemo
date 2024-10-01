package com.example.HotelDemo.Controller;

import com.example.HotelDemo.Exception.CheckoutBooking;
import com.example.HotelDemo.Exception.CheckoutRoom;
import com.example.HotelDemo.Model.Booking;
import com.example.HotelDemo.Model.Room;
import com.example.HotelDemo.Service.BookingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class BookingController {
    private final BookingService bookingService;
    // add booking
    @PostMapping("/add/booking")
    public ResponseEntity<?> addNewBooking(@RequestBody Booking booking){
        if(booking != null){
            Booking add = bookingService.addBooking(booking);
            return ResponseEntity.ok(add);
        }
        return ResponseEntity.badRequest().build();
    }
    //update booking room
    @PutMapping("/update-booking/{id}")
    public ResponseEntity<?> updateBooking(@PathVariable(name = "id") Integer idBooking, @RequestBody Booking booking)
            throws IOException, SQLException{
        Booking updateBooking = bookingService.findBookingByIdBooking(idBooking);
        if(updateBooking.getRoomId() != booking.getRoomId()){
            updateBooking.setRoomId(booking.getRoomId());
        }
        if(updateBooking.getBookingConfirmationCode() == null ||
                updateBooking.getBookingConfirmationCode() != booking.getBookingConfirmationCode()){
            updateBooking.setBookingConfirmationCode(booking.getBookingConfirmationCode());
        }
        if(updateBooking.getEndTime() == null || updateBooking.getEndTime() != updateBooking.getEndTime()){
            updateBooking.setEndTime(updateBooking.getEndTime());
        }
        if(updateBooking.getGuestEmail() == null || updateBooking.getGuestEmail() != booking.getGuestEmail()){
            updateBooking.setGuestEmail(booking.getGuestEmail());
        }
        if (updateBooking.getGuestFullName() == null ||
                updateBooking.getGuestFullName() != booking.getGuestFullName()){
            updateBooking.setGuestFullName(booking.getGuestFullName());
        }
        if(updateBooking.getNumOfAdults() != booking.getNumOfAdults()){
            updateBooking.setNumOfAdults(booking.getNumOfAdults());
        }
        if (updateBooking.getNumOfAdults() != booking.getNumOfAdults()){
            updateBooking.setNumOfAdults(booking.getNumOfAdults());
        }
        if(updateBooking.getNumOfChildren() != booking.getNumOfChildren()){
            updateBooking.setNumOfChildren(booking.getNumOfChildren());
        }
        if(updateBooking.getStartTime() == null || updateBooking.getStartTime() != booking.getStartTime()){
            updateBooking.setStartTime(booking.getStartTime());
        }
        if(updateBooking.getPaymentMethod() == null ||
                updateBooking.getPaymentMethod() != booking.getPaymentMethod()){
            updateBooking.setPaymentMethod(booking.getPaymentMethod());
        }
        return ResponseEntity.ok(updateBooking);
    }

    //get all bookings
    @GetMapping("/get-all-booking")
    public ResponseEntity<List<Booking>> getAllBooking() throws IOException, SQLException {
        List<Booking> getAll = bookingService.getAllBookings();
        return ResponseEntity.ok(getAll);
    }
    //get a booking room
    @GetMapping("/get-a-booking/{id}")
    public ResponseEntity<?> getABooking(@PathVariable(name = "id") Integer idBooking) throws IOException, SQLException{
        try{
            Booking booking = bookingService.getABooking(idBooking);
            return ResponseEntity.ok(booking);

        }catch (CheckoutBooking e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    //delete a booking
    @DeleteMapping("/delete/booking/{id}")
    public ResponseEntity<?> deleteBooking(@PathVariable(name = "id") Integer idBooking) throws IOException, SQLException{
        Booking deleteBooking = bookingService.findBookingByIdBooking(idBooking);
        if(deleteBooking != null){
            bookingService.deleteBookingById(deleteBooking);
        }
        return ResponseEntity.ok("Delete booking " + deleteBooking);
    }
}
