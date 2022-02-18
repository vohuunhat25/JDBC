package com.fpt.fresher.fj01.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.fpt.fresher.fj01.model.LineItem;
import com.fpt.fresher.fj01.util.DatabaseConnection;

public class LineIteamDAL {
	private static Connection con;

	/**
	 * Get all Item by OrderID
	 * 
	 * @param orderId
	 * @return list of LineIteam by orderId
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */

	public List<LineItem> getAllItemsByOrderId(int orderId) throws SQLException {

		List<LineItem> listLineIteam = new ArrayList<>();

		try {
			con = DatabaseConnection.getDatabaseConnection();
			Statement stmt = con.createStatement();
			LineItem lineItem;
			ResultSet rs = stmt.executeQuery("SELECT * FROM sms.lineitem WHERE order_id =" + orderId);

			while (rs.next()) {
				int idOrder = rs.getInt(1);
				int idProduct = rs.getInt(2);
				int quantity = rs.getInt(3);
				double price = rs.getInt(4);

				lineItem = new LineItem(idOrder, idProduct, quantity, price);
				listLineIteam.add(lineItem);
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			con.close();
		}
		return listLineIteam;
	}

	/**
	 * Create a lineitem into the database
	 * 
	 * @param item
	 * @return Result Add LineItem
	 */

	public boolean addLineItem(LineItem item) {

		int rowAddLineItem = 0;

		boolean resultAddLineItem = false;

		try {
			con = DatabaseConnection.getDatabaseConnection();
			PreparedStatement preparedStatement = con.prepareStatement("INSERT INTO sms.lineitem VALUES(?, ?, ?, ?)");
			preparedStatement.setInt(1, item.getOrderId());
			preparedStatement.setInt(2, item.getProductId());
			preparedStatement.setInt(3, item.getQuantity());
			preparedStatement.setDouble(4, item.getPrice());

			rowAddLineItem = preparedStatement.executeUpdate();

			if (rowAddLineItem >= 1) {
				resultAddLineItem = true;
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resultAddLineItem;
	}

	/**
	 * Find OrderID in table LineItem
	 * 
	 * @param orderID
	 * @return OrderID in table LineItem
	 * @throws SQLException
	 */
	public LineItem findOrderIDInLineItem(int orderID) throws SQLException {

		LineItem orderIdInLineItem = null;

		try {
			con = DatabaseConnection.getDatabaseConnection();
			Statement stmt = con.createStatement();

			ResultSet rs = stmt.executeQuery("SELECT * FROM sms.lineitem WHERE order_id =" + orderID);

			while (rs.next()) {
				int idOrder = rs.getInt(1);
				int idProduct = rs.getInt(2);
				int quantity = rs.getInt(3);
				double price = rs.getInt(4);

				orderIdInLineItem = new LineItem(idOrder, idProduct, quantity, price);
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
		return orderIdInLineItem;
	}

}
