package tdd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

import static org.easymock.EasyMock.*;

import java.util.List;


public class TestFizzBuzz {
	
	public FizzBuzz fizzbuzz;
	
	@BeforeEach
	void setup() {
		fizzbuzz = new FizzBuzz();
	}
	

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
		String res = fizzbuzz.fizzbuzz(i);
		assertThat(res).isEqualTo(expected);
	}
	
	@Test
	void threeIsADigitOfThirtyOne() {
		boolean res = fizzbuzz.isDigitOf(31, 3);
		assertThat(res).isTrue();
	}
	
	@Test
	void threeIsADigitOfTwentyOne() {
		boolean res = fizzbuzz.isDigitOf(21, 3);
		assertThat(res).isFalse();
	}
	
	@Test
	void threeIsADigitOfIsTrue() {
		boolean res = fizzbuzz.isDigitOf(310, 3);
		assertThat(res).isTrue();
	}
	
	@Test
	void threeIsADigitOfThree() {
		boolean res = fizzbuzz.isDigitOf(3, 3);
		assertThat(res).isTrue();
	}
	
	@Test
	void sixIsNotADigitOfThree() {
		boolean res = fizzbuzz.isDigitOf(6, 3);
		assertThat(res).isFalse();
	}
	
	@Test
	void sevenIsNotADigitOfThree() {
		boolean res = fizzbuzz.isDigitOf(7, 3);
		assertThat(res).isFalse();
	}
	
	@Test
	void fiveIsADigitOfFive() {
		boolean res = fizzbuzz.isDigitOf(5, 5);
		assertThat(res).isTrue();
	}
	
	@Test
	void fiveIsNotADigitOfSeven() {
		boolean res = fizzbuzz.isDigitOf(7, 5);
		assertThat(res).isFalse();
	}
	
	@Test
	void fiveIsADigitOfFifteen() {
		boolean res = fizzbuzz.isDigitOf(15, 5);
		assertThat(res).isTrue();
	}
	
	@Test
	void ZeroIsADigitOfTeen() {
		boolean res = fizzbuzz.isDigitOf(10, 0);
		assertThat(res).isTrue();
	}
	
	@Test
	void listfizzbuzzOneToFive() {
		List<String> res = fizzbuzz.listFizzBuzz(1, 5);
		assertThat(res).containsExactly("1", "2", "Fizz", 
				"4", "Buzz");
	}
	
	
	@Test
	void listfizzbuzzOneToTen() {
		List<String> res = fizzbuzz.listFizzBuzz(1, 10);
		assertThat(res).containsExactly("1", "2", "Fizz", 
				"4", "Buzz", "Fizz", "7", "8", "Fizz", "Buzz");
	}
	
	@Test
	void printListFizzBuzzOnetoFive() {
		Output o = createStrictMock(Output.class);
		o.print("1");
		o.print("2");
		o.print("Fizz");
		o.print("4");
		o.print("Buzz");
		replay(o);
		fizzbuzz.setOutput(o);
		
		fizzbuzz.printListFizzBuzz(1, 5);
		verify(o);
	}
	
	
	
}
