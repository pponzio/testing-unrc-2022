package testing.mocks.teoria;

public class DummyShopDataAccess implements IShopDataAccess {

	public double getProductPrice(int productId) {
		throw new RuntimeException("The operation is not implemented.");
	}

	public void save(int orderId, Order o) {
		throw new RuntimeException("The operation is not implemented.");
	}

}