package com.example.hotelDemo;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import com.example.hotelDemo.config.AppProperties;


@SpringBootApplication
@EnableConfigurationProperties(AppProperties.class)
public class HotelDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(HotelDemoApplication.class, args);
    }

}
