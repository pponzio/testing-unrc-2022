package tdd;

import java.util.LinkedList;
import java.util.List;

public class FizzBuzz {
	
	private Output output;
	
	public void setOutput(Output output) {
		this.output = output;
	}

	public String fizzbuzz(int i) {
		String res = "";

		if (i % 3 == 0 || isDigitOf(i, 3))
			res += "Fizz";
		if (i % 5 == 0 || isDigitOf(i, 5))
			res += "Buzz";
	
		if (res.equals(""))
			return new Integer(i).toString();
		else
			return res;
	}

	public boolean isDigitOf(int i, int d) {
		while (i > 0) {
			if (i % 10 == d)
				return true;
			i = i / 10;
		}
		
		return false;
	}

	public List<String> listFizzBuzz(int i, int j) {
		List<String> res = new LinkedList<>();
		for (int k = i; k <= j; k++) 
			res.add(fizzbuzz(k));
		return res;
	}
	
	// Pre: invocar setOutput
	public void printListFizzBuzz(int i, int j) {
		List<String> res = listFizzBuzz(i, j);
		for (String e: res) {
			//System.out.println(e);
			output.print(e);
		}
	}

	public static void main(String [] args) {
		FizzBuzz fb = new FizzBuzz();
		Output o = new ConsoleOutput();
		fb.setOutput(o);
		fb.printListFizzBuzz(1, 100);
	}
	
	
	
}
