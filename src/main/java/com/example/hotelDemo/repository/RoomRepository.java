package com.example.HotelDemo.Repository;

import com.example.HotelDemo.Model.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import static com.example.HotelDemo.sql.QueryRewrite.*;

@Repository
public interface RoomRepository extends JpaRepository <Room, Long>{
    @Query(value = queryARoomByStatus, nativeQuery = true)
    List<Room> findRoomByStatus(@Param("status") String status);

    @Query(value = queryHotelAndRoom, nativeQuery = true)
    List<Room> findHotelAndRoom(@Param("roomId") Long roomId);

}
