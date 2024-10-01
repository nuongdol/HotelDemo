package com.example.HotelDemo.sql;

public class QueryRewrite {
    //Room
    public static final String queryARoom = "select * from room where room.room_id =:idRoom";
    public static final String queryAllRooms = "select * from room";
    public static final String  queryARoomByStatus = "select * from room where status =:statusRoom";

    //Hotel
    public static final String queryAHotel = "select * from hotel where hotel_id =:idHotel";
    public static final String queryAllHotels = "select * from hotel";

    //User
    public static final String queryAUser = "select * from user where user_id =:idUser";
    public static final String queryAllUsers = "select * from user";
    public static final String queryAUserByUserEmail = "select * from user where user_email =:idUserEmail";

    //Booking
    public static final String getQueryABooking = "select * from booking where booking_id =:idBooking";
    public static final String queryAllBookings = "select * from booking";

}
