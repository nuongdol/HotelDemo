package com.example.hotelDemo.sql;

import org.springframework.data.jpa.repository.Query;

public class QueryRewrite {
    //Room
    public static final String QUERY_ROOM_BY_STATUS_AND_HOTEL_ID =
            "select r.id as roomId,\n" +
                    "r.name as roomName,\n" +
                    "r.type as roomType,\n" +
                    "r.capacity as roomCapacity,\n" +
                    "r.price as roomPrice,\n" +
                    "r.status as roomStatus ,\n" +
                    "r.description as roomDescription ,\n" +
                    "r.image as roomImage,\n" +
                    "h.name as hotelName\n" +
                    "from room r\n" +
                    "join hotel h on r.hotel_id = h.id\n" +
                    "where r.status=:status and h.id=:hotelId";

    public static final String QUERY_ROOM_BY_USER_ID =
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
                    "case\n " +
                    "when b.checkin_date > date(now()) or b.checkout_date < date(now())\n" +
                    "and not (b.checkin_date < date(now()) and b.checkout_date < date(now())) then 'full'\n" +
                    "else 'empty'\n" +
                    "end as roomStatus,\n" +
                    "r.type as roomType\n" +
                    "from booking b\n" +
                    "join user u on b.user_id = u.id\n" +
                    "join hotel h on b.hotel_id = h.id\n" +
                    "join mapping_room_booking m on b.id = m.booking_id\n" +
                    "join room r on m.room_id = r.id\n" +
                    "where u.id=:userId\n" +
                    "and b.checkin_date > date(now())\n" +
                    "or b.checkout_date < date(now())" +
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

    public static final String QUERY_MAPPING_BOOKING_AND_ROOM_BY_BOOKING_ID =
            "delete from mapping_room_booking mp where mp.booking_id=:bookingId";

    public static final String QUERY_ROOMS_BY_KEYWORD =
            "select \n " +
                    "r.id, \n" +
                    "r.name as roomName, \n" +
                    "r.type as roomType, \n" +
                    "r.capacity as roomCapacity, \n" +
                    "r.price as roomPrice, \n" +
                    "r.description as roomDescription, \n" +
                    "r.status as roomStatus, \n" +
                    "r.image as roomImage \n" +
                    "from room r \n" +
                    "join hotel h \n" +
                    "on r.hotel_id = h.id \n" +
                    "where \n" +
                    "(r.description like concat('%', :searchWord, '%') \n" +
                    "or r.name like concat('%', :searchWord, '%') \n" +
                    "or r.capacity like concat('%', :searchWord, '%')\n" +
                    "or r.type like concat('%', :searchWord, '%') \n" +
                    "or cast(r.price as char) like concat('%', :searchWord, '%')\n" +
                    "or r.status like concat('%', :searchWord, '%'))\n" +
                    "and h.name = :hotelName";

    public static final String QUERY_ROOMS_BY_ADDRESS_AND_DATE =
    "select r.name as roomName, r.type as roomType, r.capacity as roomCapacity\n" +
            "r.price as roomPrice, r.description as roomDescription\n" +
            "r.status as roomStatus, r.image as roomImage, h.name\n" +
            "from hotel h join room r on r.hotel_id = h.id\n" +
            "join booking b on b.hotel_id = h.id \n" +
            "where h.address = :address and\n" +
            "not (b.checkin_date >=:checkinDate AND b.checkin_date <=:checkoutDate)\n" +
            "and\n" +
            "not (b.checkout_date >=:checkinDate AND b.checkout_date <=:checkoutDate)";
}
