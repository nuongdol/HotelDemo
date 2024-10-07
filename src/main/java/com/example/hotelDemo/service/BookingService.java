package com.example.hotelDemo.service;

import com.example.hotelDemo.model.dto.BookingDto;

import java.util.List;

public interface BookingService {

    void addNewBooking(BookingDto bookingDto);

    void updateBooking(BookingDto bookingDto);

    List<BookingDto> getAllBookings();

    BookingDto getBookingById(Long bookingId);

    void deleteBooking(Long bookingId);
}
