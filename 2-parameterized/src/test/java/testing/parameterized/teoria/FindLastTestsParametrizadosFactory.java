package testing.parameterized.teoria;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class FindLastTestsParametrizadosFactory {

	@ParameterizedTest(name = "{index}: last {1} in {0} is in position {2}")
	@MethodSource("findLastArgsProvider")
	void findLastParamTest(int [] arr, int elem, int expected) {
		int result = EjemplosArray.findLast(arr, elem);
		assertEquals(expected, result);
	}
	
	static Stream<Arguments> findLastArgsProvider() {
	    return Stream.of(
	    		Arguments.of(new int[] {1,2,3}, 3, 2),
	    		Arguments.of(new int[] {1,3,3}, 3, 2),
	    		Arguments.of(new int[] {1,2,3}, 0, -1)
	    );
	}
	
}
