package com.fpt.fresher.fj01.controller;

import java.util.List;
import java.util.Scanner;

import com.fpt.fresher.fj01.model.LineItem;
import com.fpt.fresher.fj01.model.Order;
import com.fpt.fresher.fj01.service.CustomerService;
import com.fpt.fresher.fj01.service.LineItemService;
import com.fpt.fresher.fj01.service.OderService;
import com.fpt.fresher.fj01.service.ReadFileTxt;

public class Main {
	public static void main(String[] args)  {

		CustomerService custommerSevice = new CustomerService();
		OderService oderService = new OderService();
		LineItemService lineItemService = new LineItemService();

		System.out.println("You can choose one funtion");
		System.out.println("1: Get list with all customers in the order table");
		System.out.println("2: Delete a customer from the database");
		System.out.println("3: Add a customer into the database");
		System.out.println("4: Update a customer in the database");
		System.out.println("5: Get all orders by CustomerID");
		System.out.println("6: Create an order into the database");
		System.out.println("7: Update an order total into the database");
		System.out.println("8: Get All Items By OrderId");
		System.out.println("9: Compute order total from the line items for given order id");
		System.out.println("10: Create a line item into the database");
		System.out.println("Your Choose: ");

		Scanner sc = new Scanner(System.in);
		int choose = sc.nextInt();

		ReadFileTxt readFile = new ReadFileTxt();

		switch (choose) {
		case 1:
			
			try {
				System.out.println(" All Customer in the order table : " + custommerSevice.getAllCustomer());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case 2:
			boolean resultDelete = false;
			try {
				resultDelete = custommerSevice.deleteCustomer(readFile.readId().get(2));
				if (resultDelete == true) {
					System.out.println("You delete successful");
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			break;
		case 3:
			boolean resultAdd = false;
			try {
				resultAdd = custommerSevice.addCustomer(readFile.readCustomer().get(1));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (resultAdd = true) {
				System.out.println("You add successful");
			}
			break;
		case 4:
			boolean resultUpdate = false;
			try {
				resultUpdate = custommerSevice.updateCustomer(readFile.readCustomer().get(3));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (resultUpdate = true) {
				System.out.println("You update successful");
			}
			break;
		case 5:
			List<Order> resultGetOrder = null;
			try {
				resultGetOrder = oderService.getAllOrdersByCustomerId(readFile.readId().get(3));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(" Orders By CustomerId " + resultGetOrder);
			break;
		case 6:
			boolean resultAddOrder = false;
			try {
				resultAddOrder = oderService.addOrder(readFile.readOrder().get(5));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (resultAddOrder = true) {
				System.out.println("You add Order successful");
			}
			break;
		case 7:
			boolean resultUpdateOrder = false;
			try {
				resultUpdateOrder = oderService.updateOrder(readFile.readId().get(0));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(resultUpdateOrder = true) {
				System.out.println("You update successful");
			}
			System.out.println();
			break;
		case 8:
			List<LineItem> resultGetItems = null;
			try {
				resultGetItems = lineItemService.getAllItemsByOrderId(readFile.readId().get(1));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("Items By OrderId " + resultGetItems);
			break;
		case 9:
			double resultCompute = 0;
			try {
				resultCompute = lineItemService.computeOrderTotal(readFile.readId().get(1));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("Compute order total " + resultCompute);
			break;
		case 10:
			boolean reslutAddLineItem = false;
			try {
				reslutAddLineItem = lineItemService.addLineItem(readFile.readLineItem().get(5));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (reslutAddLineItem = true) {
				System.out.println("You add successful");
			}
			break;
		}
	}
}
