package com.example.HotelDemo.Service;

import com.example.HotelDemo.Model.Hotel;

import java.util.List;

public interface IHotelService {
    Hotel addHotel(Hotel hotel);

    Hotel findHotelByIdHotel(Integer idHotel);

    List<Hotel> getAllHotels();

    Hotel getAHotel(Integer idHotel);

    void deleteHotelById(Hotel deleteHotel);
}
