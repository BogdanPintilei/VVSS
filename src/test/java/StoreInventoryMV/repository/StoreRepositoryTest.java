package StoreInventoryMV.repository;

import StoreInventoryMV.controller.StoreController;
import StoreInventoryMV.model.Product;
import junit.framework.TestCase;

import java.io.IOException;
import java.util.ArrayList;

public class StoreRepositoryTest extends TestCase {

	private StoreController con = new StoreController();

	public void testGetAllProducts() {
	}

	public void testReadFile() throws IOException {
		System.out.println("\nT E S T   >>  Read File\n");

		con.readProducts("products.txt");

		ArrayList<Product> allProds = con.stockSituation();
		assertEquals(6, allProds.size());
		for (Product product : allProds) {
			System.out.println(product.toString());
		}
		assertEquals(144, allProds.get(0).getQuantity());
		assertEquals("paine", allProds.get(1).getName());
		assertEquals("laptop", allProds.get(2).getName());
		assertEquals("aliment", allProds.get(3).getCategory());
		assertEquals(20, allProds.get(4).getQuantity());
		assertEquals(15, allProds.get(5).getCode());
	}

	public void testAddNewProduct() throws IOException {
		System.out.println("\nT E S T   >>  Add New Product\n");

		StoreController con = new StoreController();
		assertEquals(0, con.stockSituation().size());
		Product product = new Product(12345, "Samsung", "Telefon", 21);

		System.out.println((product.getCode() == 12345));
		assert (product.getCode() == 12345);
		System.out.println(product.getName().equals("Samsung"));
		assert (product.getName().equals("Samsung"));
		System.out.println(product.getCategory().equals("Telefon"));
		assert (product.getCategory().equals("Telefon"));
		System.out.println(product.getQuantity() == 21);
		assert (product.getQuantity() == 21);
//		con.addProduct(product);
//		assertEquals(1, con.stockSituation().size());
//		System.out.println(product.toString());
	}

	public void testDisplayAllProductsByCategory() throws IOException {
		System.out.println("\nT E S T   >>  Display All Products By Category\n");

		con.readProducts("products.txt");

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
		System.out.println("Number of it products: 2" + itProducts.size());
		assertEquals(2, itProducts.size());
	}

	public void testDisplayStockForGivenProduct() throws IOException {
		System.out.println("\nT E S T   >>  Display Stock For Given Product\n");

		con.readProducts("products.txt");

		ArrayList<Product> allProds = con.stockSituation();
		for (Product product : allProds) {
			System.out.println(product.toString());
		}
		System.out.println("\n");

		ArrayList<Product> temp = con.stockSituationProduct("telefon");
		for (Product product : temp) {
			if (product.getName().equals("telefon")) {
				assertEquals(50, product.getQuantity());
				System.out.println(product.toString());
				System.out.println("Assert: " + 50 + ", " + product.getQuantity());
			}
		}
	}

	public void testStockSituation() throws IOException {
		System.out.println("\nT E S T   >>  Stock Situation\n");

		con.readProducts("products.txt");

		ArrayList<Product> allProds = con.stockSituation();
		for (Product p : allProds) {
			System.out.println(p.toString());
		}
		System.out.println("\n");
		System.out.println("Nr of products: " + 6 + ", " + allProds.size());
		assertEquals(6, allProds.size());
	}
}