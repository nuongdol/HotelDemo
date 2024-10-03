package com.example.HotelDemo.Service.imp;

import com.example.HotelDemo.Model.Booking;
import com.example.HotelDemo.Model.Dto.DetailedBookingDto;
import com.example.HotelDemo.Model.Dto.RoomBookingDto;
import com.example.HotelDemo.Model.Dto.RoomUserBookingDto;
import com.example.HotelDemo.Model.Dto.UserBookingDto;
import com.example.HotelDemo.Repository.BookingRepository;
import com.example.HotelDemo.Service.BookingService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BookingServiceImp implements BookingService {
    @Autowired
    private BookingRepository bookingRepository;

    @Override
    public void addNewBookingService(Booking booking) {
        bookingRepository.save(booking);
    }

    @Override
    public Booking updateBookingService(long bookingId, Booking bookingRequest) {
        Optional<Booking> booking = bookingRepository.findById(bookingId);

        Booking booking1 = new Booking();
        if(booking.isPresent()) {
            booking1 = booking.get();
        }

        BeanUtils.copyProperties(bookingRequest, booking1,"bookingId");
        return bookingRepository.save(booking1);
    }

    @Override
    public List<Booking> getAllBookingsService() {
        return bookingRepository.findAll();
    }

    @Override
    public Booking getBookingByIdService(long bookingId) {
        Optional<Booking> booking = bookingRepository.findById(bookingId);
        return booking.orElse(null);
    }

    @Override
    public void deleteBookingService(long bookingId) {
        Booking booking = bookingRepository.findById(bookingId).orElse(null);
        //validate booking  notNull
        assert booking != null;
        bookingRepository.delete(booking);
    }

    @Override
    public RoomBookingDto getRoomAndBookingByIdService(long bookingId) {
        return bookingRepository.findRoomAndBookingById(bookingId);
    }

    @Override
    public UserBookingDto getUserAndBookingService(long bookingId) {
        return bookingRepository.findUserAndBookingById(bookingId);
    }

    @Override
    public DetailedBookingDto getAllDetailedBookingService() {
        return bookingRepository.findAllDetailedBookings();
    }

    @Override
    public DetailedBookingDto getDetailedBookingService(long bookingId) {
        return bookingRepository.findDetailedBookingById(bookingId);
    }

    @Override
    public RoomUserBookingDto getRoomUserBookingService(long bookingId) {
        return bookingRepository.findRoomUserAndBookingById(bookingId);
    }

}
