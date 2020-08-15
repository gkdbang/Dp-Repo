package com.httpsessiontrackingexample.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.httpsessiontrackingexample.factory.ConnectionFactory;

public class UserDAO {
public Integer login(String un,String pass){
	Integer userId=null;
Connection con=null;
	try{
con=ConnectionFactory.getConnection();
String sql="select userId from User_Details where userName=? and password=?";
PreparedStatement pst=con.prepareStatement(sql);
pst.setString(1,un);
pst.setString(2,pass);
   ResultSet rs=pst.executeQuery();
   if(rs.next()){
	   userId=rs.getInt("userId");
   }
	}catch(SQLException se){
		se.printStackTrace();
	}
	finally{
		if(con!=null){
		try{	
			con.close();
		}catch(SQLException se){
			se.printStackTrace();
		}
		}
	}
	return userId;
}

public int changePassword(String userName, String oldPassword,
		String newPassword) {
int count=0;	
Connection con=null;
try{
con=ConnectionFactory.getConnection();
String sql="update User_Details set password=? where userName=? and password=?";
PreparedStatement pst=con.prepareStatement(sql);
pst.setString(1,newPassword);
pst.setString(2,userName);
pst.setString(3,oldPassword);
  count=pst.executeUpdate();
}catch(SQLException se){
	se.printStackTrace();
}
	return count;
}
}
