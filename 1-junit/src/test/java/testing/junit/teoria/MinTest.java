//Introduction to Software Testing
//Authors: Paul Ammann & Jeff Offutt

package testing.junit.teoria;


import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

import java.util.*;

public class MinTest
{
   private List<String> list;   // Test fixture

   @BeforeEach      // Set up - Called before every test method.
   public void setUp() {
      list = new ArrayList<String>();
   }

   @AfterEach      // Tear down - Called after every test method.
   public void tearDown() {
      list = null;  // redundant in this example!
   }

   @Test
   public void testForNullList() {
      list = null;
      try {
         Min.min (list);
      } catch (NullPointerException e) {
         return;
      }
      fail ("NullPointerException expected");
   }

   // assertThrows is now the preferred mechanism for testing exceptions
   // note the lambda expression in the assertion
   @Test 
   public void testForNullElement() {
      list.add (null);
      list.add ("cat");
      assertThrows(NullPointerException.class, () -> Min.min (list));
   }

   @Test
   public void testForSoloNullElement() {
      list.add (null);
      assertThrows(NullPointerException.class, () -> Min.min (list));
   }

   @Test
   @SuppressWarnings ("unchecked")
   public void testMutuallyIncomparable() {
      List list = new ArrayList();
      list.add ("cat");
      list.add ("dog");
      list.add (1);
      assertThrows(ClassCastException.class, () -> Min.min (list));
   }

   @Test
   public void testEmptyList() {
      assertThrows(IllegalArgumentException.class, () -> Min.min (list));
   }
   
   @Test
   public void testSingleElement() {
      list.add ("cat");
      Object obj = Min.min (list);
      assertTrue (obj.equals ("cat"), "Single Element List");
   }

   @Test
   public void testDoubleElement() {
      list.add ("dog");
      list.add ("cat");
      Object obj = Min.min (list);
      assertTrue (obj.equals ("cat"), "Double Element List");
   }

}