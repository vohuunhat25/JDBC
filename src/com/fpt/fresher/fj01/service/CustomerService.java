package com.fpt.fresher.fj01.service;

import java.sql.SQLException;
import java.util.List;

import com.fpt.fresher.fj01.dal.CustomerDAL;
import com.fpt.fresher.fj01.model.Customer;

public class CustomerService {

	CustomerDAL custommerDAL = new CustomerDAL();

	/**
	 * Get list with all customers in the order table
	 * 
	 * @return List customer get by ID
	 * @throws Exception
	 * @throws SQLException
	 */
	public List<Customer> getAllCustomer() throws Exception {

		List<Customer> listCustomer = null;

		listCustomer = custommerDAL.getAllCustomer();

		return listCustomer;
	}

	/**
	 * Find Customer by ID
	 * 
	 * @param customerID
	 * @return
	 * @throws Exception
	 */
	public Customer findCustomerByID(int customerID) throws Exception {

		if (customerID <= 0) {
			throw new Exception("You can't use ID less 0");
		}
		return custommerDAL.findCustomerByID(customerID);
	}

	/**
	 * Add a customer into the database
	 * 
	 * @param customer
	 * @return Result add a customer
	 * @throws SQLException
	 * @throws Exception
	 */
	public boolean addCustomer(Customer customer) throws Exception {

		Customer customerFromDB = findCustomerByID(customer.getCustomerId());

		if (customer.getCustomerId() <= 0) {
			throw new Exception("You can't use ID less 0");
		}

		if (customer.getCustomerName() == null) {
			throw new Exception("you can't leave the name blank ");
		}

		if (customerFromDB != null) {
			throw new Exception(
					"Customer with ID " + customer.getCustomerId() + " is existed you can't add a new Customer");
		}
		return custommerDAL.addCustomer(customer);
	}

	/**
	 * Delete a customer from the database
	 * 
	 * @param customerId
	 * @return Result delete customer in table Customer
	 * @throws Exception
	 */
	public boolean deleteCustomer(int customerId) throws Exception {

		if (customerId <= 0) {
			throw new Exception("You can't delete ID less 0");
		}

		if (findCustomerByID(customerId) == null) {
			throw new Exception("Customer with ID " + customerId + " is not exist you can't delete Customer");
		}
		return custommerDAL.deleteCustomer(customerId);
	}

	/**
	 * Update a customer in the database
	 * 
	 * @param customer
	 * @return Result Update customer
	 * @throws Exception
	 */
	public boolean updateCustomer(Customer customer) throws Exception {

		Customer customerFromDB = findCustomerByID(customer.getCustomerId());

		if (customer.getCustomerId() <= 0) {
			throw new Exception("You can't use ID less 0");
		}

		if (customer.getCustomerName() == null) {
			throw new Exception("you can't leave the name blank ");
		}

		if (customerFromDB == null) {
			throw new Exception(
					"Customer with ID " + customer.getCustomerId() + " is not exist you can't update a Customer");
		}
		return custommerDAL.updateCustomer(customer);
	}

}
