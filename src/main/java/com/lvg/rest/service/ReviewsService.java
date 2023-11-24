package com.lvg.rest.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import com.lvg.rest.entity.Product;
//import com.lvg.rest.dto.Product;
//import com.lvg.rest.dto.Product;
import com.lvg.rest.entity.Reviews;
import com.lvg.rest.exception.ReviewNotFoundException;
//import com.lvg.rest.exception.ReviewNotFoundException;
import com.lvg.rest.repository.ReviewsRepository;
@Service
public class ReviewsService {
	@Autowired
	ReviewsRepository reviewsRepository;
	
	@Autowired
	RestTemplate restTemplate;
	
	@Transactional(readOnly=true)
	public List<Reviews> getAllReviews(){
		return reviewsRepository.findAll();
	}
	
	@Transactional(readOnly=true)
	public Reviews getReviewsById(int reviewId) {
		
		Optional<Reviews> optRev=reviewsRepository.findById(reviewId);
		if(optRev.isPresent()) 
			return optRev.get();
		throw new ReviewNotFoundException("Review Does Not exist with Id "+reviewId);	
		
	}
	
	
	@Transactional(readOnly=true)
	public Reviews getReviewsByProductId(int productId) {
		
		Optional<Reviews> optRev=reviewsRepository.findByProductId(productId);
		if(optRev.isPresent()) 
		{
			Product p=restTemplate.getForEntity
			("http://localhost:8092/product/{productId}",Product.class,productId).getBody();
			Reviews r=optRev.get();
			r.setProduct(new com.lvg.rest.dto.Product());
			r.getProduct().setProductId(productId);
			r.getProduct().setProductName(p.getProductName());
			r.getProduct().setProductDescription(p.getProductDescription());
			r.getProduct().setProductPrice(p.getProductPrice());
			r.getProduct().setProductQuantity(p.getProductQuantity());
			
			return r;
		}
		throw new ReviewNotFoundException("Review Does Not exist with ProductId "+productId);	
		
	}
}