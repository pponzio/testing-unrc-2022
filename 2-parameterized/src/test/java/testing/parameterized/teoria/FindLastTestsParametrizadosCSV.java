package testing.parameterized.teoria;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;


public class FindLastTestsParametrizadosCSV {

	@ParameterizedTest(name = "{index}: last {1} in {0} is in position {2}")
	@CsvSource({ 
		"'[1,2,3]',	3,	2",
		"'[1,3,3]',	3,	2",
		"'[1,2,3]',	0,	-1"
	})
	void findLastParamTest(@ConvertWith(ArrayFromString.class) int [] arr, 
			int elem, int expected) {
		int result = EjemplosArray.findLast(arr, elem);
		assertEquals(expected, result);
	}

}
