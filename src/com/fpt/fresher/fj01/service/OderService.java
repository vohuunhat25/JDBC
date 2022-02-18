package com.fpt.fresher.fj01.service;

import java.sql.SQLException;
import java.util.List;

import com.fpt.fresher.fj01.dal.OrdersDAL;
import com.fpt.fresher.fj01.model.Order;

public class OderService {

	OrdersDAL orderDAL = new OrdersDAL();

	/**
	 * Find Order By ID
	 * 
	 * @param orderID
	 * @return Order By ID
	 * @throws SQLException
	 */
	public Order findOrderByID(int orderID) throws Exception {
		if (orderID <= 0) {
			throw new Exception("You can't use ID less 0");
		}
		return orderDAL.findOrderByID(orderID);
	}

	/**
	 * Find CustomerID in table orders
	 * 
	 * @param customerID
	 * @return customerID in table orders
	 * @throws Exception
	 */
	public Order findCustomerIDInOrder(int customerID) throws Exception {

		if (customerID <= 0) {
			throw new Exception("You can't use ID less 0");
		}
		return orderDAL.findCustomerIDInOrder(customerID);

	}

	/**
	 * Get all orders by CustomerID
	 * 
	 * @param customerId
	 * @return List of Order by customerId
	 * @throws Exception
	 */

	public List<Order> getAllOrdersByCustomerId(int customerId) throws Exception {

		List<Order> reslutOrder = null;

		if (customerId < 0) {
			throw new Exception("you can't not use customer ID ");
		}

		if (findCustomerIDInOrder(customerId) == null) {
			throw new Exception(
					"Customer with ID " + customerId + " is not exist you can't get Orders By Customer ID ");
		}
		return reslutOrder = orderDAL.getAllOrdersByCustomerId(customerId);

	}

	/**
	 * Create an order into the database
	 * 
	 * @param order
	 * @return result add new order in the datadase
	 * @throws Exception
	 */

	public boolean addOrder(Order order) throws Exception {

		Order orderIDFromDB = findOrderByID(order.getOrderId());

		if (orderIDFromDB != null) {
			throw new Exception("Order with ID " + order.getOrderId() + " is existed you can't add a new Order");
		}

		if (order.getOrderId() <= 0) {
			throw new Exception("You can't add ID less 0");
		}

		if (order.getOrderDate() == null) {
			throw new Exception("you can't leave the date blank ");
		}

		return orderDAL.addOrder(order);
	}

	/**
	 * Update an order total into the database
	 * 
	 * @param orderId
	 * @param total
	 * @return result update order total into the database
	 * @throws Exception
	 */
	public boolean updateOrder(int orderId) throws Exception {

		if (findOrderByID(orderId) == null) {
			throw new Exception("Customer with ID " + orderId + " is not exist you can't update a Order");
		}
		return orderDAL.updateOrder(orderId);
	}
}