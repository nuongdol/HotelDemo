package com.example.HotelDemo.Service;

import com.example.HotelDemo.Model.Hotel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class HotelService implements IHotelService {
    @Override
    public Hotel addHotel(Hotel hotel) {
        return null;
    }

    @Override
    public Hotel findHotelByIdHotel(Integer idHotel) {
        return null;
    }

    @Override
    public List<Hotel> getAllHotels() {
        return List.of();
    }

    @Override
    public Hotel getAHotel(Integer idHotel) {
        return null;
    }

    @Override
    public void deleteHotelById(Hotel deleteHotel) {

    }
}
