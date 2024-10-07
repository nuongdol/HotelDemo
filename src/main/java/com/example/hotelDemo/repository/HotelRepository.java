package com.example.hotelDemo.repository;

import com.example.hotelDemo.model.Hotel;
import com.example.hotelDemo.model.dto.IRoomBookingDto;
import com.example.hotelDemo.model.dto.RoomBookingDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.example.hotelDemo.sql.QueryRewrite.QUERY_ROOM_BOOKING_BY_HOTEL_ID;
import static com.example.hotelDemo.sql.QueryRewrite.QUERY_ROOM_BOOKING_BY_HOTELID;


@Repository
public interface HotelRepository extends JpaRepository<Hotel, Long> {
    @Query(value = QUERY_ROOM_BOOKING_BY_HOTEL_ID, nativeQuery = true)
    List<IRoomBookingDto> findRoomWithBookingVoucherByHotelId(@Param("hotelId") Long hotelId);

    @Query(value = QUERY_ROOM_BOOKING_BY_HOTELID, nativeQuery = true)
    List<IRoomBookingDto> findBookingAndRoomByHotelId(@Param("hotelId") Long hotelId);

}
