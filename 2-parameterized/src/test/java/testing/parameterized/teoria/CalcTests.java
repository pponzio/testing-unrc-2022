package testing.parameterized.teoria;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

//Introduction to Software Testing
//Authors: Paul Ammann & Jeff Offutt


public class CalcTests
{
	
	@Test 
	void testAdd1() {
		int a = 2;
		int b = 3;
		int res = Calc.add(a, b);
		assertEquals(5, res, "Calc sum incorrect");
	}
	
	@Test 
	void testAdd2() {
		int a = 3;
		int b = 2;
		int res = Calc.add(a, b);
		assertEquals(5, res, "Calc sum incorrect");
	}
	
	@Test 
	void testAdd3() {
		int a = 3;
		int b = 3;
		int res = Calc.add(a, b);
		assertEquals(6, res, "Calc sum incorrect");
	}
	
}