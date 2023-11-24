package com.lvg.rest.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lvg.rest.entity.Reviews;

public interface ReviewsRepository extends JpaRepository<Reviews,Integer>
{
	Optional<Reviews> findByProductId(int productId);

}
