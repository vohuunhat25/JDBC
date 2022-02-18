package com.fpt.fresher.fj01.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.sql.SQLException;
import java.util.List;

import org.junit.Test;

import org.junit.jupiter.api.Assertions;

import com.fpt.fresher.fj01.dal.OrdersDAL;
import com.fpt.fresher.fj01.model.Order;
import com.fpt.fresher.fj01.service.OderService;

public class OrderServiceTest {

	OderService OderService = new OderService();

	@Test
	public void testFindOrderByID() throws Exception {
		Order order = OderService.findOrderByID(1);
		assertNotNull(order);
	}

	@Test
	public void testFindOrderByID_orderIdNegative() throws Exception {
		Assertions.assertThrows(Exception.class, () -> {
			Order testFindOrderIdNegative = OderService.findOrderByID(-2);
		});
	}

	@Test
	public void testFindCustomerIDInOrder() throws Exception {
		Order resultTestFindCustomerID = OderService.findCustomerIDInOrder(2);
		assertNotNull(resultTestFindCustomerID);
	}

	@Test
	public void testFindCustomerIdInOrder_customerIdNegative() throws Exception {
		Assertions.assertThrows(Exception.class, () -> {
			Order testFindCustomerIdNegative = OderService.findCustomerIDInOrder(-3);
		});
	}

	@Test
	public void testGetAllOrdersByCustomerId() throws Exception {
		List<Order> resultTestGetAllOrdersByCustomerId = OderService.getAllOrdersByCustomerId(2);
		assertNotNull(resultTestGetAllOrdersByCustomerId);
	}

	@Test
	public void testGetAllOrdersByCustomerId_customerIdNegative() {
		Assertions.assertThrows(Exception.class, () -> {
			OderService.getAllOrdersByCustomerId(-2);
		});
	}

	@Test
	public void testGetAllOrdersByCustomerId_customerIdNull() {
		Assertions.assertThrows(Exception.class, () -> {
			OderService.getAllOrdersByCustomerId(89896);
		});
	}

	@Test
	public void testAddOrder() throws Exception {
		Order testAddOrder = new Order(95, "2021-01-05", 5, 6, 1000);
		boolean resultTestAddOrder = OderService.addOrder(testAddOrder);
		assertTrue(resultTestAddOrder);
	}

	@Test
	public void testAddOrder_orderNotNull() {
		Order testAddOrderNotNull = new Order(25, "2021-01-05", 5, 6, 1000);
		Assertions.assertThrows(Exception.class, () -> {
			OderService.addOrder(testAddOrderNotNull);
		});
	}

	@Test
	public void testAddOrder_orderIdNegative() {
		Order testAddOrderIdNegative = new Order(-5, "2021-01-05", 5, 6, 1000);
		Assertions.assertThrows(Exception.class, () -> {
			OderService.addOrder(testAddOrderIdNegative);
		});
	}

	@Test
	public void testAddOrder_orderDateNull() {
		Order testAddOrderDateNull = new Order(115, null, 5, 6, 1000);
		Assertions.assertThrows(Exception.class, () -> {
			OderService.addOrder(testAddOrderDateNull);
		});
	}

	@Test
	public void testupdateOrder() throws Exception {
		boolean testupdateOrder = OderService.updateOrder(2);
		assertTrue(testupdateOrder);
	}

	@Test
	public void testupdateOrder_orderIdNull() {
		Assertions.assertThrows(Exception.class, () -> {
			OderService.updateOrder(988796515);
		});
	}

}
