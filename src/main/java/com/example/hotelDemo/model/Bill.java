package com.example.hotelDemo.model;

import java.math.BigDecimal;
import com.example.hotelDemo.enumHotel.PaymentMethodEnum;
import com.example.hotelDemo.enumHotel.PaymentStatusEnum;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Bill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bill_id")
    Long billId;
    @Column(name = "bill_cost")
    BigDecimal billCost;
    @Column(name = "payment_method")
    PaymentMethodEnum paymentMethod;
    @Column(name = "payment_status")
    PaymentStatusEnum paymentStatus;
}
