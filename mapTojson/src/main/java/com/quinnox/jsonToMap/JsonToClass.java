package com.quinnox.jsonToMap;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.quinnox.model.Movie;
import com.quinnox.model.Movies;

public class JsonToClass {

	public static void main(String[] args) {
		
		ObjectMapper objectMapper=new ObjectMapper();
		String filePath="C:\\Users\\gauravd\\Desktop\\Movie.txt";
		Movies movies=null;
		try {
			movies=objectMapper.readValue(new File(filePath), Movies.class);
			
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Map<String, List<Movie>> map=movies.getMovies();
		
		List<Movie> movie = null;
		Iterator<String> itr=map.keySet().iterator();
		while(itr.hasNext()){
				String key=itr.next();
				movie=map.get(key);
		}
		System.out.println(movie);
	}

}
