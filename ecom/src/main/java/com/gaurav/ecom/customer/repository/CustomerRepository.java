package com.gaurav.ecom.customer.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.gaurav.ecom.customer.model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
	
	@Query(value="select c from Customer c where c.email=:email")
	public Customer findByEmail(@Param("email") String email);
	
	@Query(value="select c from Customer c where c.mobileNo=?1")
	public List<Customer> findByMobile(Long mobileNo);
	
	@Query(value="select c.customer_id, c.customer_email, c.customer_first_name, c.customer_last_name, "
			+ "c.customer_mobile_no, a.address_id, a.customer_address_city, a.customer_address_house_no, "
			+ "a.customer_address_state, a.customer_address_zipcode "
			+ "from customer_table c join address_table a "
			+ "on c.customer_id=a.customer_id "
			+ "where customer_address_city=?1", nativeQuery=true)
	public List<Customer> findByCity(String city);
	
	@Query(value="select c.customer_id, c.customer_email, c.customer_first_name, c.customer_last_name, "
			+ "c.customer_mobile_no, a.address_id, a.customer_address_city, a.customer_address_house_no, "
			+ "a.customer_address_state, a.customer_address_zipcode "
			+ "from customer_table c join address_table a "
			+ "on c.customer_id=a.customer_id "
			+ "where customer_address_state=?1", nativeQuery=true)
	public List<Customer> findByState(@Param("state") String state);
	
	@Query(value="select c.customer_id, c.customer_email, c.customer_first_name, c.customer_last_name, "
			+ "c.customer_mobile_no, a.address_id, a.customer_address_city, a.customer_address_house_no, "
			+ "a.customer_address_state, a.customer_address_zipcode "
			+ "from customer_table c join address_table a "
			+ "on c.customer_id=a.customer_id "
			+ "where customer_address_zipcode=?1", nativeQuery=true)
	public List<Customer> findByZipcode(@Param("zipcode") Long zipcode);
	
	@Query(value="select c.customer_id, c.customer_email, c.customer_first_name, c.customer_last_name, "
			+ "c.customer_mobile_no, a.address_id, a.customer_address_city, a.customer_address_house_no, "
			+ "a.customer_address_state, a.customer_address_zipcode "
			+ "from customer_table c join address_table a "
			+ "on c.customer_id=a.customer_id "
			+ "where customer_address_house_no=?1", nativeQuery=true)
	public List<Customer> findByHouseNo(@Param("houseNo") String houseNo);
	
}
