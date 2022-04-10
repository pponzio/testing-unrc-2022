package testing.mocks.teoria;

public class SpyShopDataAccess implements IShopDataAccess {
	private boolean saveInvoked = false;

	public double getProductPrice(int productId) {
		return 25;
	}

	public void save(int orderId, Order o) {
		saveInvoked = true;
	}
	
	public boolean saveInvoked() {
		return saveInvoked;
	}
}
