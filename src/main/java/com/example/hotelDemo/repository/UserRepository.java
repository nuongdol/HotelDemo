package com.example.hotelDemo.repository;

import com.example.hotelDemo.model.User;
import com.example.hotelDemo.model.dto.IUserBookingRoomDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import static com.example.hotelDemo.sql.QueryRewrite.QUERY_ROOM_BY_USER_ID;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    @Query(value = QUERY_ROOM_BY_USER_ID, nativeQuery = true)
    List<IUserBookingRoomDto> findRoomWithBookingVoucherByUserId(@Param("userId") Long userId);

}
