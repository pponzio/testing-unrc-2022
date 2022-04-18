package tdd;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;


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
		"13, Fizz",
		"31, Fizz",
		"52, Buzz",
		"51, FizzBuzz",
		"35, FizzBuzz",
	})
	void fizzBuzzParamTest(int i, String expected) {
		String res = FizzBuzz.fizzbuzz(i);
		assertThat(res).isEqualTo(expected);
	}
	
	@Test
	void threeIsADigitOfThirtyOne() {
		boolean res = FizzBuzz.isDigitOf(31, 3);
		assertThat(res).isTrue();
	}
	
	@Test
	void threeIsADigitOfTwentyOne() {
		boolean res = FizzBuzz.isDigitOf(21, 3);
		assertThat(res).isFalse();
	}
	
	@Test
	void threeIsADigitOfIsTrue() {
		boolean res = FizzBuzz.isDigitOf(310, 3);
		assertThat(res).isTrue();
	}
	
	@Test
	void threeIsADigitOfThree() {
		boolean res = FizzBuzz.isDigitOf(3, 3);
		assertThat(res).isTrue();
	}
	
	@Test
	void sixIsNotADigitOfThree() {
		boolean res = FizzBuzz.isDigitOf(6, 3);
		assertThat(res).isFalse();
	}
	
	@Test
	void sevenIsNotADigitOfThree() {
		boolean res = FizzBuzz.isDigitOf(7, 3);
		assertThat(res).isFalse();
	}
	
	@Test
	void fiveIsADigitOfFive() {
		boolean res = FizzBuzz.isDigitOf(5, 5);
		assertThat(res).isTrue();
	}
	
	@Test
	void fiveIsNotADigitOfSeven() {
		boolean res = FizzBuzz.isDigitOf(7, 5);
		assertThat(res).isFalse();
	}
	
	@Test
	void fiveIsADigitOfFifteen() {
		boolean res = FizzBuzz.isDigitOf(15, 5);
		assertThat(res).isTrue();
	}
	
	@Test
	void ZeroIsADigitOfTeen() {
		boolean res = FizzBuzz.isDigitOf(10, 0);
		assertThat(res).isTrue();
	}
	
	@Test
	void listFizzBuzzOneToFive() {
		List<String> res = FizzBuzz.listFizzBuzz(1, 5);
		assertThat(res).containsExactly("1", "2", "Fizz", 
				"4", "Buzz");
	}
	
	
	@Test
	void listFizzBuzzOneToTen() {
		List<String> res = FizzBuzz.listFizzBuzz(1, 10);
		assertThat(res).containsExactly("1", "2", "Fizz", 
				"4", "Buzz", "Fizz", "7", "8", "Fizz", "Buzz");
	}
	
	
}
