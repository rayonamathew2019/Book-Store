package com.example.ratingservice.service;

import com.example.ratingservice.dto.RatingDto;
import com.example.ratingservice.model.Rating;
import com.example.ratingservice.repository.RatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RatingService {
    private final RatingRepository ratingRepository;

    @Autowired
    public RatingService(RatingRepository ratingRepository) {
        this.ratingRepository = ratingRepository;
    }

    public List<Rating> getAllRatings() {
        return ratingRepository.findAll();
    }

    public Optional<Rating> getRatingById(Long id) {
        return ratingRepository.findById(id);
    }

    public Integer getAverageRatingByBookId(Long bookId) {
        return (int) ratingRepository.findByBookId(bookId)
                .stream()
                .mapToInt(Rating::getRating)
                .average()
                .orElse(0);
    }

    public Rating addRating(RatingDto ratingDto) {
        Rating rating = new Rating();
        rating.setBookId(ratingDto.getBookId());
        rating.setUserId(ratingDto.getUserId());
        rating.setRating(ratingDto.getRating());

        return ratingRepository.save(rating);
    }

    public void deleteRating(Long id) {
        ratingRepository.deleteById(id);
    }
}
