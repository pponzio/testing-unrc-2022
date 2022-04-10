package testing.mocks.teoria;

import java.util.HashMap;
import java.util.Map;

public class FakeShopDataAccess implements IShopDataAccess {
	
	private Map<Integer, Product> products = new HashMap<>();

	public void addProduct(Product product) {
		products.put(product.getID(), product);
	}

	public double getProductPrice(int productId) {
        if (this.products.get(productId) != null) {
            return this.products.get(productId).getUnitPrice();
        }
        throw new RuntimeException("Product not found");
	}

	public void save(int orderId, Order o) {  }

}
