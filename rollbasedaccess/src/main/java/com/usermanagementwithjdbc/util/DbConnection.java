package com.usermanagementwithjdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {
	
	static final String DR_STRING = "com.mysql.jdbc.Driver";
	private static final String JDBC_URL = "jdbc:mysql://localhost:3306/roleBasedAccess";
    private static final String JDBC_USERNAME = "root";
    private static final String JDBC_PASSWORD = "mysql";
	
    Connection connection=null;
    public Connection getConnection(){
    	
    	if(connection==null){
        	try {
    			Class.forName(DR_STRING);
    			connection=DriverManager.getConnection(JDBC_URL, JDBC_USERNAME, JDBC_PASSWORD);
    		} catch (ClassNotFoundException e) {
    			e.printStackTrace();
    		} catch (SQLException e) {
    			e.printStackTrace();
    		}
    	}
    	return connection;   	
    }
    
}
