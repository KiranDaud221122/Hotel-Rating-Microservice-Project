package com.neon.user.service.services.impl;

import com.neon.user.service.Exception.ResourceNotFoundException;
import com.neon.user.service.entities.Hotel;
import com.neon.user.service.entities.Rating;
import com.neon.user.service.entities.User;
import com.neon.user.service.external_services.HotelService;
import com.neon.user.service.external_services.RatingService;
import com.neon.user.service.repositories.UserRepository;
import com.neon.user.service.services.UserService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final HotelService hotelService;     // Feign
    private final RatingService ratingService;   // Feign

    private final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    // CREATE USER
    @Override
    public User saveUser(User user) {
        user.setUserId(UUID.randomUUID().toString());
        return userRepository.save(user);
    }

    // GET ALL USERS
    @Override
    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    // GET USER WITH RATINGS + HOTEL DETAILS (FULL MICRO SERVICE CALL)
    @Override
    public User getUser(String userId) {

        // Step 1: Fetch user
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found: " + userId));

        // Step 2: Fetch all ratings for this user using FEIGN
        List<Rating> ratings = ratingService.getRatingsByUserId(userId);
        logger.info("Ratings fetched for user {} -> {}", userId, ratings);

        // Step 3: Fetch hotel details for each rating using FEIGN
        List<Rating> enrichedRatings = ratings.stream()
                .map(r -> {
                    Hotel hotel = hotelService.getHotel(r.getHotelId());
                    r.setHotel(hotel);   // attach hotel object into rating
                    return r;
                }).collect(Collectors.toList());

        // Step 4: Set ratings into user
        user.setRating(enrichedRatings);

        return user;
    }

    // DELETE USER
    @Override
    public void deleteUserById(String userId) {
        User existing = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found: " + userId));

        userRepository.delete(existing);
    }

    // UPDATE USER
    @Override
    public User updateUserById(String userId, User updatedUser) {

        User existing = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found: " + userId));

        existing.setName(updatedUser.getName());
        existing.setEmail(updatedUser.getEmail());
        existing.setAbout(updatedUser.getAbout());

        return userRepository.save(existing);
    }
}
