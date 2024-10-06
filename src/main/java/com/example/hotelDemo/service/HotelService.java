package com.example.HotelDemo.Service;

import com.example.HotelDemo.Model.Hotel;

import java.util.List;
import java.util.Optional;

public interface HotelService {


    Hotel addNewHotelService(Hotel hotel);

    Hotel updateHotelService(long hotelId, Hotel hotel);

    List<Hotel> getAllHotelsService();

    Hotel getHotelByIdService(long hotelId);

    void deleteHotelService(long hotelId);
}
