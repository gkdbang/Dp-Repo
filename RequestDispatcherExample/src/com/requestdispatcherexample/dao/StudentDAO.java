package com.requestdispatcherexample.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.requestdispatcherexample.domain.Student;
import com.requestdispatcherexample.factory.ConnectionFactory;
public class StudentDAO {
public Student searchStudent(int sid) {
	Connection con=null;
	Student std=null;
	try{
	 con=ConnectionFactory.getConnection();
	String SEARCH_STUDENT="select name,email,mobile,course from Student_Details where studentId=?";
	PreparedStatement pst=con.prepareStatement(SEARCH_STUDENT);
	pst.setInt(1,sid);
	ResultSet rs=pst.executeQuery();
	if(rs.next()){
		std=new Student();
		std.setStudentId(sid);
		std.setName(rs.getString("name"));
		std.setEmail(rs.getString("email"));
		std.setMobile(rs.getString("mobile"));
		std.setCourse(rs.getString("course"));
	}
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
		return std;
	}

}
