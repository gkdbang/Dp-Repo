package com.usermanagementwithjdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.usermanagementwithjdbc.model.User;
import com.usermanagementwithjdbc.util.DbConnection;
import com.usermanagementwithjdbc.util.PKIdGeneration;

public class UserDao {
	
		
		private static final String INSERT_USERS_SQL="INSERT INTO user_table"+"(id,userName,password,email,country,userRole)VALUES"
		+"(?,?,?,?,?,?);";

	    private static final String SELECT_USER_BY_ID = "select id,userName,email,country,userRole,password from user_table where id=?";
	    private static final String SELECT_ALL_USERS = "select * from user_table";
	    private static final String DELETE_USERS_SQL = "delete from user_table where id = ?;";
	    private static final String UPDATE_USERS_SQL = "update user_table set userName = ?,email= ?, country =? where id = ?;";
	
	    public UserDao() {
			// TODO Auto-generated constructor stub
		}
	    
		private Connection getConnection(){
			DbConnection dbConnection=new DbConnection();
			return dbConnection.getConnection();
		}
		
		public void saveUser(User user){
			System.out.println(INSERT_USERS_SQL);
			int userId=PKIdGeneration.getPK();
			PreparedStatement preparedStatement=null;
			try {
				preparedStatement=getConnection().prepareStatement(INSERT_USERS_SQL);
				
				preparedStatement.setInt(1, userId);
				preparedStatement.setString(2, user.getUserName());
				preparedStatement.setString(3, user.getPassword());
				preparedStatement.setString(4, user.getEmail());
				preparedStatement.setString(5, user.getCountry());
				preparedStatement.setString(6, user.getUserRole());
				preparedStatement.executeUpdate();
			} catch (SQLException e) {
				printSQLException(e);
			} finally {
				try {
					preparedStatement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
		
		public List<User> getAllUser(){
			System.out.println(SELECT_ALL_USERS);
			List<User> listOfUser=new ArrayList<>();
			try(PreparedStatement preparedStatement=getConnection().prepareStatement(SELECT_ALL_USERS)){
				ResultSet rs=preparedStatement.executeQuery();
				while (rs.next()) {
					User user=new User();
					user.setId(rs.getInt(1));
					user.setUserName(rs.getString(2));
					user.setEmail(rs.getString(3));
					user.setCountry(rs.getString(4));
					listOfUser.add(user);
				}
			}
			catch(SQLException sqlException){
				printSQLException(sqlException);
			}
			
			return listOfUser;
		}
		
		
		public User getUser(int id){
			System.out.println(SELECT_USER_BY_ID);
			User user=new User();
			try(PreparedStatement preparedStatement=getConnection().prepareStatement(SELECT_USER_BY_ID)){
				preparedStatement.setInt(1, id);
				ResultSet rs=preparedStatement.executeQuery();
				if(rs.next()){
					user.setId(rs.getInt(1));
					user.setUserName(rs.getString(2));
					user.setEmail(rs.getString(3));
					user.setCountry(rs.getString(4));
					user.setUserRole(rs.getString(5));
					user.setPassword(rs.getString(6));
				}
			}
			catch(SQLException sqlException){
				printSQLException(sqlException);
			}
			return user;
		}
		
		
		public void updateUser(User user){
			System.out.println(UPDATE_USERS_SQL);
			try(PreparedStatement preparedStatement=getConnection().prepareStatement(UPDATE_USERS_SQL)){
				preparedStatement.setString(1, user.getUserName());
				preparedStatement.setString(2, user.getEmail());
				preparedStatement.setString(3, user.getCountry());
				preparedStatement.setInt(4, user.getId());
				preparedStatement.executeUpdate();
			}
			catch(SQLException sqlException){
				printSQLException(sqlException);
			}
		}
		
		public void deleteUser(int id){
			System.out.println(DELETE_USERS_SQL);
			try(PreparedStatement preparedStatement=getConnection().prepareStatement(DELETE_USERS_SQL)){
				preparedStatement.setInt(1, id);
				preparedStatement.executeUpdate();
			}
			catch(SQLException sqlException){
				printSQLException(sqlException);
			}
		}
		
		private void printSQLException(SQLException sqlException) {
			
			for(Throwable e:sqlException){
				if(e instanceof SQLException){
					e.printStackTrace(System.err);
					System.err.println("SQLState : "+((SQLException) e).getSQLState());
					System.err.println("Erro Code : "+((SQLException) e).getErrorCode());
					System.err.println("Message : "+e.getMessage());
					
					Throwable t=e.getCause();
					while (t!=null) {
						System.out.println(t);
						t=t.getCause();
					}
				}
			}
		}	
	
}
