package com.httpsessiontrackingexample.factory;
import java.sql.*;
public class ConnectionFactory {
static{
try {
Class.forName("oracle.jdbc.driver.OracleDriver");
} catch (ClassNotFoundException e) {
	e.printStackTrace();
}
}
public static Connection getConnection()throws 
SQLException{
String url="jdbc:oracle:thin:@localhost:1521:XE";
String userName="system";
String password="manager";
Connection con=
DriverManager.getConnection(url,userName,password);
return con;
}
}
