package com.example.ratingservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RatingDto {
//    @Min(value = 1, message = "Rating must be at least 1")
//    @Max(value = 5, message = "Rating must not exceed 5")
    private Integer rating;
    private Long bookId;
    private Long userId;


//            "bookId"
//            "isbn"
//            "title"
//            "seriesName"
//            "author"
//            "lexile"
//            "pageCount"
//            "minAge"
//            "maxAge"
//            "userId"
//            "rating"
}
