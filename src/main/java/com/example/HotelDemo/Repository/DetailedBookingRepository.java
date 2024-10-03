package com.example.HotelDemo.Repository;

import com.example.HotelDemo.Model.DetailedBooking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetailedBookingRepository extends JpaRepository<DetailedBooking, Long> {

}
