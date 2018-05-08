package StoreInventoryMV.repository;

import StoreInventoryMV.controller.StoreController;
import StoreInventoryMV.model.Product;
import junit.framework.TestCase;

import java.io.IOException;
import java.util.ArrayList;

public class StoreRepositoryTestWBT extends TestCase {

	private StoreController con = new StoreController();

	public void testDisplayAllProductsByCategory_all() throws IOException {
		System.out.println("\nT E S T   >>  Display All Products By Category - All\n");

		con.readProducts("productsByCategoryAll.txt");

		ArrayList<Product> allProds = con.stockSituation();
		for (Product p : allProds) {
			System.out.println(p.toString());
		}

		System.out.println("\n");
		ArrayList<Product> alimentProducts = con.getProductsCategory("aliment");
		for (Product product : alimentProducts) {
			System.out.println(product.toString());
		}
		assertEquals(4, alimentProducts.size());

		System.out.println("\n");
		ArrayList<Product> itProducts = con.getProductsCategory("it");
		for (Product product : itProducts) {
			System.out.println(product.toString());
		}
		assertEquals(2, itProducts.size());
	}

	public void testDisplayAllProductsByCategory_empty() throws IOException {
		System.out.println("\nT E S T   >>  Display All Products By Category - Empty\n");

		con.readProducts("productsByCategoryEmpty.txt");

		ArrayList<Product> allProds = con.stockSituation();
		for (Product p : allProds) {
			System.out.println(p.toString());
		}

		System.out.println("\n");
		ArrayList<Product> alimentProducts = con.getProductsCategory("aliment");
		for (Product product : alimentProducts) {
			System.out.println(product.toString());
		}
		assertEquals(0, alimentProducts.size());

		System.out.println("\n");
		ArrayList<Product> itProducts = con.getProductsCategory("it");
		for (Product product : itProducts) {
			System.out.println(product.toString());
		}
		assertEquals(0, itProducts.size());
	}
}
