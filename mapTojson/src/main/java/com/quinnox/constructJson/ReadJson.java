package com.quinnox.constructJson;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.quinnox.model.Movie;

public class ReadJson {

	public static void main(String[] args) {
		
		JSONParser jsonParser=new JSONParser();
		
		String filePath="C:\\Users\\gauravd\\Desktop\\Movie.txt";
		try(BufferedReader bufferedReader=new BufferedReader(new FileReader(filePath))){
			Object object=jsonParser.parse(bufferedReader);
			JSONObject jsonObject=(JSONObject)object;
			
			//System.out.println(jsonObject);
			@SuppressWarnings("unchecked")
			Set<String> keys=jsonObject.keySet();
			System.out.println(keys);
			Collection<?> values=jsonObject.values();
			//System.out.println(values);
			
			ObjectMapper objectMapper=new ObjectMapper();
			Movie[][] movie=objectMapper.readValue(values.toString(), Movie[][].class);
			
			// Converting 2D array to string and printing
			System.out.println(Arrays.deepToString(movie));
			
			twoDArrayToList(movie);
		}
		catch(IOException io){
			io.printStackTrace();
			System.out.println(io.getMessage());
			System.out.println(io.getStackTrace());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private static void twoDArrayToList(Movie[][] movie) {
		// Converting 2D array to List
		List<Movie> list=new ArrayList<>();
		for(Movie[] array : movie){
			list.addAll(Arrays.asList(array));
		}
		
		System.out.println(list);
		
	}

}
