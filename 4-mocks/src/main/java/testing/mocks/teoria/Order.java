package testing.mocks.teoria;

import java.util.LinkedList;
import java.util.List;

public class Order {

	private int id;
	private IShopDataAccess dataAccess;
	private List<OrderLine> orderLines;

	public Order(int id, IShopDataAccess dataAccess) {
		this.id = id;
		this.dataAccess = dataAccess;
		this.orderLines = new LinkedList<OrderLine>();
	}
	
	public IShopDataAccess getDataAccess() {
		return dataAccess;
	}

	public void save() {
		this.dataAccess.save(this.id, this);
	}

    public List<OrderLine> getLines() {
		return orderLines;
	}
	
	public void add(OrderLine o){
		orderLines.add(o);
	} 

	public void remove(OrderLine o){
		orderLines.remove(o);
	}
    
}  