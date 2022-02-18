package com.fpt.fresher.fj01.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fpt.fresher.fj01.model.Customer;
import com.fpt.fresher.fj01.model.LineItem;
import com.fpt.fresher.fj01.model.Order;

public class ReadFileTxt {

	/**
	 * Read file Customer.txt
	 * 
	 * @return List Customer
	 * @throws NumberFormatException
	 * @throws IOException
	 */

	public List<Customer> readCustomer() throws NumberFormatException, IOException {
		List<Customer> listOfCustomer = new ArrayList<>();

		File file = new File("Customer.txt");
		BufferedReader br = null;

		try {
			br = new BufferedReader(new FileReader(file));

			String st;
			while ((st = br.readLine()) != null) {

				String[] line = st.split("-");
				int ID = Integer.parseInt(line[0]);
				String name = line[1];

				Customer customer = new Customer(ID, name);

				listOfCustomer.add(customer);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listOfCustomer;
	}

	/**
	 * Read file ID.txt
	 * 
	 * @return List ID
	 * @throws NumberFormatException
	 * @throws IOException
	 */

	public List<Integer> readId() throws NumberFormatException, IOException {

		List<Integer> listId = new ArrayList<>();

		File file = new File("ID.txt");
		BufferedReader br = null;

		try {
			br = new BufferedReader(new FileReader(file));

			String st;
			while ((st = br.readLine()) != null) {

				String[] line = st.split("-");

				int ID = Integer.parseInt(line[0]);
				// String name = line[1];

				Integer id = ID;

				listId.add(id);

			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return listId;

	}
	
	/**
	 * Read file Order
	 * 
	 * @return List order
	 * @throws NumberFormatException
	 * @throws IOException
	 */

	public List<Order> readOrder() throws NumberFormatException, IOException {
		List<Order> listOfOrder = new ArrayList<>();

		File file = new File("Order.txt");
		BufferedReader br = null;

		try {
			br = new BufferedReader(new FileReader(file));

			String st;
			while ((st = br.readLine()) != null) {

				String[] line = st.split("-");
				int IdOrder = Integer.parseInt(line[0]);
				String date = line[1];
				int idCustom = Integer.parseInt(line[2]);
				int idEmployee = Integer.parseInt(line[3]);
				double total = Double.parseDouble(line[4]);

				Order order = new Order(IdOrder, date, idEmployee, idEmployee, total);

				listOfOrder.add(order);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listOfOrder;
	}
	
	/**
	 * Read file LineItem.txt
	 * 
	 * @return List LineItem
	 * @throws NumberFormatException
	 * @throws IOException
	 */
	public List<LineItem> readLineItem() throws NumberFormatException, IOException {
		
		List<LineItem> listOfLineItem = new ArrayList<>();

		File file = new File("LineItem.txt");
		BufferedReader br = null;

		try {
			br = new BufferedReader(new FileReader(file));

			String st;
			while ((st = br.readLine()) != null) {

				String[] line = st.split("-");
				int idOrder = Integer.parseInt(line[0]);
				int idProduct = Integer.parseInt(line[1]);
				int quantity = Integer.parseInt(line[2]);
				double price = Double.parseDouble(line[3]);

				LineItem lineItem = new LineItem(idOrder, idProduct, quantity, price);

				listOfLineItem.add(lineItem);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listOfLineItem;
	}
}
