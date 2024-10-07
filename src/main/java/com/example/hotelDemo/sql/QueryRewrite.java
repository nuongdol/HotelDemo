package com.example.hotelDemo.sql;

public class QueryRewrite {
    //Room
<<<<<<< HEAD
    public static final String QUERY_ROOM_BY_STATUS_AND_HOTEL_ID =
=======
    public static final String QUERY_ROOM_BY_STATUS =
>>>>>>> 17fb990 (eight commit)
            "select r.id as roomId,\n" +
                    "r.name as roomName,\n" +
                    "r.type as roomType,\n" +
                    "r.capacity as roomCapacity,\n" +
                    "r.price as roomPrice,\n" +
<<<<<<< HEAD
                    "r.status as roomStatus ,\n" +
                    "r.description as roomDescription ,\n" +
                    "r.image as roomImage,\n" +
                    "h.name as hotelName\n" +
                    "from room r\n" +
                    "join hotel h on r.hotel_id = h.id\n" +
                    "where r.status=:status and h.id=:hotelId";

    public static final String QUERY_ROOM_BY_USER_ID =
=======
                    "r.status as roomDescription ,\n" +
                    "r.image as roomStatus,\n" +
                    "h.name as hotelName\n" +
                    "from room r\n" +
                    "join hotel h on r.id = h.id\n" +
                    "where r.status=:status";

    //Booking
    public static final String QUERY_ROOM_BOOKING =
            "select " +
                    "b.booking_id as bookingId, " +
                    "b.checkin_date as checkinDate, " +
                    "b.checkout_date as checkoutDate," +
                    "b.booking_status as bookingStatus," +
                    "r.name, " +
                    "r.type, " +
                    "r.capacity, " +
                    "r.price " +
                    "from booking b" +
                    "join room r on b.id = r.id" +
                    "where b.id=:bookingId";

    public static final String QUERY_ROOM_USER_BOOKING =
            "select " +
                    "b.id, " +
                    "r.name, " +
                    "r.type, " +
                    "r.capacity, " +
                    "r.price, " +
                    "u.name, " +
                    "u.email, " +
                    "u.phone, " +
                    "u.address" +
                    "from booking b join room r on b.id = r.id" +
                    "join user u on u.id = b.id" +
                    "where b.id=:bookingId";

    public static final String QUERY_ROOM_BY_USERID =
>>>>>>> 17fb990 (eight commit)
            "select u.name as userName,\n" +
                    "u.email,\n" +
                    "h.name as hotelName,\n" +
                    "b.checkin_date as checkinDate,\n" +
                    "b.checkout_date as checkoutDate,\n" +
                    "b.total_price as totalPrice,\n" +
                    "b.adults as numberOfAdults,\n" +
                    "b.children as numberOfChildren,\n" +
                    "b.total_guest as totalNumberOfGuest,\n" +
                    "b.payment_method as paymentMethod,\n" +
                    "r.name as roomName, \n" +
                    "r.price as roomPrice,\n" +
<<<<<<< HEAD
                    "case\n " +
                    "when b.checkin_date > date(now()) or b.checkout_date < date(now())\n" +
                    "and not (b.checkin_date < date(now()) and b.checkout_date < date(now())) then 'full'\n" +
                    "else 'empty'\n" +
                    "end as roomStatus,\n" +
=======
                    "r.status as roomStatus,\n" +
>>>>>>> 17fb990 (eight commit)
                    "r.type as roomType\n" +
                    "from booking b\n" +
                    "join user u on b.user_id = u.id\n" +
                    "join hotel h on b.hotel_id = h.id\n" +
                    "join mapping_room_booking m on b.id = m.booking_id\n" +
                    "join room r on m.room_id = r.id\n" +
<<<<<<< HEAD
                    "where u.id=:userId\n" +
                    "and (b.checkin_date > date(now())\n" +
                    "or b.checkout_date < date(now()))" +
                    "and not (b.checkin_date < date(now())" +
                    "and b.checkout_date < date(now()))";

    //getHotelAndBookingByHotelId
    public static final String QUERY_ROOM_BOOKING_BY_HOTEL_ID =
            "select h.name as hotelName,\n" +
                    "b.id,\n" +
                    "b.checkin_date as checkinDate,\n" +
                    "b.checkout_date as checkoutDate,\n " +
                    "b.total_price as totalPrice,\n" +
                    "b.adults as numberOfAdults,\n" +
                    "b.children as numberOfChildren,\n" +
                    "b.total_guest as totalNumberOfGuest,\n" +
                    "b.payment_method as paymentMethod,\n" +
                    "case\n" +
                    "when b.checkin_date > date(now()) or b.checkout_date < date(now())\n" +
                    "and not (b.checkin_date < date(now()) and b.checkout_date < date(now())) then 'successful'\n" +
                    "else 'failed' end as bookingStatus,\n" +
                    "r.name as roomName,\n" +
                    "r.type as roomType,\n" +
                    "r.capacity as roomCapacity,\n" +
                    "r.price as roomPrice,\n" +
                    "r.status as roomStatus\n" +
                    "from hotel h\n" +
                    "join booking b on h.id = b.hotel_id\n" +
                    "join room r on h.id = r.hotel_id\n" +
                    "where h.id=:hotelId";

<<<<<<< HEAD
=======

>>>>>>> e32e7fb (twelve)
    public static final String QUERY_MAPPING_BOOKING_AND_ROOM_BY_BOOKING_ID =
            "delete from mapping_room_booking mp where mp.booking_id=:bookingId";
=======
                    "where u.id=:userId";

    //getHotelAndBookingByHotelId
    public static final String QUERY_ROOM_BOOKING_BY_HOTELID =
            "select h.name as hotelName,\n" +
                    "b.id,\n" +
                    "b.checkin_date as checkinDate,\n" +
                    "b.checkout_date as checkoutDate,\n " +
                    "b.total_price as totalPrice,\n" +
                    "b.adults as numberOfAdults,\n" +
                    "b.children as numberOfChildren,\n" +
                    "b.total_guest as totalNumberOfGuest,\n" +
                    "b.payment_method as paymentMethod,\n" +
                    "b.status as bookingStatus,\n" +
                    "r.name as roomName,\n" +
                    "r.type as roomType,\n" +
                    "r.capacity as roomCapacity,\n" +
                    "r.price as roomPrice,\n" +
                    "r.status as roomStatus\n" +
                    "from hotel h\n" +
                    "join booking b on h.id = b.hotel_id\n" +
                    "join room r on h.id = r.hotel_id\n" +
                    "where h.id=:hotelId";
>>>>>>> 17fb990 (eight commit)
}
