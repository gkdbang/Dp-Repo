package com.quinnox.insertmultipleimagedb.dao;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class FileUploadDao {
	
 	private static String URL = "jdbc:mysql://localhost:3306/fileappdb1?useSSL=false";
 	private static String USER = "root";
 	private static String PASSWORD = "mysql";
	
	public Boolean saveFileToDB(InputStream inputStream) {
		boolean status=false;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection=DriverManager.getConnection(URL, USER, PASSWORD);
			String sqlQuery = "INSERT INTO multiple_file (file) values (?)";
			PreparedStatement preparedStatement=connection.prepareStatement(sqlQuery);
			if(inputStream!=null){
				preparedStatement.setBlob(1, inputStream);
			}
			
			if(preparedStatement.executeUpdate()>0){
				status=true;
			}
		} 
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return status;	
	}

}
