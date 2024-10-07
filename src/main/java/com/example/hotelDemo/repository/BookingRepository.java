package com.example.hotelDemo.repository;

import com.example.hotelDemo.model.Booking;
<<<<<<< HEAD
=======
import com.example.hotelDemo.model.dto.RoomBookingDto;
>>>>>>> 17fb990 (eight commit)
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {
<<<<<<< HEAD
=======

    @Query(value = QUERY_ROOM_BOOKING, nativeQuery = true)
    RoomBookingDto findRoomAndBookingById(@Param("bookingId") Long bookingId);

//    @Query(value = QUERY_CHECKIN_AND_CHECKOUT, nativeQuery = true)
//    UserBookingDto findUserAndBookingById(@Param("bookingId") Long bookingId);


>>>>>>> 17fb990 (eight commit)
}
