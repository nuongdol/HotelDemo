package com.example.HotelDemo.Controller;

import com.example.HotelDemo.Model.Booking;
import com.example.HotelDemo.Model.DetailedBooking;
import com.example.HotelDemo.Model.Dto.BookingDto;
import com.example.HotelDemo.Model.Dto.DetailedBookingDto;
import com.example.HotelDemo.Service.BookingService;
import com.example.HotelDemo.Service.DetailedBookingService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.sql.SQLException;

@RestController
@RequiredArgsConstructor
@RequestMapping("/detailed-booking")
public class DetailedBookingController {
    @Autowired
    private final DetailedBookingService detailedBookingService;
    @Autowired
    private final ModelMapper modelMapper;

    // add detail-booking
    @PostMapping("/add")
    public ResponseEntity<?> addNewDetailedBooking(@RequestBody DetailedBookingDto detailedBookingDto) {
        if(detailedBookingDto != null) {
            DetailedBooking detailedBooking = new DetailedBooking();
            BeanUtils.copyProperties(detailedBookingDto,detailedBooking);

           detailedBookingService.addNewDetailedBookingService(detailedBooking);
            return ResponseEntity.ok().body(detailedBooking);
        }
        return ResponseEntity.badRequest().build();
    }

    //update detail-booking
    @PutMapping("/update-detailed-booking/{id}")
    public ResponseEntity<?> updateDetailedBooking(@PathVariable(name = "id") long bookingId,
                                           @RequestBody DetailedBookingDto detailedBookingDto)
            throws IOException, SQLException {
        DetailedBooking detailedBooking = new DetailedBooking();
        BeanUtils.copyProperties(detailedBookingDto,detailedBooking,"bookingId");

        detailedBookingService.updateDetailedBookingService(bookingId, detailedBooking);

        DetailedBookingDto detailedBookingDto1 = new DetailedBookingDto();
        BeanUtils.copyProperties(detailedBooking,detailedBookingDto1);

        return ResponseEntity.ok().body(detailedBookingDto1);
    }

    //delete detailed booking
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteDetailedBooking(@PathVariable(name = "id") long bookingId)
            throws IOException, SQLException{
        detailedBookingService.deleteDetailedBookingService(bookingId);

        return ResponseEntity.ok("Deleted.");
    }

}
