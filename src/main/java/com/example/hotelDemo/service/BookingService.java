package com.example.hotelDemo.service;

import com.example.hotelDemo.model.dto.BookingDto;

import java.util.List;

public interface BookingService {

    void addNewBookingService(Long roomId, BookingDto bookingDto);

    void updateBookingService(BookingDto bookingDto);

    List<BookingDto> getAllBookingsService();

    BookingDto getBookingByIdService(Long bookingId);

    void deleteBookingService(Long bookingId);
}
