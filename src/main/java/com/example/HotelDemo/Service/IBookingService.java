package com.example.HotelDemo.Service;

import com.example.HotelDemo.Model.Booking;


import java.util.List;

public interface IBookingService {
    List<Booking> getAllBookings();
    Booking getABooking(Integer idBooking);
    Booking addBooking(Booking booking);

    Booking findBookingByIdBooking(Integer idBooking);

    void deleteBookingById(Booking deleteBooking);
}
