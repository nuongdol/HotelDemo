package com.example.hotelDemo.sql;

public class QueryRewrite {
    //Room
    public static final String queryHotelAndRoom =
            "select r.room_id, r.room_name, h.hotel_id, h.hotel_name,\n" +
                    "h.address, h.city from room r inner join hotel h\n" +
                    "on r.hotel_id = h.hotel_id\n" +
                    "where r.room_id=:roomId";
    public static final String  queryARoomByStatus = "select * from room where status=:statusRoom";

    //Booking
    public static final String queryAllDetailedBookings
            ="select b.booking_id, b.checkin_date, b.checkout_date, b.total_price, b.booking_status\n" +
            ",db.adults, db.children, db.booking_confirmation, db.payment_method\n" +
            "from booking b, detailed_booking db where b.booking_id = db.booking_id\n";

    public static final String queryDetailedBooking =
            "select b.booking_id, b.checkin_date, b.checkout_date, b.total_price, b.booking_status\n" +
                    "db.adults, db.children, db.booking_confirmation, db.payment_method\n"+
                    "from booking b inner join detailed_booking db on b.booking_id = db.booking_id\n" +
                    "where b.booking_id=:bookingId";

    public static final String queryUserBooking =
            "select b.booking_id, u.user_name, u.email, u.phone, u.address\n" +
                    "from booking b inner join user u on u.user_id = b.user_id\n" +
                    "where b.booking_id=:bookingId";

    public static final String queryRoomBooking =
            "select b.booking_id, b.checkin_date, b.checkout_date,b.booking_status,\n" +
                    " r.room_name, r.room_type, r.room_capacity, r.room_price from booking b\n" +
                    "inner join room r on b.room_id = r.room_id\n" +
                    "where b.booking_id=:bookingId";

    public static final String queryRoomUserBooking =
            "select b.booking_id, r.room_name, r.room_type, r.room_capacity, r.room_price,\n" +
                    "u.user_name, u.email, u.phone, u.address\n" +
                    "from ((booking b inner join room r on b.room_id = r.room_id)\n" +
                    "inner join user u on u.user_id = b.user_id\n" +
                    "where b.booking_id=:bookingId;)";



}
