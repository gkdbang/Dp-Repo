package com.usermanagementwithjdbc.util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PKIdGeneration {
	
	public static int getPK(){
		Connection connection=new DbConnection().getConnection();
		try(ResultSet rs=connection.createStatement().executeQuery("SELECT MAX(id) from user_table")){
			if(rs.next()){
				int id=rs.getInt(1);
				System.out.println("PK-id : "+id);
				return ++id;
			}else{
				return 1;
			}
		}
		catch(SQLException sqlException){
			sqlException.printStackTrace();
			return 0;
		}
	}
}
