package com.example.HotelDemo.Model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "booking")
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int bookingId;

    @Column(name = "userId")
    private int userId;

    @Column(name = "roomId")
    private int roomId;

    @Column(name = "startTime")
    private LocalDate startTime;

    @Column(name = "endTime")
    private LocalDate endTime;

    @Column(name = "guest_FullName")
    private String guestFullName;

    @Column(name = "guest_Email")
    private String guestEmail;

    @Column(name = "adults")
    private int NumOfAdults;

    @Column(name = "children")
    private int NumOfChildren;

    @Column(name = "total_guest")
    private int totalNumOfGuest;

    @Column(name = "confirmation_Code")
    private String bookingConfirmationCode;//ma dat phong
    @Column(name = "method")
    private String paymentMethod;

    private void SumNumOfGuest(){
        this.totalNumOfGuest = this.totalNumOfGuest + this.NumOfAdults;
    }
    public void setNumOfAdults(int numOfAdults){
        this.NumOfAdults = numOfAdults;
        SumNumOfGuest();
    }
    public void setNumOfChildren(int numOfChildren){
        this.NumOfChildren = numOfChildren;
        SumNumOfGuest();
    }

}
