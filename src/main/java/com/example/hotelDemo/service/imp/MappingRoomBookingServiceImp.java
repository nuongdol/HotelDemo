package com.example.hotelDemo.service.imp;


import com.example.hotelDemo.model.dto.BookingDto;
import com.example.hotelDemo.model.dto.RoomBookingDto;
import com.example.hotelDemo.repository.MappingRoomBookingRepository;
import com.example.hotelDemo.service.MappingRoomBookingService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class MappingRoomBookingServiceImp implements MappingRoomBookingService {
    @Autowired
    private final MappingRoomBookingRepository mappingRoomBookingRepository;



    @Override
    public List<RoomBookingDto> getRoomAndBooking(Long roomId) {
        return mappingRoomBookingRepository.findRoomAndBooking(roomId)
                .stream().map(data-> {
                    RoomBookingDto output = new RoomBookingDto();
                    BeanUtils.copyProperties(data, output);
                    return output;
                })
                .collect(Collectors.toList());
    }
}
