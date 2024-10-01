package com.example.HotelDemo.Service;

import com.example.HotelDemo.Model.Hotel;
import com.example.HotelDemo.Repository.HotelRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class HotelService implements IHotelService {
    private final HotelRepository hotelRepository;
    @Override
    public Hotel addHotel(Hotel hotel) {
        Hotel newRoom = new Hotel(hotel.getHotelId(), hotel.getHotelCity(), hotel.getHotelName(), hotel.getHotelAddress());
        return hotelRepository.save(newRoom);
    }

    @Override
    public Hotel findHotelByIdHotel(Integer idHotel) {
        return null;
    }

    @Override
    public List<Hotel> getAllHotels() {
        List<Hotel> hotels = new ArrayList<Hotel>();
        hotelRepository.findAllHotels().forEach(hotel -> hotels.add(hotel));
        return hotels;
    }

    @Override
    public Hotel getAHotel(Integer idHotel) {
        Hotel hotel = new Hotel();
        hotel = hotelRepository.findAHotelById(idHotel);
        return hotel;
    }

    @Override
    public void deleteHotelById(Hotel deleteHotel) {
        hotelRepository.deleteById(deleteHotel.getHotelId());
    }
}
