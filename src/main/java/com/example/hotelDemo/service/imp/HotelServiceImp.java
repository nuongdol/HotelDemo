package com.example.hotelDemo.service.imp;


import com.example.hotelDemo.exception.ResourceNotFoundException;
import com.example.hotelDemo.model.Hotel;
import com.example.hotelDemo.model.dto.HotelDto;
import com.example.hotelDemo.model.dto.IRoomBookingDto;
import com.example.hotelDemo.repository.HotelRepository;
import com.example.hotelDemo.service.HotelService;
import jakarta.transaction.Transactional;
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

    @Transactional
    @Override
    public void addNewHotel(HotelDto hotelDto) {
        Hotel hotel = new Hotel();
        BeanUtils.copyProperties(hotelDto, hotel);
        hotelRepository.save(hotel);
    }

    @Override
    @Transactional
    public void updateHotel(HotelDto hotelDto) {
        Optional<Hotel> hotel = Optional.of(hotelRepository.findById(hotelDto.getHotelId()).orElseThrow(()->new ResourceNotFoundException("Hotel not found")));
        Hotel hotelUpdate = hotel.get();
        BeanUtils.copyProperties(hotelDto, hotelUpdate);

    }

    @Override
    public List<HotelDto> getAllLstHotel() {
        return hotelRepository.findAll().stream()
                .map(hotel -> modelMapper.map(hotel, HotelDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public HotelDto getHotelById(Long hotelId) {
        Optional<Hotel> hotel = Optional.of(hotelRepository.findById(hotelId)
                .orElseThrow(()-> new ResourceNotFoundException("Hotel not found")));
        HotelDto hotelDto = new HotelDto();
        hotel.ifPresent(value -> BeanUtils.copyProperties(value, hotelDto));
        return hotelDto;
    }

    @Override
    @Transactional
    public void deleteHotelById(Long hotelId) {
        Optional<Hotel> hotel = Optional.of(hotelRepository.findById(hotelId)
                .orElseThrow(() -> new ResourceNotFoundException("Hotel not found")));
        hotelRepository.deleteById(hotel.get().getHotelId());
    }

    @Override
    public List<IRoomBookingDto> getAllLstRoomWithBookingVoucherByHotelId(Long hotelId) {
        if (hotelRepository.existsById(hotelId)) {
            return hotelRepository.findRoomWithBookingVoucherByHotelId(hotelId);
        }else{
            throw new ResourceNotFoundException("Room list with booking voucher not found");
        }
    }

    @Override
    public void changeStatusHotelById(Long hotelId, String status) {
        Hotel hotel = hotelRepository.findById(hotelId).orElseThrow(()-> new ResourceNotFoundException("Hotel not found"));
        hotel.setHotelStatus(status);
        hotelRepository.save(hotel);
    }
}
