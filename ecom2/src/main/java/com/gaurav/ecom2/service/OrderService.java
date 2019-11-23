package com.gaurav.ecom2.service;

import java.util.List;

import com.gaurav.ecom2.model.Order;

public interface OrderService {

	public List<Order> getAllOrders()throws Exception;
	public Order getOrderById(Long id)throws Exception;
	public List<Order> getOrderByItemName(String itemName)throws Exception;
	public List<Order> getOrderByModelNo(String modelNo)throws Exception;
	public List<Order> getOrderByBrand(String brand)throws Exception;
	public List<Order> UpdateOrder(Order order, Long id)throws Exception;
	public List<Order> deleteCustomerById(Long id)throws Exception;
	public List<Order> deleteAllOrders()throws Exception;
	public List<Order> getOrderByFirstName(String firstName);
	public List<Order> getOrderByEmail(String email);
	public List<Order> getOrderByMobileNo(Long mobileNo);

}
