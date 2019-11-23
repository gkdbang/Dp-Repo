package com.gaurav.ecom2.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.gaurav.ecom2.model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
	
	@Query(value="select c from Customer c where c.email=:email")
	public Customer findByEmail(@Param("email") String email) throws Exception;
	
	@Query(value="select c from Customer c where c.mobileNo=?1")
	public List<Customer> findByMobile(Long mobileNo) throws Exception;
	
	@Query(value="select c.customer_id, c.customer_email, c.customer_first_name, c.customer_last_name, "
			+ "c.customer_mobile_no, o.order_id, o.brand_name, o.item_name, o.model_number, o.price "
			+ "from customer_table c join order_table o "
			+ "on c.customer_id=o.customer_id "
			+ "where o.item_name=?1", nativeQuery=true)
	public List<Customer> findByItemName(String itemName) throws Exception;
	
	@Query(value="select c.customer_id, c.customer_email, c.customer_first_name, c.customer_last_name, "
			+ "c.customer_mobile_no, o.order_id, o.brand_name, o.item_name, o.model_number, o.price "
			+ "from customer_table c join order_table o "
			+ "on c.customer_id=o.customer_id "
			+ "where o.model_number=?1",nativeQuery=true)
	public List<Customer> findByModelNo(String modelNo) throws Exception;
	
	@Query(value="select c.customer_id, c.customer_email, c.customer_first_name, c.customer_last_name, "
			+ "c.customer_mobile_no, o.order_id, o.brand_name, o.item_name, o.model_number, o.price "
			+ "from customer_table c join order_table o "
			+ "on c.customer_id=o.customer_id "
			+ "where o.brand_name=?1",nativeQuery=true)
	public List<Customer> findByBrand(String brand) throws Exception;
	
		
}
