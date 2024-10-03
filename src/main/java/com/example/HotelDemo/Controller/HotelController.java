package com.example.HotelDemo.Controller;


import com.example.HotelDemo.Exception.CheckoutHotel;
import com.example.HotelDemo.Model.Dto.HotelDto;
import com.example.HotelDemo.Model.Hotel;
import com.example.HotelDemo.Service.imp.HotelServiceImp;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/hotel")
@RequiredArgsConstructor
public class HotelController {
    @Autowired
    private final ModelMapper modelMapper;
    @Autowired
    private HotelServiceImp hotelServiceImp;

    //add a hotel
    @PostMapping("/add/new-hotel")
    public ResponseEntity<?> addNewHotel(@RequestBody HotelDto hotelDto){
        Hotel hotel = new Hotel();

        if(hotelDto != null){
            BeanUtils.copyProperties(hotelDto, hotel);
            Hotel hotel1 = hotelServiceImp.addNewHotelService(hotel);
            return ResponseEntity.ok().body(hotel1);
        }

        return ResponseEntity.badRequest().build();
    }

    //update a hotel
    @PutMapping("/update-hotel/{id}")
    public ResponseEntity<?> updateHotel(@PathVariable(name = "id") long hotelId,
                                         @RequestBody HotelDto hotelDto) throws IOException, SQLException{

        Hotel hotel = new Hotel();
        BeanUtils.copyProperties(hotelDto, hotel);
        Hotel hotel1 = hotelServiceImp.updateHotelService(hotelId, hotel);

        HotelDto hotelResponse = new HotelDto();
        BeanUtils.copyProperties(hotel1, hotelResponse);

        return ResponseEntity.ok().body(hotelResponse);
    }

    //get all hotel
    @GetMapping("/get-all-hotels")
    public ResponseEntity<List<HotelDto>> getAllHotels() throws IOException, SQLException {

        List<HotelDto> allHotelsDto = hotelServiceImp.getAllHotelsService().stream().map(hotel -> modelMapper.map(hotel, HotelDto.class))
                .collect(Collectors.toList());
        return ResponseEntity.ok().body(allHotelsDto);
    }

    //get a hotel
    @GetMapping("/get-hotel/{id}")
    public ResponseEntity<?> getHotelById(@PathVariable(name = "id") long hotelId)
            throws IOException, SQLException{
        try{
            Hotel hotel = hotelServiceImp.getHotelByIdService(hotelId);

            HotelDto hotelDto = new HotelDto();
            BeanUtils.copyProperties(hotel, hotelDto);

            return ResponseEntity.ok(hotelDto);
        }catch (CheckoutHotel e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    // delete a hotel
    @DeleteMapping("/delete-hotel/{id}")
    public ResponseEntity<?> deleteHotel(@PathVariable(name = "id") long hotelId) throws IOException, SQLException{
        hotelServiceImp.deleteHotelService(hotelId);
        return ResponseEntity.ok("Deleted hotel.");
    }
}
