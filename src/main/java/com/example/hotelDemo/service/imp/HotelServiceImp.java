package com.example.HotelDemo.Service.imp;

import com.example.HotelDemo.Model.Hotel;
import com.example.HotelDemo.Repository.HotelRepository;
import com.example.HotelDemo.Service.HotelService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class HotelServiceImp implements HotelService {
    @Autowired
    private final HotelRepository hotelRepository;

    @Override
    public Hotel addNewHotelService(Hotel hotel) {
        return hotelRepository.save(hotel);
    }

    @Override
    public Hotel updateHotelService(long hotelId, Hotel hotelRequest) {

        Optional<Hotel> hotel = hotelRepository.findById(hotelId);
        Hotel hotel1 = new Hotel();
        if(hotel.isPresent()){
            hotel1 = hotel.get();
        }
        BeanUtils.copyProperties(hotel1,hotel, "hotelId");

        return hotelRepository.save(hotel1);
    }

    @Override
    public List<Hotel> getAllHotelsService() {
        return hotelRepository.findAll();
    }

    @Override
    public Hotel getHotelByIdService(long hotelId) {
        Optional<Hotel> hotel = hotelRepository.findById(hotelId);
        return hotel.orElse(null);
    }

    @Override
    public void deleteHotelService(long hotelId) {
        Hotel hotel = hotelRepository.findById(hotelId).orElse(null);
        assert hotel != null;
        hotelRepository.delete(hotel);


    }
}
