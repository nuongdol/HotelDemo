package com.example.hotelDemo.repository;


import com.example.hotelDemo.model.MappingRoomBooking;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import static com.example.hotelDemo.sql.QueryRewrite.QUERY_MAPPING_BOOKING_AND_ROOM_BY_BOOKING_ID;


@Repository
public interface MappingRoomBookingRepository extends JpaRepository<MappingRoomBooking, Long> {

    @Modifying
    @Transactional
    @Query(value = QUERY_MAPPING_BOOKING_AND_ROOM_BY_BOOKING_ID , nativeQuery = true)
    void deleteMappingRoomBookingByBookingId(@Param("bookingId") Long bookingId);


}
