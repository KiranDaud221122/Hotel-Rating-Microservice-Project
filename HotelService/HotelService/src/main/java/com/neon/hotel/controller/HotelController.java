package com.neon.hotel.controller;

import com.neon.hotel.entites.Hotel;
import com.neon.hotel.service.HotelService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
 import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hotels")
@RequiredArgsConstructor
public class HotelController {

    private final HotelService hotelService;

    // Create hotel — Admin
    @PostMapping("/create")
    public ResponseEntity<Hotel> createHotel( @RequestBody Hotel hotel) {
        return ResponseEntity.status(HttpStatus.CREATED).body(hotelService.create(hotel));
    }

    // Get single hotel — Public
    @GetMapping("/{hotelId}")
    public ResponseEntity<Hotel> getSingle(@PathVariable String hotelId){
        return ResponseEntity.ok(hotelService.get(hotelId));
    }

    // Get all hotels — Public
    @GetMapping("/all")
    public ResponseEntity<List<Hotel>> getAll(){
        return ResponseEntity.ok(hotelService.getAll());
    }

    // Update hotel — Admin
    @PutMapping("/update/{hotelId}")
    public ResponseEntity<Hotel> updateHotel(@PathVariable String hotelId,@RequestBody Hotel hotel) {
        return ResponseEntity.ok(hotelService.update(hotelId, hotel));
    }

    // Delete hotel — Admin
    @DeleteMapping("/delete/{hotelId}")
    public ResponseEntity<Void> deleteHotel(@PathVariable String hotelId) {
        hotelService.delete(hotelId);
        return ResponseEntity.noContent().build();
    }
}
