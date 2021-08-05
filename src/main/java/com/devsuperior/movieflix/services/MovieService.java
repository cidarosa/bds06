package com.devsuperior.movieflix.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.movieflix.dto.MovieDTO;
import com.devsuperior.movieflix.dto.MovieMinDTO;
import com.devsuperior.movieflix.entities.Movie;
import com.devsuperior.movieflix.entities.User;
import com.devsuperior.movieflix.repositories.MovieRepository;
import com.devsuperior.movieflix.services.exceptions.ResourceNotFoundException;

@Service
public class MovieService {

	@Autowired
	private MovieRepository repository;

	@Autowired
	private AuthService authService;

	@Transactional(readOnly = true)
	public MovieDTO findById(Long id) {
		
		User user = authService.authenticated();

	//	authService.validateSelfOrAdmin(user.getId()); // validando - se não lança exception

		Optional<Movie> obj = repository.findById(id);
		Movie entity = obj.orElseThrow(() -> new ResourceNotFoundException("Entity not found"));
		return new MovieDTO(entity);
	}
	
	@Transactional(readOnly = true)
	public Page<MovieMinDTO> find(Pageable pageable){
		
		Page<MovieMinDTO> page = repository.findAllPaged( pageable);
		
		//Page<Movie> page = repository.find(pageable);
		return page;
		
	}

}
