package StoreInventoryMV;

import StoreInventoryMV.controller.StoreController;
import StoreInventoryMV.ui.StoreUI;

import java.io.IOException;

public class App {

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {

//		Product p=new Product();
		//p.read();
		StoreController c = new StoreController();
		c.readProducts("products.txt");

		StoreUI u = new StoreUI(c);
		u.run();
		//c.addProduct(p);
		//	for(Product q:c.getProductsCategory("second")){
		//	System.out.println(q.toString());
		//}
//		for(Product q:c.stockSituationProduct("Laptop"))
//			System.out.println(q.toString());
//
	}

}
