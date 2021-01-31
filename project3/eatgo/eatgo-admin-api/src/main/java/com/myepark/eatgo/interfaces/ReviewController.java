package com.myepark.eatgo.interfaces;

import com.myepark.eatgo.application.ReviewService;
import com.myepark.eatgo.domain.Review;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    @GetMapping("/reviews")
    public List<Review> list() {
        List<Review> reviews = reviewService.getReviews();

        return reviews;
    }
}
