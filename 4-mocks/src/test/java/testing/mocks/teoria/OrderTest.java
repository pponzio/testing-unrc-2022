package testing.mocks.teoria;


import static org.easymock.EasyMock.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import testing.mocks.teoria.DummyShopDataAccess;
import testing.mocks.teoria.FakeShopDataAccess;
import testing.mocks.teoria.IShopDataAccess;
import testing.mocks.teoria.Order;
import testing.mocks.teoria.OrderLine;
import testing.mocks.teoria.Product;
import testing.mocks.teoria.SpyShopDataAccess;
import testing.mocks.teoria.StubShopDataAccess;

public class OrderTest {

	@Test 
	public void createOrder() {
	    DummyShopDataAccess dataAccess = new DummyShopDataAccess();

	    Order o = new Order(2, dataAccess);
	    o.add(new OrderLine(o, 1234, 1));
	    o.add(new OrderLine(o, 4321, 3));

	    assertEquals(2, o.getLines().size());
	} 
	
	@Test 
	public void saveOrder() {
	    StubShopDataAccess dataAccess = new StubShopDataAccess();

	    Order o = new Order(3, dataAccess);
	    o.add(new OrderLine(o, 1234, 1));
	    o.add(new OrderLine(o, 4321, 3));

	    o.save();
	} 
	
	@Test 
	public void calculateSingleLineTotal() {
		StubShopDataAccess dataAccess = new StubShopDataAccess();

		Order o = new Order(4, dataAccess);
		o.add(new OrderLine(o, 1234, 2));

		double lineTotal = o.getLines().get(0).getTotal();
		assertEquals(50, lineTotal, 0.01);
	} 
	
	@Test 
	public void saveOrderWithDataAccessVerification() {
	    SpyShopDataAccess dataAccess = new SpyShopDataAccess();

	    Order o = new Order(3, dataAccess);
	    o.add(new OrderLine(o, 1234, 1));
	    o.add(new OrderLine(o, 4321, 3));

	    o.save();
	    assertTrue(dataAccess.saveInvoked());
	} 
	
	@Test 
	public void calculateLineTotalsUsingFake() {
	    FakeShopDataAccess dataAccess = new FakeShopDataAccess();
	    dataAccess.addProduct(new Product(1234, 45));
	    dataAccess.addProduct(new Product(2345, 15));

	    Order o = new Order(6, dataAccess);
	    o.add(new OrderLine(o, 1234, 3));
	    o.add(new OrderLine(o, 2345, 2));

	    assertEquals(135, o.getLines().get(0).getTotal(), 0.01);
	    assertEquals(30, o.getLines().get(1).getTotal(), 0.01);
	}
	
	@Test 
	public void saveOrderAndVerifyExpectationsUsingMock() {
	    IShopDataAccess dataAccess = createMock(IShopDataAccess.class);

	    Order o = new Order(6, dataAccess);
	    o.add(new OrderLine(o, 1234, 1));
	    o.add(new OrderLine(o, 4321, 3));

	    // Especificar comportamiento esperado
	    dataAccess.save(6, o);
	    // Crear mock para el comportamiento anterior 
	    replay(dataAccess);
	    
	    o.save();
	    // Verificar que se ejercita el comportamiento esperado 
	    verify(dataAccess);
	}
	
	@Test 
	public void calculateLineTotalsUsingMock() {
	    IShopDataAccess dataAccess = createStrictMock(IShopDataAccess.class);
	    // Especificar comportamiento esperado
	    expect(dataAccess.getProductPrice(1234)).andReturn(45.0);
	    expect(dataAccess.getProductPrice(2345)).andReturn(15.0);
	    // Crear mock para el comportamiento anterior 
	    replay(dataAccess);

	    Order o = new Order(6, dataAccess);
	    o.add(new OrderLine(o, 1234, 3));
	    o.add(new OrderLine(o, 2345, 2));

	    assertEquals(135, o.getLines().get(0).getTotal(), 0.01);
	    assertEquals(30, o.getLines().get(1).getTotal(), 0.01);
	    // Verificar que se ejercita el comportamiento esperado 
	    verify(dataAccess);
	}	
	
}
