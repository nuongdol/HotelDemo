package com.example.HotelDemo.Repository;
import com.example.HotelDemo.Model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

import static com.example.HotelDemo.sql.QueryRewrite.*;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Integer> {
    @Query(value = queryABooking, nativeQuery = true)
    Booking findABookingById(@Param("idBooking")Integer idBooking);
    @Query(value = queryAllBookings, nativeQuery = true)
    List<Booking> findAllBookings();
}
