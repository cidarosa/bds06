package com.devsuperior.movieflix.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.devsuperior.movieflix.dto.MovieMinDTO;
import com.devsuperior.movieflix.entities.Movie;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {
	
	@Query("SELECT new com.devsuperior.movieflix.dto.MovieMinDTO(obj.title, obj.subTitle, obj.year, obj.imgUrl, obj.synopsis) "
			+ "FROM Movie obj ")
	Page<MovieMinDTO> findAllPaged(Pageable pageable);
	
	/*SELECT * FROM TB_MOVIE 
	INNER JOIN tb_genre ON tb_movie.genre_id = tb_genre.id
	where tb_movie.id = 1*/ 
	
	
	
	/*SELECT tb_movie.id, tb_movie.title, tb_movie.sub_title, tb_movie.year, tb_movie.img_url, tb_movie.synopsis,
    tb_genre.id, tb_genre.name
FROM TB_MOVIE 
INNER JOIN tb_genre ON tb_movie.genre_id = tb_genre.id
where tb_movie.id = 1*/
	
	

}
