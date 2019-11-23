package com.gaurav.ecom2.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gaurav.ecom2.model.Order;
import com.gaurav.ecom2.repository.OrderRepository;
import com.gaurav.ecom2.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {
	
	
	@Autowired
	private OrderRepository orderRepository;

	@Override
	public List<Order> getAllOrders() throws Exception {
		List<Order> orders= new ArrayList<Order>();
		orders=orderRepository.findAll();
		return orders;
	}

	@Override
	public Order getOrderById(Long id) throws Exception {
		return orderRepository.findById(id);
	}

	@Override
	public List<Order> getOrderByItemName(String itemName) throws Exception {
		return orderRepository.findOrderByItemName(itemName);
	}

	@Override
	public List<Order> getOrderByModelNo(String modelNo) throws Exception {
		return orderRepository.findOrderByModelNo(modelNo);
	}

	@Override
	public List<Order> getOrderByBrand(String brand) throws Exception {
		return orderRepository.findOrderByBrand(brand);
	}

	@Override
	public List<Order> UpdateOrder(Order order, Long id) throws Exception {
		orderRepository.save(order);
		return getAllOrders();
	}

	@Override
	public List<Order> deleteCustomerById(Long id) throws Exception {
		orderRepository.delete(id);
		return getAllOrders();
	}

	@Override
	public List<Order> deleteAllOrders() throws Exception {
		orderRepository.deleteAll();
		return getAllOrders();
	}

	@Override
	public List<Order> getOrderByFirstName(String firstName) {
		return orderRepository.findOrderByFirstName(firstName);
	}

	@Override
	public List<Order> getOrderByEmail(String email) {
		return orderRepository.findOrderByEmail(email);
	}

	@Override
	public List<Order> getOrderByMobileNo(Long mobileNo) {
		return orderRepository.findByMobileNo(mobileNo);
	}
		
}
