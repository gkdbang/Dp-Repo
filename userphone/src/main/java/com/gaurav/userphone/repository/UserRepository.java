package com.gaurav.userphone.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.gaurav.userphone.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
	
	@Query(value="select u from User u where name=:name")
	public List<User> findUserByName(@Param("name") String name) throws Exception;
	
	
	@Query(value="select u.user_id, u.user_name, p.phone_id, p.phone_number, p.phone_number_type from "
			+ "user_table u join phone_numbers_table p "
			+ "on u.user_id=p.unid "
			+ "where phone_number=?1", nativeQuery=true)
	public List<User> findUserByPhoneNumber(String phoneNumber) throws Exception;
	
	
	@Query(value="select u.user_id, u.user_name, p.phone_id, p.phone_number, p.phone_number_type from "
			+ "user_table u join phone_numbers_table p "
			+ "on u.user_id=p.unid "
			+ "where phone_number_type=?1", nativeQuery=true)
	public List<User> findUserByPhoneType(String phoneType) throws Exception;
	
}
