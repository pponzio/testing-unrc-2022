// Introduction to Software Testing
// Authors: Paul Ammann & Jeff Offutt

package testing.junit.practico.ejercicio1;

public class Ejercicio1 {

	/**
	 * Find last index of element
	 * 
	 *  @param x array to search
	 *  @param y value to look for
	 *  @return last index of y in x; -1 if absent
	 *  @throws NullPointerException if x is null
	 */
	public static int findLast (int[] x, int y)
	{ 
		// As the example in the book points out, this loop should end at 0.
		for (int i=x.length-1; i > 0; i--)
		{
			if (x[i] == y) 
			{
				return i;
			}
		}
		return -1;
	}

	/**
	 * Find LAST index of zero
	 *
	 * @param x array to search
	 * @return index of last 0 in x; -1 if absent
	 * @throws NullPointerException if x is null
	 */
	public static int lastZero (int[] x)
	{
		for (int i = 0; i < x.length; i++)
		{
			if (x[i] == 0)
			{
				return i;
			}
		}
		return -1;
	}

	/**
	 * Counts zeroes in an array
	 *
	 * @param x  array to count zeroes in
	 * @return   number of occurrences of 0 in x
	 * @throws   NullPointerException if x is null
	 */
	public static int numZero (int[] x)
	{  
		int count = 0;

		// As example in the book points out, this loop should start at 0.
		// Better yet, is should be a foreach loop,
		// which eliminates the possibility of the fencepost fault:
		// for (int i:x) { if (x==0) count++; }
		for (int i = 1; i < x.length; i++)
		{
			if (x[i] == 0) count++;
		}
		return count;
	}

	/**
	 * Count odd or positive elements in an array
	 *
	 * @param x array to search
	 * @return count of odd or positive elements in x
	 * @throws NullPointerException if x is null
	 */
	public static int oddOrPos (int[] x)
	{  // Effects:  if x is null throw NullPointerException
		// else return the number of elements in x that
		//      are either odd or positive (or both)
		int count = 0;

		for (int i = 0; i < x.length; i++)
		{
			if (x[i]%2 == 1 || x[i] > 0)
			{
				count++;
			}
		}
		return count;
	}

	/** 
	 * Counts positive elements in array
	 *
	 * @param x array to search
	 * @return number of positive elements in x
	 * @throws NullPointerException if x is null
	 */
	public static int countPositive (int[] x)
	{
		int count = 0;

		for (int i=0; i < x.length; i++)
		{
			if (x[i] >= 0)
			{
				count++;
			}
		}
		return count;
	}
	
}
