package testing.parameterized.teoria;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;


public class CalcTestsParametrizados {
	
	@ParameterizedTest(name = "{index}: {0} + {1} = {2}")
	@CsvSource({ 
		"2, 3, 5",
		"3, 2, 5",
		"3, 3, 6",
	})	
	void testAdd(int a, int b, int expected) {
		int res = Calc.add(a, b);
		assertEquals(expected, res, "Calc sum incorrect");
	}
	
}