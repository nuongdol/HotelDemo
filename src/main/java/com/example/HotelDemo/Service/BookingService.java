package com.example.HotelDemo.Service;

import com.example.HotelDemo.Model.Booking;
import com.example.HotelDemo.Model.Dto.DetailedBookingDto;
import com.example.HotelDemo.Model.Dto.RoomBookingDto;
import com.example.HotelDemo.Model.Dto.RoomUserBookingDto;
import com.example.HotelDemo.Model.Dto.UserBookingDto;

import java.util.List;

public interface BookingService {

    void addNewBookingService(Booking booking);

    Booking updateBookingService(long bookingId, Booking booking);

    List<Booking> getAllBookingsService();

    Booking getBookingByIdService(long bookingId);

    void deleteBookingService(long bookingId);

    RoomBookingDto getRoomAndBookingByIdService(long bookingId);

    UserBookingDto getUserAndBookingService(long bookingId);

    DetailedBookingDto getAllDetailedBookingService();

    DetailedBookingDto getDetailedBookingService(long bookingId);

    RoomUserBookingDto getRoomUserBookingService(long bookingId);

}
