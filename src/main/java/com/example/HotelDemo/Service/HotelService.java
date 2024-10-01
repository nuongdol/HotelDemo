package com.example.HotelDemo.Service;

import com.example.HotelDemo.Model.Hotel;
import com.example.HotelDemo.Repository.HotelRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import javax.sql.rowset.serial.SerialBlob;
import java.io.IOException;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class HotelService implements IHotelService {
    private final HotelRepository hotelRepository;
    @Override
    public Hotel addHotel(Hotel hotel) {
        Hotel newRoom = new Hotel(hotel.getHotelId(), hotel.getHotelCity(), hotel.getHotelName(),
                hotel.getHotelAddress(), hotel.getHotelImage());
        return hotelRepository.save(newRoom);
    }
    public Hotel addHotelWithImage(MultipartFile file) throws IOException, SQLException {
        Hotel hotel = new Hotel();
        if(file != null) {
            byte[] photoBytesH = file.getBytes();
            Blob photoBlobH = new SerialBlob(photoBytesH);
            hotel.setHotelImage(photoBlobH);
        }
        return hotelRepository.save(hotel);
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
