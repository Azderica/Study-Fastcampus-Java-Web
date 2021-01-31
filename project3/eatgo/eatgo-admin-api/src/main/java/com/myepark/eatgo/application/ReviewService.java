package com.myepark.eatgo.application;

import com.myepark.eatgo.domain.Review;
import com.myepark.eatgo.domain.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    public Review addReview(Long restaurantId, Review review){
        Review saved = Review.builder()
                .restaurantId(restaurantId)
                .name(review.getName())
                .score(review.getScore())
                .description(review.getDescription())
                .build();
        return reviewRepository.save(saved);
    }

    public List<Review> getReviews() {
        return reviewRepository.findAll();
    }
}
