package com.example.HotelDemo.Service.imp;

import com.example.HotelDemo.Model.DetailedBooking;
import com.example.HotelDemo.Repository.DetailedBookingRepository;
import com.example.HotelDemo.Service.DetailedBookingService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DetailedBookingImp implements DetailedBookingService {

    @Autowired
    private DetailedBookingRepository detailedBookingRepository;

    @Override
    public void addNewDetailedBookingService(DetailedBooking detailedBooking) {
        detailedBookingRepository.save(detailedBooking);
    }

    @Override
    public DetailedBooking updateDetailedBookingService(long bookingId, DetailedBooking detailedBookingRequest) {
        Optional<DetailedBooking> detailedBooking = detailedBookingRepository.findById(bookingId);

        DetailedBooking detailedBooking1 = new DetailedBooking();
        if(detailedBooking.isPresent()) {
            detailedBooking1 = detailedBooking.get();
        }
        BeanUtils.copyProperties(detailedBookingRequest, detailedBooking1,"bookingId");
        return detailedBookingRepository.save(detailedBooking1);
    }

    @Override
    public void deleteDetailedBookingService(long bookingId) {
        DetailedBooking detailedBooking =  detailedBookingRepository.findById(bookingId).orElse(null);
        assert detailedBooking != null;
        detailedBookingRepository.delete(detailedBooking);
    }

}
