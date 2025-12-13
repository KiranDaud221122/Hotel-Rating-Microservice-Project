package com.neon.rating.controller;

import com.neon.rating.entites.Rating;
import com.neon.rating.service.RatingService;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/ratings")
public class RatingController {

    private final RatingService ratingService;

    // Create Rating — Only Admin
    @PostMapping("/create")
    public ResponseEntity<Rating> create( @RequestBody Rating rating) {
        return ResponseEntity.status(HttpStatus.CREATED).body(ratingService.create(rating));
    }

    // Get all ratings — Public
    @GetMapping("/all")
    public ResponseEntity<List<Rating>> getRatings() {
        return ResponseEntity.ok(ratingService.getRatings());
    }

    // Get ratings by user — Admin + Internal
    @GetMapping("/users/{userId}")
    public ResponseEntity<List<Rating>> getRatingByUserId(@PathVariable String userId) {
        return ResponseEntity.ok(ratingService.getRatingsByUSerId(userId));
    }

    // Get rating by hotel — Public
    @GetMapping("/hotels/{hotelId}")
    public ResponseEntity<List<Rating>> getRatingsByHotelId(@PathVariable String hotelId) {
        return ResponseEntity.ok(ratingService.getRatingsByHotelId(hotelId));
    }

    // Update Rating — Admin only
    @PutMapping("/update/{ratingId}")
    public ResponseEntity<Rating> updateRating(@PathVariable String ratingId, @RequestBody Rating rating) {
        return ResponseEntity.ok(ratingService.updateRating(ratingId, rating));
    }

    // Delete Rating — Admin only
    @DeleteMapping("/delete/{ratingId}")
    public ResponseEntity<Void> deleteRating(@PathVariable String ratingId) {
        ratingService.deleteRating(ratingId);
        return ResponseEntity.noContent().build();
    }
}
