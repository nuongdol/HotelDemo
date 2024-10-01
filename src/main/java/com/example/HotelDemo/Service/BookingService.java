package com.example.HotelDemo.Service;

import com.example.HotelDemo.Model.Booking;
import com.example.HotelDemo.Repository.BookingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BookingService implements IBookingService {
    private final BookingRepository bookingRepository;
    @Override
    public List<Booking> getAllBookings() {
        List<Booking> bookings = new ArrayList<Booking>();
        bookingRepository.findAllBookings().forEach(booking -> bookings.add(booking));
        return bookings;
    }

    @Override
    public Booking getABooking(Integer idBooking) {
        Booking booking = new Booking();
        booking = bookingRepository.findABookingById(idBooking);
        return booking;
    }

    @Override
    public Booking addBooking(Booking booking) {
        Booking newBooking = new Booking(booking.getBookingId(), booking.getUserId(),
                booking.getRoomId(), booking.getStartTime(), booking.getEndTime(),
                booking.getGuestFullName(), booking.getGuestEmail(),
                booking.getNumOfAdults(),
                booking.getNumOfChildren(),booking.getTotalNumOfGuest()
        ,booking.getBookingConfirmationCode(),booking.getPaymentMethod());
        return bookingRepository.save(newBooking);
    }

    @Override
    public Booking findBookingByIdBooking(Integer idBooking) {
        return bookingRepository.findABookingById(idBooking);
    }

    @Override
    public void deleteBookingById(Booking deleteBooking) {
        bookingRepository.delete(deleteBooking);
    }
}
