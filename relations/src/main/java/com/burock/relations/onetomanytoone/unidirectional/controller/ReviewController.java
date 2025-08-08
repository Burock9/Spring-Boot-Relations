package com.burock.relations.onetomanytoone.unidirectional.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import com.burock.relations.onetomanytoone.unidirectional.entity.Review;
import com.burock.relations.onetomanytoone.unidirectional.service.ReviewService;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/reviews")
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    @PostMapping
    public Review saveReview(@RequestBody Review review) {
        return reviewService.saveReview(review);
    }

    @GetMapping
    public List<Review> getAllReviews() {
        return reviewService.getAllReviews();
    }

    @GetMapping("/{id}")
    public Review getReviewById(Long id) {
        return reviewService.getReviewById(id).orElse(null);
    }
    
    @PutMapping("/{id}")
    public Review updateReview(@PathVariable Long id, @RequestBody Review updatedReview) {
        return reviewService.updateReview(id, updatedReview);
    }

    @DeleteMapping("/{id}")
    public void deleteReview(@PathVariable Long id) {
        reviewService.deleteReview(id);
    }
}
