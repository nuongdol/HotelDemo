package com.example.hotelDemo.repository;

import com.example.hotelDemo.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import static com.example.hotelDemo.sql.QueryRewrite.*;

@Repository
public interface RoomRepository extends JpaRepository <Room, Long>{
    @Query(value = queryHotelAndRoom, nativeQuery = true)
    List<Room> findHotelAndRoom(@Param("roomId") Long roomId);

}
