package com.userregexample.dao;
import java.sql.*;
import com.userregexample.domain.User;
import com.userregexample.factory.ConnectionFactory;
public class UserDAO {
public int registerUser(User user) {
int count=0;
Connection con=null;
	try{
 con=ConnectionFactory.getConnection();
String SQL_REGISTER=
"insert into User_Details values(?,?,?)";
PreparedStatement pst=
con.prepareStatement(SQL_REGISTER);
pst.setString(1,user.getName());
pst.setString(2,user.getEmail());
pst.setString(3,user.getMobile());
  count=pst.executeUpdate();
	}catch(SQLException se){
	se.printStackTrace();	
	}finally{
		if(con!=null){
		try{	
			con.close();
		}catch(SQLException se){
			se.printStackTrace();
		}
		}
	}
		return count;
	}
}
