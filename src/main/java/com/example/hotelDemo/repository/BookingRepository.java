package com.example.HotelDemo.Repository;
import com.example.HotelDemo.Model.Booking;
import com.example.HotelDemo.Model.Dto.RoomBookingDto;
import com.example.HotelDemo.Model.Dto.RoomUserBookingDto;
import com.example.HotelDemo.Model.Dto.UserBookingDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import static com.example.HotelDemo.sql.QueryRewrite.*;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {

    @Query(value = queryRoomBooking, nativeQuery = true)
    RoomBookingDto findRoomAndBookingById(@Param("bookingId") Long bookingId);

    @Query(value = queryRoomUserBooking, nativeQuery = true)
    RoomUserBookingDto findRoomUserAndBookingById(@Param("bookingId") Long bookingId);

    @Query(value = queryAllDetailedBookings, nativeQuery = true)
    DetailedBookingDto findAllDetailedBookings();

    @Query(value = queryDetailedBooking, nativeQuery = true)
    DetailedBookingDto findDetailedBookingById(@Param("bookingId") Long bookingId);

    @Query(value = queryUserBooking, nativeQuery = true)
    UserBookingDto findUserAndBookingById(@Param("bookingId") Long bookingId);


}
