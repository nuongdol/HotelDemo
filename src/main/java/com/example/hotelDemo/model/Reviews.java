package com.example.hotelDemo.model;

import java.util.Date;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Reviews {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "review_id")
    Long reviewId;
    @Column(name = "user_id")
    Long userId;
    @Column(name = "hotel_id")
    Long hotelId;
    @Column(name = "rating_id")
    Long ratingId;
    @Column(name = "comment")
    String comment;
    @Column(name = "create_at")
    Date createAt;
    @Column(name = "deleted_flag")
    Integer deletedFlag;
}
