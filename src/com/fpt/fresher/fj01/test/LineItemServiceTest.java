package com.fpt.fresher.fj01.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.fpt.fresher.fj01.model.LineItem;
import com.fpt.fresher.fj01.service.LineItemService;

public class LineItemServiceTest {

	LineItemService lineItemService = new LineItemService();

	@Test 
	public void testFindOrderIDInLineItem() throws Exception {
		LineItem testFindOrderIDInLineItem = lineItemService.findOrderIDInLineItem(1);
		assertNotNull(testFindOrderIDInLineItem);
	}

	@Test
	public void testFindOrderIDInLineItem_orderIDNegative() {
		Assertions.assertThrows(Exception.class, () -> {
			lineItemService.findOrderIDInLineItem(-5);
		});
	}

	@Test
	public void testGetAllItemsByOrderId() throws Exception {
		List<LineItem> resultGetAllItemByOrderId = lineItemService.getAllItemsByOrderId(2);
		assertNotNull(resultGetAllItemByOrderId);
	}

	@Test
	public void testGetAllItemsByOrderId_orderIdNull() {
		Assertions.assertThrows(Exception.class, () -> {
			lineItemService.getAllItemsByOrderId(4565621);
		});
	}

	@Test
	public void testGetAllItemsByOrderId_orderIdNegative() {
		Assertions.assertThrows(Exception.class, () -> {
			lineItemService.getAllItemsByOrderId(-5);
		});
	}

	@Test
	public void testcomputeOrderTotal() throws Exception {
		double resultTotalPrice = 10000;
		double abc = lineItemService.computeOrderTotal(1);
		assertEquals(abc, resultTotalPrice);
	}

	@Test
	public void testAddLineItem() throws Exception {
		LineItem testAddLineItem = new LineItem(7, 2, 10, 5000);
		boolean resultTestAddLineItem = lineItemService.addLineItem(testAddLineItem);
	}

	@Test
	public void testAddLineItem_orderIdNull() {
		LineItem testAddLineItemOrderIdNull = new LineItem(-7, 2, 10, 5000);
		int testOrderId = -7;
		assertEquals(testOrderId, testAddLineItemOrderIdNull.getOrderId());
		Assertions.assertThrows(Exception.class, () -> {
			lineItemService.addLineItem(testAddLineItemOrderIdNull);
		});
	}

	@Test
	public void testAddLineItem_productIdNull() {
		LineItem testAddLineItemProductIdNull = new LineItem(7, -2, 10, 5000);
		int testProductId = -2;
		assertEquals(testProductId, testAddLineItemProductIdNull.getProductId());
		Assertions.assertThrows(Exception.class, () -> {
			lineItemService.addLineItem(testAddLineItemProductIdNull);
		});
	}

	@Test
	public void testAddLineItem_quantityNull() {
		LineItem testAddLineItemQuantityNull = new LineItem(7, 2, -10, 5000);
		int testQuantiy = -10;
		assertEquals(testQuantiy, testAddLineItemQuantityNull.getQuantity());
		Assertions.assertThrows(Exception.class, () -> {
			lineItemService.addLineItem(testAddLineItemQuantityNull);
		});
	}

	@Test
	public void testAddLineItem_priceNull() {
		LineItem testAddLineItemPriceNull = new LineItem(7, 2, 10, -5000);
		double testPrice = -5000;
		assertEquals(testPrice, testAddLineItemPriceNull.getPrice());
		Assertions.assertThrows(Exception.class, () -> {
			lineItemService.addLineItem(testAddLineItemPriceNull);
		});
	}

}
