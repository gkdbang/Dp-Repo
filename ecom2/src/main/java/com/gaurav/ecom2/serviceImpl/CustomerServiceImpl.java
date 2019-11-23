package com.gaurav.ecom2.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gaurav.ecom2.exceptions.CustomerNotFoundException;
import com.gaurav.ecom2.model.Customer;
import com.gaurav.ecom2.repository.CustomerRepository;
import com.gaurav.ecom2.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {
	
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Override
	public List<Customer> addCustomer(List<Customer> customer) throws Exception {
		List<Customer> customers=new ArrayList<Customer>();
		customers=customerRepository.save(customer);
		return customers;
	}

	@Override
	public List<Customer> getAllCustomer() throws Exception {
		List<Customer> customers=new ArrayList<Customer>();
		customers=customerRepository.findAll();
		return customers;
	}

	@Override
	public Customer getCustomerById(Long id) {
		Customer customer=new Customer();
		customer=customerRepository.findOne(id);
		if(customer==null){
			throw new CustomerNotFoundException("No Employee Found with id :"+id);
		}
		return customer;		 
	}
	

	
	@Override
	public Customer getCustomerByEmail(String email) throws Exception {
		Customer customer=new Customer();
		customer=customerRepository.findByEmail(email);
		if(customer==null){
			throw new CustomerNotFoundException("No Employee Found with id :"+email);
		}
		return customer;
	}

	@Override
	public List<Customer> getCustomerByMobile(Long mobileNo) throws Exception {
		return customerRepository.findByMobile(mobileNo);
	}
	
	@Override
	public List<Customer> getCustomerByItemName(String itemName) throws Exception {
		return customerRepository.findByItemName(itemName);
	}
	
	@Override
	public List<Customer> getCustomerByModelNo(String modelNo) throws Exception {
		return customerRepository.findByModelNo(modelNo);
	}	
	
	@Override
	public List<Customer> getCustomerByBrand(String brand) throws Exception {
		return customerRepository.findByBrand(brand);
	}
	
	@Override
	public List<Customer> UpdateCustomer(Customer customer, Long id) throws Exception {
		customerRepository.save(customer);
		return getAllCustomer();
	}

	@Override
	public List<Customer> deleteCustomerById(Long id) throws Exception {
		customerRepository.delete(id);
		return getAllCustomer();
	}

	@Override
	public List<Customer> deleteAllCustomer() throws Exception {
		customerRepository.deleteAll();
		return getAllCustomer();
	}

}
