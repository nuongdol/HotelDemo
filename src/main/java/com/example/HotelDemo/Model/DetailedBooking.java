package com.example.HotelDemo.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "detailed_booking")
public class DetailedBooking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "booking_id")
    private Long bookingId;

    @Column(name = "adults")
    private Integer numberOfAdults;

    @Column(name = "children")
    private Integer numberOfChildren;

    @Column(name = "total_guest")
    private Integer totalNumberOfGuest;


    private String bookingConfirmation;

    private String paymentMethod;

    private void SumNumberOfGuest(){
        this.totalNumberOfGuest = this.numberOfChildren + this.numberOfAdults;
    }
    public void setNumberOfChildren(Integer numberOfChildren){
        this.numberOfChildren = numberOfChildren;
        SumNumberOfGuest();
    }
    public void setNumberOfAdults(Integer numberOfAdults){
        this.numberOfAdults = numberOfAdults;
        SumNumberOfGuest();
    }

}
