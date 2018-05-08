package StoreInventoryMV.repository;

import StoreInventoryMV.controller.StoreController;
import StoreInventoryMV.model.Product;
import junit.framework.TestCase;

import java.io.IOException;
import java.util.ArrayList;

public class StoreRepositoryTestIntegration extends TestCase {

	private StoreController con = new StoreController();

	/// a)
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
	}


	/// b)
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


	/// c)
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


	/// integration
	public void testIntegration() throws IOException {
		testAddNewProduct();
		testDisplayAllProductsByCategory();
		testDisplayStockForGivenProduct();
	}
}
