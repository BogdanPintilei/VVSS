package StoreInventoryMV.ui;

import StoreInventoryMV.controller.StoreController;
import StoreInventoryMV.model.Product;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * Created by Vlad on 17-Mar-16.
 */
public class StoreUI {
	private static StoreController ctrl;
	private Scanner in;

	public StoreUI(StoreController ctrl) {
		this.ctrl = ctrl;
		this.in = new Scanner(System.in);
	}

	private void printMenu() {
		String menu;
		menu = ">> Welcome to the Store Inventory <<\n";
		menu += "\t 1 - Add a new Product \n";
		menu += "\t 2 - Displays all products from given category\n";
		menu += "\t 3 - Stock situation for all products \n";
		menu += "\t 4 - Stock situation for a certain product \n";
		menu += "\t 0 - Exit \n";
		System.out.println(menu);
	}

	private void AddNewProduct() throws IOException {
		// Product code
		System.out.println("Give the Product code:");
		String input = in.nextLine();
		while (!Pattern.matches("[0-9]+", input) || input.trim().isEmpty()) {
			System.out.println("Product code invalid!\nRetry Product code: ");
			input = in.nextLine();
		}
		int pCode = Integer.parseInt(input);

		// Product name
		System.out.println("Give the product name:");
		input = in.nextLine();
		while (!Pattern.matches("[a-zA-Z]+", input) || input.trim().isEmpty()) {
			System.out.println("Product name!\nRetry Product name: ");
			input = in.nextLine();
		}
		String pName = input;

		// Product category
		System.out.println("Give the product category:");
		input = in.nextLine();
		while (!Pattern.matches("[a-zA-Z]+", input) || input.trim().isEmpty()) {
			System.out.println("Product category!\nRetry Product category: ");
			input = in.nextLine();
		}
		String pCategory = input;

		System.out.println("Give the quantity:");
		input = in.nextLine();
		while (!Pattern.matches("[0-9]+", input) || input.trim().isEmpty()) {
			System.out.println("Product quantity invalid!\nRetry Product quantity: ");
			input = in.nextLine();
		}
		int pQunatity = Integer.parseInt(input);

		Product p = new Product(pCode, pName, pCategory, pQunatity);
		ctrl.addProduct(p);
		System.out.println(p.toString());
		System.out.println("Product Added");
	}

	private void DisplaAllProductsByCategory() {
		DisplayStockAllProducts();
		System.out.println("Give category: ");
		String cat = in.nextLine();
		while (!Pattern.matches("[a-zA-Z]+", cat) || cat.trim().isEmpty()) {
			System.out.println("Category invalid!\nRetry category: ");
			cat = in.nextLine();
		}
		ArrayList<Product> temp = ctrl.getProductsCategory(cat);
		for (Product p : temp) {
			System.out.println(p.toString());
		}
	}

	private void DisplayStockAllProducts() {
		ArrayList<Product> temp = ctrl.stockSituation();
		for (Product p : temp) {
			System.out.println(p.toString());
		}
	}

	private void DisplayStockForGivenProduct() {
		DisplayStockAllProducts();
		System.out.println("Give Product name:");
		String product = in.nextLine();
		while (!Pattern.matches("[a-zA-Z]+", product) || product.trim().isEmpty()) {
			System.out.println("Category product name!\nRetry Product name: ");
			product = in.nextLine();
		}
		ArrayList<Product> temp = ctrl.stockSituationProduct(product);
		for (Product p : temp) {
			System.out.println(p.toString());
		}
	}

	private int readCommand() {
		System.out.println("Give a command: ");
		String command = in.nextLine();
		while (!Pattern.matches("[0-4]+", command) || command.trim().isEmpty() || command.length() > 1) {
			printMenu();
			System.out.println("Invalid command!\nRetry command: ");
			command = in.nextLine();
		}
		return Integer.parseInt(command);
	}

	private void executeCommand(int c) throws IOException {
		switch (c) {
			case 1:
				AddNewProduct();
				break;
			case 2:
				DisplaAllProductsByCategory();
				break;
			case 3:
				DisplayStockAllProducts();
				break;
			case 4:
				DisplayStockForGivenProduct();
				break;
			default:
				System.out.println("Bye Bye... ^_^\n");
				break;
		}
	}

	public void run() throws IOException {
		int c;
		do {
			printMenu();
			c = readCommand();
			executeCommand(c);
		} while (c != 0);

	}
}
