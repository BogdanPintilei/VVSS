package StoreInventoryMV.controller;

import StoreInventoryMV.model.Product;
import StoreInventoryMV.repository.StoreRepository;

import java.io.IOException;
import java.util.ArrayList;

public class StoreController {

	private StoreRepository io = new StoreRepository();

	public void readProducts(String fileName) throws IOException {
		io.readFile(fileName);
	}

	public void addProduct(Product product) throws IOException {
		io.addNewProduct(product);
	}

	public ArrayList<Product> getProductsCategory(String category) {
		return io.getProductsCategory(category);
	}

	public ArrayList<Product> stockSituationProduct(String productName) {
		return io.stockSituationProduct(productName);
	}

	public ArrayList<Product> stockSituation() {
		return io.stockSituation();
	}
}
