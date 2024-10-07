package com.example.hotelDemo.service.imp;


import com.example.hotelDemo.exception.InvalidBookingRequestException;
import com.example.hotelDemo.exception.ResourceNotFoundException;
import com.example.hotelDemo.model.Booking;
import com.example.hotelDemo.model.MappingRoomBooking;
import com.example.hotelDemo.model.Room;
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
import static com.example.hotelDemo.enumHotel.EnumRoom.FULL;

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
    private RoomRepository roomRepository;


    @Override
    public void addNewBooking(BookingDto bookingDto) {
        //ngay checkout truoc ngay checkin
        if (bookingDto.getCheckoutDate().isBefore(bookingDto.getCheckinDate())) {
            throw new InvalidBookingRequestException("Check-in date must come before check-out date.");
        }
        Booking booking = new Booking();
        List<RoomDto> rooms = bookingDto.getRooms();
        for (RoomDto roomDto : rooms) {
            Room room = new Room();
            if (LocalDate.now().equals(bookingDto.getCheckinDate())) {
//                if (Objects.equals(roomDto.getRoomStatus(), EMPTY.toString())) {
//                    BeanUtils.copyProperties(bookingDto, booking,"bookingId");
//                    bookingRepository.save(booking);
//                    MappingRoomBooking map = new MappingRoomBooking();
//                    map.setBookingId(booking.getBookingId());
//                    map.setRoomId(roomDto.getRoomId());
//                    mappingRoomBookingRepository.save(map);
//                }else{
//                    throw new InvalidBookingRequestException("Room status is not empty.");
//                }
                SaveBooking(roomDto, bookingDto, booking);
                roomDto.setRoomStatus(FULL.toString());
                BeanUtils.copyProperties(roomDto, room);
                roomRepository.save(room);
            } else {
                SaveBooking(roomDto, bookingDto, booking);
                roomDto.setRoomStatus(EMPTY.toString());
                BeanUtils.copyProperties(roomDto, room);
                roomRepository.save(room);
            }
        }

//        if (roomIsAvailable(bookingDto.getRoomId(), bookingDto)) {
//            Booking booking = new Booking();
//            BeanUtils.copyProperties(bookingDto, booking);
//            bookingRepository.save(booking);
//            MappingRoomBooking map = new MappingRoomBooking();
//            map.setRoomId(bookingDto.getRoomId());
//            map.setBookingId(booking.getBookingId());
//            mappingRoomBookingRepository.save(map);
//        }

    }
    private void SaveBooking(RoomDto roomDto, BookingDto bookingDto, Booking booking) {
        if (Objects.equals(roomDto.getRoomStatus(), EMPTY.toString())) {
            bookingDto.setTotalNumberOfGuest(bookingDto.NumberOfGuest(bookingDto.getNumberOfChildren(), bookingDto.getNumberOfAdults()));
            BeanUtils.copyProperties(bookingDto, booking, "bookingId");
            bookingRepository.save(booking);
            MappingRoomBooking map = new MappingRoomBooking();
            map.setBookingId(booking.getBookingId());
            map.setRoomId(roomDto.getRoomId());
            mappingRoomBookingRepository.save(map);
        } else {
            throw new InvalidBookingRequestException("Room status is not empty.");
        }
    }


//    private boolean roomIsAvailable(Long roomId, BookingDto bookingDto) {
//        List<RoomBookingDto> roomBookingDtoList =
//                mappingRoomBookingService.getRoomAndBooking(roomId);
//
//        return roomBookingDtoList.stream().noneMatch(booking ->
//                //ngay checkin cua bookingDto bang ngay checkin cua phong do duoc dat truoc do
//                bookingDto.getCheckinDate().equals(booking.getCheckinDate())
//
//                        //ngay check out cua phong do duoc dat truoc ngay checkout cua phong do duoc dat do
//                        || bookingDto.getCheckoutDate().isBefore(booking.getCheckoutDate())
//
//                        //ngay checkin cua phong do sau ngay  checkin cua phong do duoc dat truoc do
//                        // va ngay checkin cua phong do truoc ngay checkout cua phong do duoc dat truoc do
//                        || (bookingDto.getCheckinDate().isAfter(booking.getCheckinDate())
//                        && bookingDto.getCheckinDate().isBefore(booking.getCheckoutDate()))
//
//                        //ngay checkin cua phong do duoc dat truoc ngay checkin cua phong do duoc dat truoc do
//                        //ngay checkout bang ngay checkout cua phong dat truoc do
//                        || (bookingDto.getCheckinDate().isBefore(booking.getCheckinDate())
//                        && bookingDto.getCheckoutDate().equals(booking.getCheckoutDate()))
//
//                        //ngay checkin cua phong do duoc dat truoc ngay checkin cua phong do duoc dat truoc do
//                        //ngay checkout sau ngay checkout cua phong do duoc dat truoc do
//                        || (bookingDto.getCheckinDate().isBefore(booking.getCheckinDate())
//                        && bookingDto.getCheckoutDate().isAfter(booking.getCheckoutDate()))
//
//                        //ngay checkin cua phòng do duoc dat bang ngay checkout cua phòng đó được đặt trước đó
//                        //ngay checkout của phòng do duoc dat bang ngay checkin cua phong do duoc dat truoc do
//                        || (bookingDto.getCheckinDate().equals(booking.getCheckoutDate())
//                        && (bookingDto.getCheckoutDate().equals(booking.getCheckinDate())))
//
//        );
//    }

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
    public List<BookingDto> getAllBookings() {
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
    public void deleteBooking(Long bookingId) {
        Optional<Booking> booking = bookingRepository.findById(bookingId);
        if (booking.isPresent()) {
            bookingRepository.deleteById(bookingId);
        } else {
            throw new ResourceNotFoundException("Booking not found");
        }
    }
}
