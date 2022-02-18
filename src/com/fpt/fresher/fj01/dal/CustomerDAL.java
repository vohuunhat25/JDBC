package com.fpt.fresher.fj01.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.fpt.fresher.fj01.model.Customer;
import com.fpt.fresher.fj01.util.DatabaseConnection;

public class CustomerDAL {
	private static Connection con;

	/**
	 * Get all customers consist of customer id, customer name in the order table
	 * 
	 * @return List of Customer
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public List<Customer> getAllCustomer() throws SQLException {

		List<Customer> listCustomer = new ArrayList<>();

		try {
			con = DatabaseConnection.getDatabaseConnection();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT sms.customer.customer_id,sms.customer.customer_name  FROM sms.customer INNER JOIN sms.orders ON sms.customer.customer_id = sms.orders.customer_id");

			while (rs.next()) {
				int ID = rs.getInt(1);
				String name = rs.getString(2);

				Customer customer = new Customer(ID, name);
				listCustomer.add(customer);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			con.close();
		}
		return listCustomer;
	}

	/**
	 * Find Customer By ID
	 * 
	 * @param customerID
	 * @return Customer By ID
	 * @throws SQLException
	 */
	public Customer findCustomerByID(int customerID) throws SQLException {

		Customer customerFindById = null;

		try {
			con = DatabaseConnection.getDatabaseConnection();
			Statement stmt = con.createStatement();

			ResultSet rs = stmt.executeQuery("SELECT * FROM sms.customer WHERE customer_id =" + customerID);

			while (rs.next()) {
				int IDcustomer = rs.getInt(1);
				String namecustomer = rs.getString(2);

				customerFindById = new Customer(IDcustomer, namecustomer);
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
		return customerFindById;
	}

	/**
	 * Add a customer into the database
	 * 
	 * @param customer
	 * @return Result add a customer
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public boolean addCustomer(Customer customer) throws SQLException {

		boolean resultAdd = false;

		int rowInset = 0;

		try {
			con = DatabaseConnection.getDatabaseConnection();
			PreparedStatement preparedStatement = con.prepareStatement("INSERT INTO sms.customer VALUES(?, ?)");
			preparedStatement.setInt(1, customer.getCustomerId());
			preparedStatement.setString(2, customer.getCustomerName());

			rowInset = preparedStatement.executeUpdate();

			if (rowInset >= 1) {
				resultAdd = true;
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
		return resultAdd;
	}

	/**
	 * Delete a customer from the database
	 * 
	 * @param customerId
	 * @return Result delete customer in table Customer
	 * @throws SQLException
	 */
	public boolean deleteCustomer(int customerId) throws SQLException {

		boolean resultDelete = false;

		int rowDelete = 0;

		try {
			con = DatabaseConnection.getDatabaseConnection();
			Statement stmt = con.createStatement();

			rowDelete = stmt.executeUpdate("DELETE FROM sms.customer WHERE customer_id =" + customerId);

			if (rowDelete >= 1) {
				resultDelete = true;
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
		return resultDelete;
	}

	/**
	 * Update a customer in the database
	 * 
	 * @param customer
	 * @return Result Update customer
	 * @throws SQLException
	 */
	public boolean updateCustomer(Customer customer) throws SQLException {

		boolean resultUpdate = false;

		int rowUpdate = 0;

		try {
			con = DatabaseConnection.getDatabaseConnection();
			PreparedStatement preparedStatement = con
					.prepareStatement("UPDATE sms.customer SET customer_name = ? WHERE customer_id = ?");

			preparedStatement.setString(1, customer.getCustomerName());
			preparedStatement.setInt(2, customer.getCustomerId());

			rowUpdate = preparedStatement.executeUpdate();

			if (rowUpdate >= 1) {
				resultUpdate = true;
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
		return resultUpdate;
	}
}
