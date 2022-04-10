package testing.mocks.teoria;

public interface IShopDataAccess {
    double getProductPrice(int productId);
    void save(int orderId, Order o);
}