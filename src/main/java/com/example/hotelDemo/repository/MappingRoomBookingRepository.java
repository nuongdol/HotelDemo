package com.example.hotelDemo.repository;


import com.example.hotelDemo.model.MappingRoomBooking;
import com.example.hotelDemo.model.dto.IRoomBookingDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import static com.example.hotelDemo.sql.QueryRewrite.queryCheckinAndCheckout;


@Repository
public interface MappingRoomBookingRepository extends JpaRepository<MappingRoomBooking, Long> {

    @Query(value = queryCheckinAndCheckout, nativeQuery = true)
    List<IRoomBookingDTO> findRoomAndBooking(@Param("roomId") Long roomId);

}
