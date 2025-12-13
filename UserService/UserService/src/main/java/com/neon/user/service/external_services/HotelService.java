package com.neon.user.service.external_services;

import com.neon.user.service.entities.Hotel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name ="HOTELSERVICE")
public interface HotelService {

    @GetMapping("/hotels/{hotelId}")
    public Hotel getHotel(@PathVariable String hotelId);

    @GetMapping("/hotels/all")
    List <Hotel> getAllHotel();

    @PostMapping("/hotels/create")
    public Hotel createHotel(@RequestBody Hotel hotel);

    @PutMapping("/hotels/update/{hotelId}")
    public Hotel updateHotel(@PathVariable String hotelId , @RequestBody Hotel hotel);

    @DeleteMapping("/hotels/delete/{hotelId}")
    public void deleteHotel(@PathVariable String hotelId);






}
