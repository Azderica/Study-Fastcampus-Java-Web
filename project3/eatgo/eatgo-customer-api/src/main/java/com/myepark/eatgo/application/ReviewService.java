package com.myepark.eatgo.application;

import com.myepark.eatgo.domain.Review;
import com.myepark.eatgo.domain.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    public Review addReview(Long restaurantId, String name, Integer score,
                            String description) {
        Review review = Review.builder()
                .restaurantId(restaurantId)
                .name(name)
                .score(score)
                .description(description)
                .build();

        return reviewRepository.save(review);
    }
}
