package com.fpt.fresher.fj01.service;

import java.sql.SQLException;
import java.util.List;

import com.fpt.fresher.fj01.dal.LineIteamDAL;
import com.fpt.fresher.fj01.model.LineItem;

public class LineItemService {

	LineIteamDAL lineItemDAL = new LineIteamDAL();

	/**
	 * Find OrderID in table LineItem
	 * 
	 * @param orderID
	 * @return OrderID in table LineItem
	 * @throws Exception
	 */

	public LineItem findOrderIDInLineItem(int orderID) throws Exception {

		if (orderID <= 0) {
			throw new Exception("You can use orderID less 0");
		}
		return lineItemDAL.findOrderIDInLineItem(orderID);
	}

	/**
	 * Get All Items By OrderId
	 * 
	 * @param orderId
	 * @return List of LineItem by orderId
	 */
	public List<LineItem> getAllItemsByOrderId(int orderId) throws Exception {

		List<LineItem> resultLineItem = null;

		if (findOrderIDInLineItem(orderId) == null) {
			throw new Exception("Order with ID " + orderId + " is not exist you can't get a LineItem");
		}
		if (orderId <= 0) {
			throw new Exception("You can't use orderID less 0");
		}
		return resultLineItem = lineItemDAL.getAllItemsByOrderId(orderId);

	}

	/**
	 * Compute order total from the lineitems for given order id
	 * 
	 * @param orderId
	 * @return Compute order total from the lineitems
	 * @throws Exception
	 */
	public double computeOrderTotal(int orderId) throws Exception {

		List<LineItem> LineItemByOrderId = getAllItemsByOrderId(orderId);

		double totalPrice = 0;

		try {
			for (LineItem lineItem : LineItemByOrderId) {
				totalPrice += lineItem.getPrice();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return totalPrice;
	}

	/**
	 * Create a line item into the database
	 * 
	 * @param item
	 * @return Result Add LineItem
	 * @throws Exception
	 */
	public boolean addLineItem(LineItem item) throws Exception {

		if (item.getOrderId() <= 0) {
			throw new Exception("You can't add ID less 0");
		}

		if (item.getProductId() <= 0) {
			throw new Exception("You can't add ID less 0");
		}

		if (item.getQuantity() <= 0) {
			throw new Exception("You can't add ID less 0");
		}

		if (item.getPrice() <= 0) {
			throw new Exception("You can't add ID less 0");
		}
		return lineItemDAL.addLineItem(item);
	}

}
