package com.example.HotelDemo.Repository;

import com.example.HotelDemo.Model.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

import static com.example.HotelDemo.sql.QueryRewrite.*;

@Repository
public interface HotelRepository extends JpaRepository<Hotel, Integer> {
    @Query(value = queryAHotel, nativeQuery = true)
    Hotel findAHotelById(@Param("idHotel")Integer idHotel);
    @Query(value = queryAllHotels, nativeQuery = true)
    Set<Hotel> findAllHotels();


}
