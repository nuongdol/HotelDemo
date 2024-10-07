package com.example.hotelDemo.repository;

import com.example.hotelDemo.model.Room;
<<<<<<< HEAD
import com.example.hotelDemo.model.dto.RoomDto;
=======
>>>>>>> 17fb990 (eight commit)
import com.example.hotelDemo.model.dto.RoomHotelDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import static com.example.hotelDemo.sql.QueryRewrite.*;

@Repository
public interface RoomRepository extends JpaRepository <Room, Long>{
<<<<<<< HEAD
    @Query(value = QUERY_ROOM_BY_STATUS_AND_HOTEL_ID, nativeQuery = true)
    List<RoomHotelDto> findLstRoomByStatusAndHotelId(@Param("status") String status, @Param("hotelId") Long hotelId);

    List<Room> findByHotelId(Long hotelId);
=======
    @Query(value = QUERY_ROOM_BY_STATUS, nativeQuery = true)
    List<RoomHotelDto> findHotelAndRoom(@Param("status") String status);
>>>>>>> 17fb990 (eight commit)

}
