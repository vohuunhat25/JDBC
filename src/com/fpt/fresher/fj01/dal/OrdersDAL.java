package com.fpt.fresher.fj01.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import com.fpt.fresher.fj01.model.Order;
import com.fpt.fresher.fj01.util.DatabaseConnection;

public class OrdersDAL {
	private static Connection con;

	/**
	 * Find Order By orderID
	 * 
	 * @param orderID
	 * @return Order By orderID
	 * @throws SQLException
	 */
	public Order findOrderByID(int orderID) throws SQLException {
		
		Order orderFindById = null;

		try {
			con = DatabaseConnection.getDatabaseConnection();
			Statement stmt = con.createStatement();

			ResultSet rs = stmt.executeQuery("SELECT * FROM sms.orders WHERE order_id =" + orderID);

			while (rs.next()) {
				int idOders = rs.getInt(1);
				String odersDate = rs.getString(2);
				int idCustom = rs.getInt(3);
				int idEmployee = rs.getInt(4);
				double total = rs.getDouble(5);

				orderFindById = new Order(idOders, odersDate, idCustom, idEmployee, total);
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			con.close();
		}
		return orderFindById;
	}

	/**
	 * Find customerID in Orders
	 * 
	 * @param customerID
	 * @return Customer by ID in order
	 * @throws SQLException
	 */
	public Order findCustomerIDInOrder(int customerID) throws SQLException {

		Order customerIdInOrder = null;

		try {
			con = DatabaseConnection.getDatabaseConnection();
			Statement stmt = con.createStatement();

			ResultSet rs = stmt.executeQuery("SELECT * FROM sms.orders WHERE customer_id =" + customerID);

			while (rs.next()) {
				int idOders = rs.getInt(1);
				String odersDate = rs.getString(2);
				int idCustom = rs.getInt(3);
				int idEmployee = rs.getInt(4);
				double total = rs.getInt(5);

				customerIdInOrder = new Order (idOders, odersDate, idCustom, idEmployee, total);
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			con.close();
		}
		return customerIdInOrder;
	}

	/**
	 * Get all orders consist of order id, order date, customer id, employee id,
	 * total for a customer by CustomerID
	 * 
	 * @param customerId
	 * @return list of Orders by customerId
	 * @throws SQLException
	 * @throws Exception
	 */
	public List<Order> getAllOrdersByCustomerId(int customerId) throws SQLException {

		List<Order> listOders = new ArrayList<>();

		try {
			con = DatabaseConnection.getDatabaseConnection();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(
					"SELECT order_id, order_date, customer_id, employee_id, total FROM sms.orders WHERE customer_id ="
							+ customerId);
			Order order = null;

			while (rs.next()) {
				int idOders = rs.getInt(1);
				String odersDate = rs.getString(2);
				int idCustom = rs.getInt(3);
				int idEmployee = rs.getInt(4);
				double total = rs.getInt(5);

				order = new Order(idOders, odersDate, idCustom, idEmployee, total);
				listOders.add(order);
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			con.close();
		}
		return listOders;
	}

	/**
	 * Create an order into the database
	 * 
	 * @param order
	 * @return Result Add Order
	 */
	public boolean addOrder(Order order) {

		boolean resultAddOrder = false;

		int rowAddOrder = 0;

		try {
			con = DatabaseConnection.getDatabaseConnection();
			PreparedStatement preparedStatement = con.prepareStatement("INSERT INTO sms.orders VALUES(?, ?, ? ,?, ?)");
			preparedStatement.setInt(1, order.getOrderId());
			preparedStatement.setString(2, order.getOrderDate());
			preparedStatement.setInt(3, order.getCustomerId());
			preparedStatement.setInt(4, order.getEmployeeId());
			preparedStatement.setDouble(5, order.getTotal());

			rowAddOrder = preparedStatement.executeUpdate();

			if (rowAddOrder >= 1) {
				resultAddOrder = true;
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resultAddOrder;
	}

	/**
	 * Update an order total into the database
	 * 
	 * @param order
	 * @return Result Update Order Total
	 */
	public boolean updateOrder(int orderId) {

		boolean resultupdateOrderTotal = false;

		int rowUpdateOrderTotal = 0;
		
		double total = 1000;

		try {
			con = DatabaseConnection.getDatabaseConnection();
			PreparedStatement preparedStatement = con
					.prepareStatement("UPDATE sms.orders SET total = ? WHERE order_id = ?");
			preparedStatement.setDouble(1, total);
			preparedStatement.setInt(2, orderId);

			rowUpdateOrderTotal = preparedStatement.executeUpdate();

			if (rowUpdateOrderTotal >= 1) {
				resultupdateOrderTotal = true;
			}

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resultupdateOrderTotal;
	}
}
