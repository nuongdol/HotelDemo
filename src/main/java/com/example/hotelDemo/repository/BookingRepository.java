package com.example.hotelDemo.repository;

import com.example.hotelDemo.model.Booking;
import com.example.hotelDemo.model.dto.RoomBookingDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import static com.example.hotelDemo.sql.QueryRewrite.*;


@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {

    @Query(value = QUERY_ROOM_BOOKING, nativeQuery = true)
    RoomBookingDto findRoomAndBookingById(@Param("bookingId") Long bookingId);

//    @Query(value = QUERY_CHECKIN_AND_CHECKOUT, nativeQuery = true)
//    UserBookingDto findUserAndBookingById(@Param("bookingId") Long bookingId);


}
