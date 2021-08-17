package com.devsuperior.movieflix.services;

import org.springframework.beans.factory.annotation.Autowired;

import com.devsuperior.movieflix.repositories.ReviewRepository;

public class ReviewService {
	
	@Autowired
	private ReviewRepository repository;
	
	@Autowired
	private AuthService authService;
	
	

}
