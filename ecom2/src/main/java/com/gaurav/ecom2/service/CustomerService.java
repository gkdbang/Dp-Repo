package com.gaurav.ecom2.service;

import java.util.List;

import com.gaurav.ecom2.model.Customer;

public interface CustomerService {
	
	public List<Customer> addCustomer(List<Customer> customer)throws Exception;
	public List<Customer> getAllCustomer()throws Exception;
	public Customer getCustomerById(Long id);
	public Customer getCustomerByEmail(String email)throws Exception;
	public List<Customer> getCustomerByMobile(Long mobileNo)throws Exception;
	public List<Customer> getCustomerByItemName(String itemName)throws Exception;
	public List<Customer> getCustomerByModelNo(String modelNo)throws Exception;
	public List<Customer> getCustomerByBrand(String brand)throws Exception;
	public List<Customer> UpdateCustomer(Customer customer,Long id)throws Exception;
	public List<Customer> deleteCustomerById(Long id)throws Exception;
	public List<Customer> deleteAllCustomer()throws Exception;
	
}
