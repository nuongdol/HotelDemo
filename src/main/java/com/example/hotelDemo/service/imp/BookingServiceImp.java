package com.example.hotelDemo.service.imp;


import com.example.hotelDemo.enumHotel.EnumBooking;
import com.example.hotelDemo.exception.InvalidBookingRequestException;
import com.example.hotelDemo.exception.ResourceNotFoundException;
import com.example.hotelDemo.model.Booking;
import com.example.hotelDemo.model.MappingRoomBooking;
import com.example.hotelDemo.model.dto.BookingDto;
import com.example.hotelDemo.model.dto.RoomDto;
import com.example.hotelDemo.repository.BookingRepository;
import com.example.hotelDemo.repository.MappingRoomBookingRepository;
import com.example.hotelDemo.repository.RoomRepository;
import com.example.hotelDemo.service.BookingService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
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

    @Override
    public void addNewBooking(BookingDto bookingDto) {
        Booking booking = new Booking();
        List<RoomDto> rooms = bookingDto.getRooms();
        for (RoomDto roomDto : rooms) {
            SaveBooking(roomDto, bookingDto, booking);
        }
    }

    private void SaveBooking(RoomDto roomDto, BookingDto bookingDto, Booking booking) {
        if (Objects.equals(roomDto.getRoomStatus(), EMPTY.toString())) {
            bookingDto.setTotalNumberOfGuest(bookingDto.NumberOfGuest(bookingDto.getNumberOfChildren(), bookingDto.getNumberOfAdults()));
            BeanUtils.copyProperties(bookingDto, booking, "bookingId");
            if (LocalDate.now().isAfter(bookingDto.getCheckinDate()) || LocalDate.now().isBefore(bookingDto.getCheckoutDate())
                    &&
                    (LocalDate.now().isAfter(bookingDto.getCheckoutDate()) && LocalDate.now().isAfter(bookingDto.getCheckinDate()))) {
                booking.setBookingStatus(EnumBooking.FAILED.toString());
            }
            bookingRepository.save(booking);
            MappingRoomBooking map = new MappingRoomBooking();
            map.setBookingId(booking.getBookingId());
            map.setRoomId(roomDto.getRoomId());
            mappingRoomBookingRepository.save(map);
        } else {
            throw new InvalidBookingRequestException("Room status is not empty.");
        }
    }


    @Override
    public void updateBooking(BookingDto bookingDtoRequest) {
        Optional<Booking> booking = bookingRepository.findById(bookingDtoRequest.getBookingId());
        Booking bookingUpdate = new Booking();
        if (booking.isPresent()) {
            bookingUpdate = booking.get();
            BeanUtils.copyProperties(bookingDtoRequest, bookingUpdate, "bookingId");
        }
        bookingRepository.save(bookingUpdate);
    }

    @Override
    public List<BookingDto> getAllLstBooking() {
        return bookingRepository.findAll().stream().map(booking -> modelMapper.map(booking, BookingDto.class)).collect(Collectors.toList());
    }

    @Override
    public BookingDto getBookingById(Long bookingId) {
        Optional<Booking> booking = bookingRepository.findById(bookingId);
        BookingDto bookingDto = new BookingDto();
        booking.ifPresent(value -> BeanUtils.copyProperties(value, bookingDto, "bookingId"));
        return bookingDto;
    }

    @Override
    public void deleteBookingById(Long bookingId) {

        Optional<Booking> booking = bookingRepository.findById(bookingId);
        if (booking.isPresent()) {
            bookingRepository.deleteById(bookingId);
        } else {
            throw new ResourceNotFoundException("Booking not found");
        }
    }
}
