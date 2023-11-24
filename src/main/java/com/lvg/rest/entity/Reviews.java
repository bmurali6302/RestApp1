package com.lvg.rest.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;
import com.lvg.rest.dto.Product;
@Entity
public class Reviews {
	@Id
	@Column(name="rev_id")
	private int reviewId;
	@Column(name="prod_id")
	private int productId;
	@Column(name="rating")
	private int productRating;
	@Column(name="rev_des")
	private String reviewDescription;
	
	@Transient //its that skip to mapping field
	Product product;
	
	public Reviews() {
		
	}
	public Reviews(int reviewId, int productId, int productRating, String reviewDescription) {
		super();
		this.reviewId = reviewId;
		this.productId = productId;
		this.productRating = productRating;
		this.reviewDescription = reviewDescription;
	}
	public int getReviewId() {
		return reviewId;
	}
	public void setReviewId(int reviewId) {
		this.reviewId = reviewId;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public int getProductRating() {
		return productRating;
	}
	public void setProductRating(int productRating) {
		this.productRating = productRating;
	}
	public String getReviewDescription() {
		return reviewDescription;
	}
	public void setReviewDescription(String reviewDescription) {
		this.reviewDescription = reviewDescription;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	

}
