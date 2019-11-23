package com.gaurav.ecom.customer.service;

import java.util.List;

import com.gaurav.ecom.customer.model.Customer;

public interface CustomerService {
	public List<Customer> addCustomer(List<Customer> customer);
	public List<Customer> getAllCustomer();
	public Customer getCustomerById(Long id);
	public Customer getCustomerByEmail(String email);
	public List<Customer> getCustomerByMobile(Long mobileNo);
	public List<Customer> getCustomerByCity(String city);
	public List<Customer> getCustomerByState(String state);
	public List<Customer> getCustomerByZipcode(Long zipcode);
	public List<Customer> getCustomerByHouseNo(String houseNo);
	public List<Customer> UpdateCustomer(Customer customer,Long id);
	public List<Customer> deleteCustomerById(Long id);
	public List<Customer> deleteAllCustomer();
}
