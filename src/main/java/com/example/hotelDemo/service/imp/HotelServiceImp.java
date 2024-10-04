package com.example.hotelDemo.service.imp;


import com.example.hotelDemo.exception.ResourceNotFoundException;
import com.example.hotelDemo.model.Hotel;
import com.example.hotelDemo.model.dto.HotelDto;
import com.example.hotelDemo.repository.HotelRepository;
import com.example.hotelDemo.service.HotelService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class HotelServiceImp implements HotelService {
    @Autowired
    private final HotelRepository hotelRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public void addNewHotelService(HotelDto hotelDto) {
        Hotel hotel = new Hotel();
        BeanUtils.copyProperties(hotelDto, hotel);
        hotelRepository.save(hotel);
    }

    @Override
    public void updateHotelService(HotelDto hotelDto) {
        Optional<Hotel> hotel = hotelRepository.findById(hotelDto.getHotelId());
        Hotel hotelUpdate = new Hotel();
        if(hotel.isPresent()){
            hotelUpdate = hotel.get();
            BeanUtils.copyProperties(hotelDto, hotelUpdate);
        }else {
            throw new ResourceNotFoundException("Sorry, Hotel not found.");
        }
    }

    @Override
    public List<HotelDto> getAllHotelsService() {
        return hotelRepository.findAll().stream()
                .map(hotel -> modelMapper.map(hotel,HotelDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public HotelDto getHotelByIdService(Long hotelId) {
        Optional<Hotel> hotel = hotelRepository.findById(hotelId);
        HotelDto hotelDto = new HotelDto();
        hotel.ifPresent(value -> BeanUtils.copyProperties(value, hotelDto));
        return hotelDto;
    }

    @Override
    public void deleteHotelService(Long hotelId) {
        Optional<Hotel> hotel = hotelRepository.findById(hotelId);
        if(hotel.isPresent()){
            hotelRepository.deleteById(hotelId);
        }else{
            throw new ResourceNotFoundException("Sorry, Hotel not found.");
        }
    }
}
