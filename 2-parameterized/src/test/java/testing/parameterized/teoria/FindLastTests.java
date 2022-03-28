package testing.parameterized.teoria;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import testing.parameterized.teoria.EjemplosArray;

public class FindLastTests {

	@Test
	void findLastTest1() {
		int [] arr = {1,2,3};
		int elem = 3;
		int result = EjemplosArray.findLast(arr, elem);
		assertEquals(2, result);
	}
	
	@Test
	void findLastTest2() {
		int [] arr = {1,3,3};
		int elem = 3;
		int result = EjemplosArray.findLast(arr, elem);
		assertEquals(2, result);
	}	
	
	@Test
	void findLastTest3() {
		int [] arr = {1,2,3};
		int elem = 0;
		int result = EjemplosArray.findLast(arr, elem);
		assertEquals(-1, result);
	}
	
}
