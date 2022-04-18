package tdd;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;


public class TestFizzBuzz {

	@ParameterizedTest
	@CsvSource({
		"15, FizzBuzz",
		"30, FizzBuzz",
		"4, 4",
		"2, 2",
		"6, Fizz",
		"3, Fizz",
		"5, Buzz",
		"10, Buzz",
	})
	void fizzBuzzParamTest(int i, String expected) {
		String res = FizzBuzz.fizzbuzz(i);
		assertThat(res).isEqualTo(expected);
	}
	
	
	
}
