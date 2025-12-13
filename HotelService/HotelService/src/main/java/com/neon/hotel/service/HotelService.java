package com.neon.hotel.service;

import com.neon.hotel.entites.Hotel;

import java.util.List;

public interface HotelService {

    // create hotel
    Hotel create(Hotel hotel);

    // get all hotels
    List<Hotel> getAll();

    // get single hotel
    Hotel get(String id);

    Hotel update(String hotelId, Hotel hotel);

    void delete(String hotelId);

}
