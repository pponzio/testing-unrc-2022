package testing.graph.ejercicio2;

// Introduction to Software Testing
// Authors: Paul Ammann & Jeff Offutt
// Chapter 7; page ??
// Can be run from command line
// See PrintPrimes.num for a numbered version.
// No JUnit tests at this time

/** *****************************************************
* Finds and prints n prime integers
* Jeff Offutt, Spring 2003
********************************************************* */
public class PrintPrimes
{
   static int [] primes = new int [100]; // The list of prime numbers.
   static int numPrimes;          // Number of primes found so far.

   private static boolean isDivisible (int i, int j)
   {
      if (j%i == 0)
         return true;
      else
         return false;
   }

   private static void computePrimes (int n)
   {
      int curPrime;           // Value currently considered for primeness
      boolean isPrime;        // Is curPrime prime?
    
      // Initialize 2 into the list of primes.
      primes [0] = 2;
      numPrimes = 1;
      curPrime  = 2;
      while (numPrimes < n)
      {
         curPrime++;  // next number to consider ...
         isPrime = true;
         for (int i = 0; i <= numPrimes-1; i++)
         {   // for each previous prime.
            if (isDivisible (primes[i], curPrime))
            {  // Found a divisor, curPrime is not prime.
               isPrime = false;
               break; // out of loop through primes.
            }
         }
         if (isPrime)
         {   // save it!
            primes[numPrimes] = curPrime;
            numPrimes++;
         }
      }  // End while
   
   }  // end computePrimes 
   
   public static void main (String []argv)
   {  // Driver method for printPrimes
      // Read an integer from standard input, call printPrimes()
      int integer = 0;
      if (argv.length != 1)
      {
         System.out.println ("Usage: java PrintPrimes v1 ");
         return;
      }
   
      try
      {
         integer = Integer.parseInt (argv[0]);
      }
      catch (NumberFormatException e)
      {
         System.out.println ("Entry must be a integer, using 1.");
         integer = 1;
      }
   
      computePrimes (integer);
      // Print all the primes out.
      for (int i = 0; i <= numPrimes-1; i++)
      {
         System.out.println ("Prime: " + primes[i]);
      }

   }
}
