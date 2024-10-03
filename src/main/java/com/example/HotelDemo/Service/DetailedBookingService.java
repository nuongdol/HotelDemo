package com.example.HotelDemo.Service;

import com.example.HotelDemo.Model.DetailedBooking;
import org.springframework.stereotype.Service;


public interface DetailedBookingService {

    void addNewDetailedBookingService(DetailedBooking detailedBooking);

    DetailedBooking updateDetailedBookingService(long bookingId, DetailedBooking detailedBooking);

    void deleteDetailedBookingService(long bookingId);
}
