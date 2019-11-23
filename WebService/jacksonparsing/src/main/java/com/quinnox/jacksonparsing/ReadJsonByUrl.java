package com.quinnox.jacksonparsing;

import java.io.IOException;
import java.net.URL;

import org.codehaus.jackson.map.ObjectMapper;

public class ReadJsonByUrl {

	public static void main(String[] args) {
		
		ObjectMapper mapper=new ObjectMapper();
		try {
			URL url=new URL("http://jsonplaceholder.typicode.com/posts/7");
			Post urlPost=mapper.readValue(url, Post.class);
			System.out.println(urlPost);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
