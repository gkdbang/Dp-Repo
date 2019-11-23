package com.gaurav.ecom2.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.gaurav.ecom2.model.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {
	
		
	@Query(value="select o from Order o where o.itemName=:itemName")
	public List<Order> findOrderByItemName(@Param("itemName") String itemName) throws Exception;
	
	@Query(value="select o from Order o where o.modelNo=:modelNo")
	public List<Order> findOrderByModelNo(@Param("modelNo") String modelNo) throws Exception;
	
	@Query(value="select o from Order o where o.brand=?1")
	public List<Order> findOrderByBrand(String brand) throws Exception;
	
	@Query(value="select o from Order o where o.id=?1")
	public Order findById(Long id) throws Exception;
	
	@Query(value="select c.customer_id, c.customer_email, c.customer_first_name, c.customer_last_name, "
			+ "c.customer_mobile_no, o.order_id, o.brand_name, o.item_name, o.model_number, o.price "
			+ "from customer_table c join order_table o "
			+ "on c.customer_id=o.customer_id "
			+ "where c.customer_first_name=?1",nativeQuery=true)
	public List<Order> findOrderByFirstName(String firstName);
	
	@Query(value="select c.customer_id, c.customer_email, c.customer_first_name, c.customer_last_name, "
			+ "c.customer_mobile_no, o.order_id, o.brand_name, o.item_name, o.model_number, o.price "
			+ "from customer_table c join order_table o "
			+ "on c.customer_id=o.customer_id "
			+ "where c.customer_email=?1",nativeQuery=true)
	public List<Order> findOrderByEmail(String email);
	
	@Query(value="select c.customer_id, c.customer_email, c.customer_first_name, c.customer_last_name, "
			+ "c.customer_mobile_no, o.order_id, o.brand_name, o.item_name, o.model_number, o.price "
			+ "from customer_table c join order_table o "
			+ "on c.customer_id=o.customer_id "
			+ "where c.customer_mobile_no=?1",nativeQuery=true)
	public List<Order> findByMobileNo(Long mobileNo);		
	
}
