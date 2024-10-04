package com.example.hotelDemo.sql;

public class QueryRewrite {
    //Room
    public static final String queryHotelAndRoom =
            "select r.id, r.name, h.id, h.name,\n" +
                    "h.address, h.city from room r inner join hotel h\n" +
                    "on r.id = h.id\n" +
                    "where r.id=:roomId";

    //Mapping room and booking
    // tu bang mapping room and booking, lay bookingId co roomId duoc chi dinh cho san
    public static final String queryCheckinAndCheckout=
            "select b.id as bookId, b.checkout_date as checkoutDate, b.checkin_date as checkinDate\n" +
                    "from ((mapping_room_booking m join booking b on m.booking_id = b.id)\n" +
                    " join room r on m.room_id = r.id) where m.room_id=:roomId";

    //Booking
    public static final String queryUserBooking =
            "select b.id, u.name, u.email, u.phone, u.address\n" +
                    "from booking b inner join user u on u.id = b.id\n" +
                    "where b.id=:bookingId";

    public static final String queryRoomBooking =
            "select b.booking_id, b.checkin_date, b.checkout_date,b.booking_status,\n" +
                    " r.name, r.type, r.capacity, r.price from booking b\n" +
                    "inner join room r on b.id = r.id\n" +
                    "where b.id=:bookingId";

    public static final String queryRoomUserBooking =
            "select b.id, r.name, r.type, r.capacity, r.price,\n" +
                    "u.name, u.email, u.phone, u.address\n" +
                    "from ((booking b inner join room r on b.id = r.id)\n" +
                    "inner join user u on u.id = b.id\n" +
                    "where b.id=:bookingId;)";



}
