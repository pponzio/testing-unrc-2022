package testing.mocks.teoria;

public class Product {

	private int id;
	private int price;

	public Product(int id, int price) {
		this.id = id;
		this.price = price;
	}

	public double getUnitPrice() {
		return price;
	}

	public int getID() {
		return id;
	}
	
	

}
