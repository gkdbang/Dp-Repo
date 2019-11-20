package com.quinnox.model;

import java.util.List;
import java.util.Map;

public class Movies {
	
	private Map<String,List<Movie>> movies;

	public Map<String, List<Movie>> getMovies() {
		return movies;
	}

	public void setMovies(Map<String, List<Movie>> movies) {
		this.movies = movies;
	}

	
	
}
