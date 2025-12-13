package com.neon.user.service.external_services;

import com.neon.user.service.entities.Rating;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name="RATINGSERVICE")
public interface RatingService {

    // CREATE rating
    @PostMapping("/ratings/create")
    Rating createRating(@RequestBody Rating rating);

    // GET all ratings
    @GetMapping("/ratings/all")
    List<Rating> getAllRatings();

    // GET rating by UserId
    @GetMapping("/ratings/users/{userId}")
    List<Rating> getRatingsByUserId(@PathVariable("userId") String userId);

    // GET ratings by HotelId
    @GetMapping("/ratings/hotels/{hotelId}")
    List<Rating> getRatingsByHotelId(@PathVariable("hotelId") String hotelId);

    // UPDATE rating
    @PutMapping("/ratings/update/{ratingId}")
    Rating updateRating(@PathVariable("ratingId") String ratingId,
                        @RequestBody Rating rating);

    // DELETE rating
    @DeleteMapping("/ratings/delete/{ratingId}")
    void deleteRating(@PathVariable("ratingId") String ratingId);
}
