package com.example.ratingservice.controller;

import com.example.ratingservice.dto.RatingDto;
import com.example.ratingservice.model.Rating;
import com.example.ratingservice.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/ratings")
public class RatingController {
    private final RatingService ratingService;

    @Autowired
    public RatingController(RatingService ratingService) {
        this.ratingService = ratingService;
    }

    @GetMapping
    public ResponseEntity<List<Rating>> getAllRatings() {
        List<Rating> ratings = ratingService.getAllRatings();
        return ResponseEntity.ok(ratings);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Rating> getRatingById(@PathVariable Long id) {
        Optional<Rating> rating = ratingService.getRatingById(id);
        return rating.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/book/{bookId}/average")
    public ResponseEntity<Double> getAverageRatingByBookId(@PathVariable Long bookId) {
        double averageRating = ratingService.getAverageRatingByBookId(bookId);
        return ResponseEntity.ok(averageRating);
    }

    @PostMapping
    public ResponseEntity<Rating> addRating(@RequestBody RatingDto ratingDto) {
        Rating addedRating = ratingService.addRating(ratingDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(addedRating);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRating(@PathVariable Long id) {
        ratingService.deleteRating(id);
        return ResponseEntity.noContent().build();
    }
}
