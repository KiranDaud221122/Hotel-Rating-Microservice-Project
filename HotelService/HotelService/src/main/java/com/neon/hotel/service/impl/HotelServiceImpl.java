package com.neon.hotel.service.impl;

import com.neon.hotel.entites.Hotel;
import com.neon.hotel.exception.ResourceNotFoundException;
import com.neon.hotel.repository.HotelRepository;
import com.neon.hotel.service.HotelService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class HotelServiceImpl implements HotelService{

    private final HotelRepository hotelRepository;

    // create new hotel
    @Override
    public Hotel create(Hotel hotel) {
        String hotelId = UUID.randomUUID().toString();
        hotel.setId(hotelId);
        return hotelRepository.save(hotel);
    }

    // get all hotels
    @Override
    public List<Hotel> getAll() {
        return hotelRepository.findAll();
    }

    //get single hotel detail
    @Override
    public Hotel get(String id) {
        return hotelRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Hotel not found with given Hotel ID: "+id));
    }
    @Override
    public Hotel update(String hotelId, Hotel hotel) {
        Hotel existing = hotelRepository.findById(hotelId).orElseThrow(() -> new ResourceNotFoundException("Hotel not found with given ID: " + hotelId));
        existing.setName(hotel.getName());
        existing.setLocation(hotel.getLocation());
        existing.setAbout(hotel.getAbout());
        return hotelRepository.save(existing);
    }

    @Override
    public void delete(String hotelId) {

        Hotel existing = hotelRepository.findById(hotelId).orElseThrow(() -> new ResourceNotFoundException("Hotel not found with given ID: " + hotelId));
        hotelRepository.delete(existing);
    }









}
