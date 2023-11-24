package com.lvg.rest.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lvg.rest.entity.Reviews;
import com.lvg.rest.exception.ReviewNotFoundException;
import com.lvg.rest.service.ReviewsService;
@RestController             //its
@RequestMapping("/reviews")//http:localhost:8092/reviews/8001
public class ReviewsController {
	@Autowired
	ReviewsService reviewsService;
	
	@GetMapping(produces="application/json")
	public ResponseEntity<List<Reviews>> getAllReviews(){
		return new ResponseEntity<List<Reviews>> (reviewsService.getAllReviews(),HttpStatus.OK);
		
	}
	
	@GetMapping(value="/{reviewId}",produces="application/json")
	public ResponseEntity<Reviews> getReviewsById(@PathVariable int reviewId){
		return new ResponseEntity<Reviews>(reviewsService.getReviewsById(reviewId),HttpStatus.OK);
		
	}
	
	@GetMapping(value="/product/{productId}",produces="application/json")
	public ResponseEntity<Reviews> getReviewsByProductId(@PathVariable int productId){
		return new ResponseEntity<Reviews>(reviewsService.getReviewsByProductId(productId),HttpStatus.OK);
		
	}

	/*@ExceptionHandler(ReviewNotFoundException.class)
	    public HttpStatus reviewNotFoundExceptionHandler(ReviewNotFoundException ex) {
		System.out.println(ex);
		return HttpStatus.NO_CONTENT;
		
	}*/
}