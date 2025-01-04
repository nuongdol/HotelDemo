package com.example.hotelDemo.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import lombok.experimental.FieldDefaults;
import net.minidev.json.annotate.JsonIgnore;
import org.springframework.data.annotation.CreatedDate;

import java.util.Date;
import com.example.hotelDemo.enumHotel.AuthProviderEnum;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "user")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    @Column(name = "id")
    Long userId;

    @Column(name = "name", nullable = false)
    String userName;

    @Column(nullable = false)
    @JsonIgnore
    String password;

    @Column(nullable = false)
    String email;

    String phone;

    String address;

    @Column(name = "delete_flag")
    private Integer deleteFlag;

    @Column(name = "create_at")
    @CreatedDate
    protected Date createAt;

    String role;

    @Column(nullable = false)
    Boolean emailVerified = false;

    @NotNull
    @Enumerated(EnumType.STRING)
    AuthProviderEnum authProvider;

    String providerId;

}

