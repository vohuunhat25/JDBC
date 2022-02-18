package com.fpt.fresher.fj01.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.fpt.fresher.fj01.model.Customer;
import com.fpt.fresher.fj01.service.CustomerService;

public class CustomerServiceTest {
	CustomerService customerService = new CustomerService();

	@Test
	public void testFindCustomerByID_customerIDNotNull() throws Exception {
		Customer TestCustomerIDNotNull = customerService.findCustomerByID(1);
		assertNotNull(TestCustomerIDNotNull);
	}

	@Test
	public void testFindCustomerByID_customerIDNegative() {
		Assertions.assertThrows(Exception.class, () -> {
			Customer TestCustomerIDNegative = customerService.findCustomerByID(-2);
		});
	}

	@Test
	public void testGetAllCustomer_returnNotNull() throws Exception {
		List<Customer> testGetAllCustomer = customerService.getAllCustomer();
		assertNotNull(testGetAllCustomer);
	}

	@Test
	public void testAddCustomer() throws Exception {
		Customer testAddCustomer = new Customer(11, "nguyen van a");
		boolean resultTestAddCustomer = customerService.addCustomer(testAddCustomer);
		assertTrue(resultTestAddCustomer);
	}

	@Test
	public void testAddCustomer_customerIdNegative() {
		Customer testAddCustomerID = new Customer(-8, "kkjkl");
		int customerIdNegative = -8;
		assertEquals(customerIdNegative, testAddCustomerID.getCustomerId());
		Assertions.assertThrows(Exception.class, () -> {
			customerService.addCustomer(testAddCustomerID);
		});
	}

	@Test
	public void testAddCustomer_customerNameNull() {
		Customer testAddCustomerName = new Customer(1, null);
		Assertions.assertThrows(Exception.class, () -> {
			customerService.addCustomer(testAddCustomerName);
		});
	}

	@Test
	public void testAddCustomer_customerNotNull() {
		Customer testAddCustomerNull = new Customer(1, "adsa");
		Assertions.assertThrows(Exception.class, () -> {
			customerService.addCustomer(testAddCustomerNull);
		});
	}

	@Test
	public void testDeleteCustomer() throws Exception {
		boolean resultTestAddCustomer = customerService.deleteCustomer(12);
		assertTrue(resultTestAddCustomer);
	}

	@Test
	public void testDeleteCustomer_customerIDNegative() {
		Assertions.assertThrows(Exception.class, () -> {
			customerService.deleteCustomer(-1);
		});
	}

	@Test
	public void testDeleteCustomer_customerIdNull() {
		Assertions.assertThrows(Exception.class, () -> {
			customerService.deleteCustomer(888988);
		});
	}

	@Test
	public void testUpdateCustomer() throws Exception {
		Customer testUpdateCustomer = new Customer(3, "adsa");
		boolean resultTestUpdateCustomer = customerService.updateCustomer(testUpdateCustomer);
		assertTrue(resultTestUpdateCustomer);
	}

	@Test
	public void testUpdateCustomer_customerIDNegative() {
		Customer testUpdateCustomerIdNegative = new Customer(-2, "adsa");
		int testCustomerIDNegative = -2;
		assertEquals(testCustomerIDNegative, testUpdateCustomerIdNegative.getCustomerId());
		Assertions.assertThrows(Exception.class, () -> {
			customerService.updateCustomer(testUpdateCustomerIdNegative);
		});
	}

	@Test
	public void testUpdateCustomer_customerNameNull() {
		Customer testUpdateCustomerName = new Customer(1, null);
		Assertions.assertThrows(Exception.class, () -> {
			customerService.updateCustomer(testUpdateCustomerName);
		});
	}

	@Test
	public void testUpdateCustomer_customerNull() {
		Customer testUpdateCustomerNull = new Customer(88, "lalala");
		Assertions.assertThrows(Exception.class, () -> {
			customerService.updateCustomer(testUpdateCustomerNull);
		});
	}
}
