package com.quinnox.fetchImagedb.dao;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Base64;

import com.quinnox.fetchImagedb.model.Car;

public class CarDao {
	
	 	String databaseURL = "jdbc:mysql://localhost:3306/gaurav?useSSL=false";
	    String user = "root";
	    String password = "mysql";
	     
	    public Car getCar(String carName) throws SQLException, IOException, ClassNotFoundException {
	        Car car = null;
	         
	        String sql = "SELECT * FROM image_tb WHERE image_title = ?";
	        Class.forName("com.mysql.jdbc.Driver");
	        
            InputStream inputStream=null;
            ByteArrayOutputStream outputStream=null;
	        
	        try (Connection connection = DriverManager.getConnection(databaseURL, user, password)) {
	            PreparedStatement statement = connection.prepareStatement(sql);
	            statement.setString(1, carName);
	            ResultSet result = statement.executeQuery();
	            
	            if (result.next()) {
	                car = new Car();
	                String carTitle = result.getString("image_title");
	                Blob blob = result.getBlob("image_data");
	                 
	                inputStream = blob.getBinaryStream();
	                outputStream = new ByteArrayOutputStream();
	                
	                // Either follow this or we have alternate way 
	                /*byte[] buffer = new byte[4096];
	                int bytesRead = -1;
	                 
	                while ((bytesRead = inputStream.read(buffer)) != -1) {
	                    outputStream.write(buffer, 0, bytesRead);                  
	                }*/
	                
	                //Alternate Way  
	                // Now let's write this content from inputStream to outputStream
            		int i=0;
            		while((i=inputStream.read())>-1){
            			outputStream.write(i);
            		}
            		              
	                 
	                byte[] imageBytes = outputStream.toByteArray();
	                String base64Image = Base64.getEncoder().encodeToString(imageBytes);
	      	      	
	      	        car.setCarTitle(carTitle);
	      	        car.setBase64Image(base64Image);
	            }          
	             
	        } catch (SQLException | IOException ex) {
	            ex.printStackTrace();
	            throw ex;
	        }
	        finally {
	        	inputStream.close();
                outputStream.close();
			}
	        return car;
	    }
	
}
