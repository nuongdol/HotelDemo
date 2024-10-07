package com.example.hotelDemo.service.imp;


<<<<<<< HEAD

import com.example.hotelDemo.service.MappingRoomBookingService;
import lombok.RequiredArgsConstructor;
=======
import com.example.hotelDemo.model.dto.RoomBookingDto;
import com.example.hotelDemo.repository.MappingRoomBookingRepository;
import com.example.hotelDemo.service.MappingRoomBookingService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
>>>>>>> 17fb990 (eight commit)
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class MappingRoomBookingServiceImp implements MappingRoomBookingService {

<<<<<<< HEAD
=======

//    @Override
//    public List<RoomBookingDto> getRoomAndBooking(Long roomId) {
//        return mappingRoomBookingRepository.findRoomAndBooking(roomId)
//                .stream().map(data-> {
//                    RoomBookingDto output = new RoomBookingDto();
//                    BeanUtils.copyProperties(data, output);
//                    return output;
//                })
//                .collect(Collectors.toList());
//
//    }
>>>>>>> 17fb990 (eight commit)
}
