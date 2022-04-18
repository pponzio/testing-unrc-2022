package tdd;

public class FizzBuzz {

	public static String fizzbuzz(int i) {
		if (i % 3 == 0 && i % 5 == 0)
			return "FizzBuzz";
		if (i % 5 == 0)
			return "Buzz";
		if (i % 3 == 0)
			return "Fizz";
		
		return new Integer(i).toString();
	}

}
