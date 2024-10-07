package com.example.hotelDemo.service.imp;


import com.example.hotelDemo.enumHotel.EnumBooking;
import com.example.hotelDemo.enumHotel.EnumHotel;
import com.example.hotelDemo.exception.InvalidBookingRequestException;
import com.example.hotelDemo.exception.InvalidHotelRequestException;
import com.example.hotelDemo.exception.ResourceNotFoundException;
import com.example.hotelDemo.model.Booking;
import com.example.hotelDemo.model.Hotel;
import com.example.hotelDemo.model.MappingRoomBooking;
import com.example.hotelDemo.model.Room;
import com.example.hotelDemo.model.dto.BookingDto;
import com.example.hotelDemo.model.dto.RoomDto;
import com.example.hotelDemo.repository.BookingRepository;
import com.example.hotelDemo.repository.HotelRepository;
import com.example.hotelDemo.repository.MappingRoomBookingRepository;
import com.example.hotelDemo.repository.RoomRepository;
import com.example.hotelDemo.service.BookingService;
<<<<<<< HEAD
import jakarta.transaction.Transactional;
=======
>>>>>>> 17fb990 (eight commit)
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
<<<<<<< HEAD
import java.util.ArrayList;
=======
>>>>>>> 17fb990 (eight commit)
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;
import static com.example.hotelDemo.enumHotel.EnumRoom.EMPTY;

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
<<<<<<< HEAD
    private HotelRepository hotelRepository;
=======
    private RoomRepository roomRepository;

>>>>>>> 17fb990 (eight commit)

    @Transactional
    @Override
    public void addNewBooking(BookingDto bookingDto) {
<<<<<<< HEAD
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
=======
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
>>>>>>> 17fb990 (eight commit)
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

<<<<<<< HEAD
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
=======
>>>>>>> 17fb990 (eight commit)

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
<<<<<<< HEAD
    @Transactional
    public void updateBooking(BookingDto bookingDtoRequest) {
        Optional<Booking> booking = Optional.of(bookingRepository.findById(bookingDtoRequest.getBookingId()).orElseThrow(() ->
                new ResourceNotFoundException("Booking not found.")));
=======
    public void updateBooking(BookingDto bookingDtoRequest) {
        Optional<Booking> booking = bookingRepository.findById(bookingDtoRequest.getBookingId());
>>>>>>> 17fb990 (eight commit)
        Booking bookingUpdate = new Booking();
        bookingUpdate = booking.get();
        BeanUtils.copyProperties(bookingDtoRequest, bookingUpdate, "bookingId");
        bookingRepository.save(bookingUpdate);
    }

    @Override
<<<<<<< HEAD
    public List<BookingDto> getAllLstBooking() {
=======
    public List<BookingDto> getAllBookings() {
>>>>>>> 17fb990 (eight commit)
        return bookingRepository.findAll().stream().map(booking -> modelMapper.map(booking, BookingDto.class)).collect(Collectors.toList());
    }

    @Override
    public BookingDto getBookingById(Long bookingId) {
<<<<<<< HEAD
        Optional<Booking> booking = Optional.of(bookingRepository.findById(bookingId).orElseThrow(() -> new ResourceNotFoundException("Booking not found.")));
=======
        Optional<Booking> booking = bookingRepository.findById(bookingId);
>>>>>>> 17fb990 (eight commit)
        BookingDto bookingDto = new BookingDto();
        booking.ifPresent(value -> BeanUtils.copyProperties(value, bookingDto, "bookingId"));
        return bookingDto;
    }

    @Override
<<<<<<< HEAD
    @Transactional
    public void deleteBookingById(Long bookingId) {
        Optional<Booking> booking = Optional.of(bookingRepository.findById(bookingId).orElseThrow(() -> new ResourceNotFoundException("Booking not found.")));
        bookingRepository.deleteById(booking.get().getBookingId());
        mappingRoomBookingRepository.deleteMappingRoomBookingByBookingId(booking.get().getBookingId());
=======
    public void deleteBooking(Long bookingId) {
        Optional<Booking> booking = bookingRepository.findById(bookingId);
        if (booking.isPresent()) {
            bookingRepository.deleteById(bookingId);
        } else {
            throw new ResourceNotFoundException("Booking not found");
        }
>>>>>>> 17fb990 (eight commit)
    }

}
