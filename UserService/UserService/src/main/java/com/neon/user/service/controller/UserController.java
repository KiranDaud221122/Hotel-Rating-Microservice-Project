package com.neon.user.service.controller;

import com.neon.user.service.entities.User;
import com.neon.user.service.services.UserService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    // Create user — Public (Signup)
    @PostMapping("/create")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.saveUser(user));
    }

    // Get user by ID — Admin + Internal
    @Retry(name = "ratingHotelRetry", fallbackMethod = "ratingHotelFallback")
    @CircuitBreaker(name = "ratingHotelBreaker", fallbackMethod = "ratingHotelFallback")
    @RateLimiter(name = "ratingHotelRateLimiter", fallbackMethod = "ratingHotelFallback")
    @GetMapping("/{userId}")
    public ResponseEntity<User> getSingleUser(@PathVariable String userId) {
        return ResponseEntity.ok(userService.getUser(userId));
    }

    // Fallback
    public ResponseEntity<User> ratingHotelFallback(String userId, Exception ex) {
        User dummy = User.builder()
                .email("dummy@gmail.com")
                .name("Dummy User")
                .about("Fallback: Rating/Hotel service down")
                .build();
        return ResponseEntity.ok(dummy);
    }

    // Get all users — Admin only
    @GetMapping("/all")
    public ResponseEntity<List<User>> getAllUser() {
        return ResponseEntity.ok(userService.getAllUser());
    }

    // Update user — Admin only
    @PutMapping("/{userId}")
    public ResponseEntity<User> updateUser(@PathVariable String userId, @RequestBody User updatedUser) {
        return ResponseEntity.ok(userService.updateUserById(userId, updatedUser));
    }

    // Delete user — Admin only
    @DeleteMapping("/{userId}")
    public ResponseEntity<Void> deleteUser(@PathVariable String userId) {
        userService.deleteUserById(userId);
        return ResponseEntity.noContent().build();
    }
}
