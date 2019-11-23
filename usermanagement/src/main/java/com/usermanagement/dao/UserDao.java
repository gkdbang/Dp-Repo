package com.usermanagement.dao;

import java.util.List;

import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.usermanagement.model.User;
import com.usermanagement.util.HibernateUtil;

public class UserDao {
	
	/**
	 * Save User
	 * @param user
	 */
	public void saveUser(User user) {
		Transaction transaction = null;
		Session session=null;
		try {
			 session = getSession();
			// start a transaction
			transaction = session.beginTransaction();
			// save the student object
			session.save(user);
			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

	/**
	 * Update User
	 * @param user
	 */
	public void updateUser(User user) {
		Transaction transaction = null;
		Session session=null;
		try {
			session=getSession();
			// start a transaction
			transaction = session.beginTransaction();
			// save the student object
			session.update(user);
			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

	/**
	 * Delete User
	 * @param id
	 */
	public void deleteUser(int id) {

		Transaction transaction = null;
		Session session=null;
		try  {
			session=getSession();
			// start a transaction
			transaction = session.beginTransaction();

			// Delete a user object
			User user = session.get(User.class, id);
			if (user != null) {
				session.delete(user);
				System.out.println("user is deleted");
			}
			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

	/**
	 * Get User By ID
	 * @param id
	 * @return
	 */
	public User getUser(int id) {

		Transaction transaction = null;
		User user = null;
		Session session=null;
		try  {
			session=getSession();
			// start a transaction
			transaction = session.beginTransaction();
			// get an user object
			user = session.get(User.class, id);
			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return user;
	}
	
	/**
	 * Get all Users
	 * @return
	 */
	
	@SuppressWarnings("unchecked")
	public List<User> getAllUser() {

		Transaction transaction = null;
		List<User> listOfUser = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			
			// get an user object
			@SuppressWarnings("rawtypes")
			Query query=session.createNativeQuery("select * from user_table");
			listOfUser=query.getResultList();

			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		} 
		return listOfUser;
	}
	
	public Session getSession(){
		return HibernateUtil.getSessionFactory().openSession();
	}
}