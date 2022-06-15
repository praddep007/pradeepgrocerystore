package in.grocery.dao;

import java.util.List;

import in.grocery.pojo.Customer;


public interface CustomerDao {
	boolean addCustomer(Customer custobj);
	boolean updateCustomer(Customer custobj);
	boolean deleteCustomer(int customerId);
	public List showCustomerList();
	public Customer searchCustomerById(int cutomerId);
	public List searchCustomerByEmail(String customerEmail);
	

}
