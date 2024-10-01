package com.example.HotelDemo.Service;

import com.example.HotelDemo.Model.Booking;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookingService implements IBookingService {

    @Override
    public List<Booking> getAllBookings() {
        return List.of();
    }

    @Override
    public Booking getABooking(Integer idBooking) {
        return null;
    }

    @Override
    public Booking addBooking(Booking booking) {
        return null;
    }

    @Override
    public Booking findBookingByIdBooking(Integer idBooking) {
        return null;
    }

    @Override
    public void deleteBookingById(Booking deleteBooking) {

    }
}
