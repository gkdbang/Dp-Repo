package com.gaurav.ecom.customer.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gaurav.ecom.customer.model.Customer;
import com.gaurav.ecom.customer.repository.CustomerRepository;
import com.gaurav.ecom.customer.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {
	
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Override
	public List<Customer> addCustomer(List<Customer> customer) {
		List<Customer> customers=new ArrayList<Customer>();
		customers=customerRepository.save(customer);
		return customers;
	}

	@Override
	public List<Customer> getAllCustomer() {
		List<Customer> customers=new ArrayList<Customer>();
		customers=customerRepository.findAll();
		return customers;
	}

	@Override
	public Customer getCustomerById(Long id) {
		return customerRepository.findOne(id);
	}

	@Override
	public Customer getCustomerByEmail(String email) {
		return customerRepository.findByEmail(email);
	}

	@Override
	public List<Customer> getCustomerByMobile(Long mobileNo) {
		return customerRepository.findByMobile(mobileNo);
	}
	
	@Override
	public List<Customer> getCustomerByCity(String city) {
		return customerRepository.findByCity(city);
	}
	
	@Override
	public List<Customer> getCustomerByState(String state) {
		return customerRepository.findByState(state);
	}
	
	@Override
	public List<Customer> getCustomerByZipcode(Long zipcode) {
		return customerRepository.findByZipcode(zipcode);
	}
	
	@Override
	public List<Customer> getCustomerByHouseNo(String houseNo) {
		return customerRepository.findByHouseNo(houseNo);
	}
	
	@Override
	public List<Customer> UpdateCustomer(Customer customer, Long id) {
		customerRepository.save(customer);
		return getAllCustomer();
	}

	@Override
	public List<Customer> deleteCustomerById(Long id) {
		customerRepository.delete(id);
		return getAllCustomer();
	}

	@Override
	public List<Customer> deleteAllCustomer() {
		customerRepository.deleteAll();
		return getAllCustomer();
	}

}
