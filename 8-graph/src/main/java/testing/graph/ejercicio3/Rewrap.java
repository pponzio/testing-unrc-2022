package testing.graph.ejercicio3;

// Introduction to Software Testing
// Authors: Paul Ammann & Jeff Offutt
// Chapter 7; page ??
// Can be run from command line
// See FmtRewrap.num for a numbered version.
// No JUnit tests at this time.

/** *****************************************************
*  Rewraps the string (Similar to the Unix fmt).
*  Given a string S, eliminate existing CRs and add CRs to the
*  closest spaces before column N.  Two CRs in a row are considered to
*  be "hard CRs" and are left alone.
********************************************************* */
import java.io.*;

public class Rewrap
{
   static final char CR = '\n';
   static final int inWord      = 0;
   static final int betweenWord = 1;
   static final int lineBreak   = 2;
   static final int crFound     = 3;
   static private String fmtRewrap (String S, int N)
   {
      int state = betweenWord;
      int lastSpace = -1;
      int col = 1;
      int i = 0;
      char c;
   
      char SArr [] = S.toCharArray();
      while (i < S.length())
      {
         c = SArr[i];
         col++;
         if (col >= N)
            state = lineBreak;
         else if (c == CR)
            state = crFound;
         else if (c == ' ')
            state = betweenWord;
         else
            state = inWord;
         switch (state)
         {
         case betweenWord:
            lastSpace = i;
            break;
    
         case lineBreak:
            SArr [lastSpace] = CR;
            col = i-lastSpace;
            break;
    
         case crFound:
            if (i+1 < S.length() && SArr[i+1] == CR)
            {
               i++; // Two CRs => hard return
               col = 1;
            }
            else
               SArr[i] = ' ';
            break;
    
         case inWord:
         default:
            break;
         }  // end switch
           i++;
      }  // end while
      S = new String (SArr) + CR;
      return (S);
   }
   
   public static void main (String []argv)
   {  // Driver method for fmtRewrap
      // Read an array and an integer from standard input, call fmtRewrap()
      int integer = 0;
      int []inArr = new int [argv.length];
      if (argv.length != 1)
      {
         System.out.println ("Usage: java FmtRewrap v1 ");
         return;
      }
   
      System.out.println ("Enter an integer: ");
      integer = getN();
   
      System.out.println ("The Result String is: " + fmtRewrap (argv[0], integer));
   }
   
   // ====================================
   // Read (or choose) an integer
   private static int getN ()
   {
      int inputInt = 1;
      BufferedReader in = new BufferedReader (new InputStreamReader (System.in));
      String inStr;
   
      try
      {
         inStr    = in.readLine ();
         inputInt = Integer.parseInt(inStr);
      }
      catch (IOException e)
      {
         System.out.println ("Could not read input, choosing 1.");
      }
      catch (NumberFormatException e)
      {
         System.out.println ("Entry must be a number, choosing 1.");
      }
   
      return (inputInt);
   }  // end getN
}
