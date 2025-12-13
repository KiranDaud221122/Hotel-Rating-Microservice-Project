package com.neon.rating.service;

import com.neon.rating.entites.Rating;

import java.util.List;

public interface RatingService {

    // Create Rating
    Rating create(Rating rating);

    // get all rating
    List<Rating> getRatings();

    //get rating by Userid
     List<Rating> getRatingsByUSerId(String userId);

     // get all ratings by hotel id
    List<Rating> getRatingsByHotelId(String hotelId);


    // update rating
    Rating updateRating(String ratingId, Rating rating);

    // delete rating
    void deleteRating(String ratingId);




}
