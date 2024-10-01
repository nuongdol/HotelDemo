package com.example.HotelDemo.Repository;

import com.example.HotelDemo.Model.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Set;
import static com.example.HotelDemo.sql.QueryRewrite.*;

@Repository
public interface RoomRepository extends JpaRepository <Room, Integer>{

    @Query(value = queryARoom, nativeQuery = true)
    Room findARoomById(@Param("idRoom")Integer idRoom);
    @Query(value = queryAllRooms, nativeQuery = true)
    Set<Room> findAllRooms();
    @Query(value = queryARoomByStatus, nativeQuery = true)
    List<Room> findARoomByStatus(@Param("status") String status);

}
