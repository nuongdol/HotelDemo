package com.example.HotelDemo.Controller;


import com.example.HotelDemo.Exception.CheckoutHotel;
import com.example.HotelDemo.Model.Hotel;
import com.example.HotelDemo.Service.HotelService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/hotel")
@RequiredArgsConstructor
public class HotelController {
    private final HotelService hotelService;
    //add a hotel
    @PostMapping("/add/new-hotel")
    public ResponseEntity<?> addNewHotel(@RequestBody Hotel hotel){
        if(hotel != null){
            Hotel add = hotelService.addHotel(hotel);
            return ResponseEntity.ok(add);
        }
        return ResponseEntity.badRequest().build();
    }
    //update a hotel
    @PutMapping("/update-hotel/{id}")
    public ResponseEntity<?> updateHotel(@PathVariable(name = "id") Integer idHotel, @RequestBody Hotel hotel)
            throws IOException, SQLException{
        Hotel updateHotel = hotelService.findHotelByIdHotel(idHotel);
        if(updateHotel.getHotelAddress() != hotel.getHotelAddress() || updateHotel.getHotelAddress() == null){
            updateHotel.setHotelAddress(hotel.getHotelAddress());
        }
        if(updateHotel.getHotelCity() == null || updateHotel.getHotelCity() != hotel.getHotelCity()){
            updateHotel.setHotelCity(hotel.getHotelCity());
        }
        if(updateHotel.getHotelName() == null || updateHotel.getHotelName() != hotel.getHotelName()){
            updateHotel.setHotelName(hotel.getHotelName());
        }
        return ResponseEntity.ok(updateHotel);
    }

    //get all hotel
    @GetMapping("/get-all-hotels")
    public ResponseEntity<List<Hotel>> getAllHotels() throws IOException, SQLException {
        List<Hotel> getAll = hotelService.getAllHotels();
        return ResponseEntity.ok(getAll);
    }
    //get a hotel
    @GetMapping("/get-a-hotel/{id}")
    public ResponseEntity<?> getAHotel(@PathVariable(name = "id") Integer idHotel) throws IOException, SQLException{
        try{
            Hotel hotel = hotelService.getAHotel(idHotel);
            return ResponseEntity.ok(hotel);
        }catch (CheckoutHotel e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    // delete a hotel
    @DeleteMapping("/delete/hotel/{id}")
    public ResponseEntity<?> deleteHotel(@PathVariable(name = "id") Integer idHotel) throws IOException, SQLException{
        Hotel deleteHotel= hotelService.findHotelByIdHotel(idHotel);
        if(deleteHotel != null){
            hotelService.deleteHotelById(deleteHotel);
        }
        return ResponseEntity.ok("Delete hotel " + deleteHotel);
    }
}
