package com.example.hotelDemo.repository;


import com.example.hotelDemo.model.MappingRoomBooking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;




@Repository
public interface MappingRoomBookingRepository extends JpaRepository<MappingRoomBooking, Long> {

//    @Query(value = QUERY_CHECKIN_AND_CHECKOUT, nativeQuery = true)
//    List<IRoomBookingDTO> findRoomAndBooking(@Param("roomId") Long roomId);

}
