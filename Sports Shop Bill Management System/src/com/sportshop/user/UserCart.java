package com.sportshop.user;

import java.util.ArrayList;
import java.util.Scanner;

import com.sportshop.product.Product;

public class UserCart {

	private ArrayList<Product> productList = new ArrayList<>();
	private ArrayList<Product> cartList = new ArrayList<>();

	private double totalCost = 0.0;
	private Scanner scanner = new Scanner(System.in);

	{
		productList.add(new Product(1, "Football", 250));
		productList.add(new Product(2, "Basketball", 300));
		productList.add(new Product(3, "Volleyball", 200));
		productList.add(new Product(4, "Cricket Bat", 700));
		productList.add(new Product(5, "Cricket Ball", 300));
		productList.add(new Product(6, "Shoes", 1000));
		productList.add(new Product(7, "Tennis Racket", 800));
		productList.add(new Product(8, "Tennis Ball", 50));
		productList.add(new Product(9, "Chess Board", 300));
		productList.add(new Product(10, "Carrom", 400));
	}

	public void displayMenu() {
		System.out.println("===============Welcome to SportsMania===============");
		System.out.println("");
		System.out.println("-----------Are you ready for some sports?-----------");
		boolean quit = false;
		while (!quit) {
			int choice = 0;
			System.out.println("");
			System.out.println("---------------------Menu List---------------------");
			System.out.println("1. View product list");
			System.out.println("2. Add item to cart");
			System.out.println("3. Remove item from cart");
			System.out.println("4. Find product by Name");
			System.out.println("5. View Cart");
			System.out.println("6. Calculate bill");
			System.out.println("7. Quit");

			System.out.println("=====================================================");
			System.out.print("Choice : ");

			try {
				choice = scanner.nextInt();
			} catch (Exception e) {

			}

			scanner.nextLine();

			switch (choice) {

			case 1:
				viewProductList();
				break;

			case 2:
				addItemToCart();
				break;

			case 3:
				removeItemFromCart();
				break;

			case 4:
				System.out.println("Enter Product name : ");
				Product product = findProductByName(scanner.nextLine());
				System.out.println("The details of product : ");
				System.out.println("");
				System.out.println("**************************");
				System.out.println("ID   Name           Price");
				System.out.println("**************************");
				System.out.println(product);
				break;

			case 5:
				viewCart();
				break;

			case 6:
				calculateBill();
				break;

			case 7:
				quit = true;
				break;

			default:
				System.out.println("Invalid choice!");
			}
		}
	}

	private void viewCart() {
		double amount = 0;
		if (!this.cartList.isEmpty()) {
			System.out.println("Your cart details : ");
			System.out.println("--------------------------");
			System.out.println("ID   Name           Price");
			System.out.println("**************************");
			this.cartList.forEach(System.out::println);
			for (Product product : cartList) {
				amount += product.getPrice();
			}
			System.out.println("**************************");
			System.out.println("Total Amount : " + amount);
			amount = 0;
		} else {
			System.err.println("Your cart is empty!");
		}

	}

	public void viewProductList() {
		System.out.println("");
		System.out.println("Available products in our store");
		System.out.println("***************************");
		System.out.println("ID   Name           Price");
		System.out.println("***************************");
		this.productList.forEach(System.out::println);
		System.out.println("***************************");
		System.out.println("");
		System.out.println("");
	}

	public void addItemToCart() {
		int productId = 0;
		System.out.println("Enter the ID of the product to add to cart:");
		try {
			productId = scanner.nextInt();
		} catch (Exception e) {

		}
		scanner.nextLine();
		Product product = findProductById(productId);
		if (product != null) {
			if (this.cartList.contains(product)) {
				System.out.println("Product is already added in the cart");
			} else {
				cartList.add(product);
				System.out.println("Item added to cart!");
			}
		} else {
			System.err.println("Product not found!");
		}
	}

	public Product findProductById(int productId) {
		Product key = new Product();
		key.setId(productId);
		if (this.productList.contains(key)) {
			int index = this.productList.indexOf(key);
			Product value = this.productList.get(index);
			return value;
		}
		return null;
	}

	public void removeItemFromCart() {
		int productId = 0;
		System.out.println("Enter the ID of the product to remove from cart:");
		try {
			productId = scanner.nextInt();
		} catch (Exception e) {

		}
		scanner.nextLine();
		Product product = findProductById(productId);
		if (product != null) {
			if (cartList.remove(product)) {
				System.out.println("Item removed from cart!");
			} else {
				System.err.println("Item not found in cart!");
			}
		} else {
			System.err.println("Product not found!");
		}
	}

	public Product findProductByName(String name) {
		for (Product product : productList) {
			if (product.getName().equalsIgnoreCase(name)) {
				return product;
			}
		}
		return null;
	}

	public void calculateBill() {
		String name;

		System.out.print("Enter name 	    : ");
		name = scanner.nextLine();
		System.out.println("");
		System.out.println("Your orders ");
		System.out.println("");
		System.out.println("****************************");
		System.out.println("ID   Name           Price");
		System.out.println("****************************");
		for (Product product : cartList) {

			System.out.println(product);
			totalCost += product.getPrice();
		}
		System.out.println("**************************");
		System.out.println("Bill amount  : " + totalCost);
		System.out.println("**************************");
		System.out.println("Thank you for shopping with us " + name + "!");
		System.out.println("");

		cartList.clear();
		totalCost = 0.0;
	}
}
