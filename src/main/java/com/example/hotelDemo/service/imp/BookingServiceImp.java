package com.example.hotelDemo.service.imp;


import com.example.hotelDemo.enumHotel.EnumBooking;
import com.example.hotelDemo.enumHotel.EnumHotel;
import com.example.hotelDemo.exception.InvalidBookingRequestException;
import com.example.hotelDemo.exception.InvalidHotelRequestException;
import com.example.hotelDemo.exception.ResourceNotFoundException;
import com.example.hotelDemo.model.Booking;
import com.example.hotelDemo.model.Hotel;
import com.example.hotelDemo.model.MappingRoomBooking;
import com.example.hotelDemo.model.dto.BookingDto;
import com.example.hotelDemo.model.dto.RoomDto;
import com.example.hotelDemo.repository.BookingRepository;
import com.example.hotelDemo.repository.HotelRepository;
import com.example.hotelDemo.repository.MappingRoomBookingRepository;
import com.example.hotelDemo.service.BookingService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;
import static com.example.hotelDemo.enumHotel.EnumRoom.EMPTY;

@Service
@RequiredArgsConstructor
public class BookingServiceImp implements BookingService {

    @Autowired
    private BookingRepository bookingRepository;
    @Autowired
    private MappingRoomBookingRepository mappingRoomBookingRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private HotelRepository hotelRepository;

    @Transactional
    @Override
    public void addNewBooking(BookingDto bookingDto) {
<<<<<<< HEAD
        Hotel hotel = hotelRepository.findById(bookingDto.getHotelId())
                .orElseThrow(()->new ResourceNotFoundException("Hotel not found"));
        if(Objects.equals(hotel.getHotelStatus(),EnumHotel.ACTIVITY.toString())) {
            Booking booking = new Booking();
            List<RoomDto> rooms = bookingDto.getRooms();
            List<Booking> bookings = new ArrayList<>();
            List<MappingRoomBooking> mappingRoomBookings = new ArrayList<>();
            for (RoomDto roomDto : rooms) {
                SaveBooking(roomDto, bookingDto, booking, bookings);

            }
            List<Booking> bookingSaveAll = bookingRepository.saveAll(bookings);
            bookingSaveAll.stream().limit(1).forEach(bookingSave -> {
                rooms.forEach(roomSave -> {
                    MappingRoomBooking mappingRoomBooking = new MappingRoomBooking();
                    mappingRoomBooking.setBookingId(bookingSave.getBookingId());
                    mappingRoomBooking.setRoomId(roomSave.getRoomId());
                    mappingRoomBookings.add(mappingRoomBooking);
                });
            });
            mappingRoomBookingRepository.saveAll(mappingRoomBookings);
        }else {
            throw new InvalidHotelRequestException("Hotel is not activity");
=======
        Booking booking = new Booking();
        List<RoomDto> rooms = bookingDto.getRooms();
        List<Booking> bookings = new ArrayList<>();
        List<MappingRoomBooking> mappingRoomBookings = new ArrayList<>();
        for (RoomDto roomDto : rooms) {
            SaveBooking(roomDto, bookingDto, booking, bookings);

>>>>>>> e32e7fb (twelve)
        }
        List<Booking> bookingSaveAll = bookingRepository.saveAll(bookings);
        bookingSaveAll.stream().limit(1).forEach(bookingSave -> {
            rooms.forEach(roomSave -> {
                MappingRoomBooking mappingRoomBooking = new MappingRoomBooking();
                mappingRoomBooking.setBookingId(bookingSave.getBookingId());
                mappingRoomBooking.setRoomId(roomSave.getRoomId());
                mappingRoomBookings.add(mappingRoomBooking);
            });
        });
        mappingRoomBookingRepository.saveAll(mappingRoomBookings);
    }

    private void SaveBooking(RoomDto roomDto, BookingDto bookingDto, Booking booking,
                             List<Booking> bookings) {
        if (Objects.equals(roomDto.getRoomStatus(), EMPTY.toString())) {
            bookingDto.setTotalNumberOfGuest(bookingDto.NumberOfGuest(bookingDto.getNumberOfChildren(), bookingDto.getNumberOfAdults()));
            BeanUtils.copyProperties(bookingDto, booking,"bookingId");
            if (LocalDate.now().isAfter(bookingDto.getCheckinDate()) || LocalDate.now().isBefore(bookingDto.getCheckoutDate())
                    &&
                    (LocalDate.now().isAfter(bookingDto.getCheckoutDate()) && LocalDate.now().isAfter(bookingDto.getCheckinDate()))) {
                booking.setBookingStatus(EnumBooking.FAILED.toString());
            }
            bookings.add(booking);
        } else {
            throw new InvalidBookingRequestException("Room status is not empty.");
        }
    }


    @Override
    @Transactional
    public void updateBooking(BookingDto bookingDtoRequest) {
        Optional<Booking> booking = Optional.of(bookingRepository.findById(bookingDtoRequest.getBookingId()).orElseThrow(() ->
                new ResourceNotFoundException("Booking not found.")));
        Booking bookingUpdate = new Booking();
        bookingUpdate = booking.get();
        BeanUtils.copyProperties(bookingDtoRequest, bookingUpdate, "bookingId");
        bookingRepository.save(bookingUpdate);
    }

    @Override
    public List<BookingDto> getAllLstBooking() {
        return bookingRepository.findAll().stream().map(booking -> modelMapper.map(booking, BookingDto.class)).collect(Collectors.toList());
    }

    @Override
    public BookingDto getBookingById(Long bookingId) {
        Optional<Booking> booking = Optional.of(bookingRepository.findById(bookingId).orElseThrow(() -> new ResourceNotFoundException("Booking not found.")));
        BookingDto bookingDto = new BookingDto();
        booking.ifPresent(value -> BeanUtils.copyProperties(value, bookingDto, "bookingId"));
        return bookingDto;
    }

    @Override
    @Transactional
    public void deleteBookingById(Long bookingId) {
        Optional<Booking> booking = Optional.of(bookingRepository.findById(bookingId).orElseThrow(() -> new ResourceNotFoundException("Booking not found.")));
        bookingRepository.deleteById(booking.get().getBookingId());
        mappingRoomBookingRepository.deleteMappingRoomBookingByBookingId(booking.get().getBookingId());
    }

}
