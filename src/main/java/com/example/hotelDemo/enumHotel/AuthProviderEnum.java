package com.example.hotelDemo.enumHotel;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor(force = true)
public enum AuthProviderEnum {
    LOCAL(1),
    FACEBOOK(2),
    GOOGLE(3),
    GITHUB(4);
    private final Integer value;
}
