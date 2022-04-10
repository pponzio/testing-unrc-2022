package testing.mocks.teoria;

public class StubShopDataAccess implements IShopDataAccess {

	public double getProductPrice(int productId) {
		return 25;
	}

	public void save(int orderId, Order o) {
		
	}
	
}
