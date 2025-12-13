package com.neon.rating.service.Impl;

import com.neon.rating.entites.Rating;
import com.neon.rating.repository.RatingRepository;
import com.neon.rating.service.RatingService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class RatingServiceImpl implements RatingService {

    private final RatingRepository ratingRepository;


    // Create Rating
    @Override
    public Rating create(Rating rating) {
        return ratingRepository.save(rating);
    }

    // get all rating
    @Override
    public List<Rating> getRatings() {
        return ratingRepository.findAll();
    }

    //get rating by Userid
    @Override
    public List<Rating> getRatingsByUSerId(String userId) {
        return ratingRepository.findByUserId(userId);
    }

    // get all ratings by hotel id
    @Override
    public List<Rating> getRatingsByHotelId(String hotelId) {
        return ratingRepository.findByHotelId(hotelId);
    }

    @Override
    public Rating updateRating(String ratingId, Rating rating) {

        Rating existing = ratingRepository.findById(ratingId).orElseThrow(() -> new RuntimeException("Rating not found with id: " + ratingId));

        existing.setUserId(rating.getUserId());
        existing.setHotelId(rating.getHotelId());
        existing.setRating(rating.getRating());
        existing.setFeedback(rating.getFeedback());

        return ratingRepository.save(existing);
    }

    @Override
    public void deleteRating(String ratingId) {

        Rating existing = ratingRepository.findById(ratingId)
                .orElseThrow(() -> new RuntimeException("Rating not found with id: " + ratingId));

        ratingRepository.delete(existing);
    }












}
