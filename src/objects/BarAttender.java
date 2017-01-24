package objects;
import java.util.Random;

/**
 * File Name: BarAttender.java 
 * Simulates Bar attender puzzle
 * 
 * @author Chandra Rathina
 * @year 2016
 */

class BarAttender{
  private int min; //Work in the range of min to max
  private int max;
  
  BarAttender(int min, int max){
    //WRITE CODE
      this.min = min;
      this.max = max;
  }

  private int guess(int g, boolean show) {
    //WRITE CODE
      int mid =  0, counter = 0;
      int min = this.min, max = this.max;
      if (g < 1) return -1;
      while ( max >= min) {
          mid = (min + max) / 2;
          counter++;
          if (g == mid) break;

          if (g < mid) max = mid - 1;

          if (g > mid) min = mid + 1;
      }
      return counter;
  }
  private static void test(int s, int b, int m, boolean useRandom,boolean show) {
    //CANNOT CHANGE CODE BELOW. MUST USE AS IS
    Random r = new Random() ;
    int min = 9999 ;
    int max = 0 ; 
    BarAttender h = new BarAttender(s,b);
    for (int i = 0; i < m; ++i) {
      int v = i + s ;
      if (useRandom) {
        v = RandomInt.getRandomInt(r,s,b); //This gives number between 1 to 1000000-1
      }
      int n = h.guess(v,show) ;
      if (n > max) {
        max = n;
      }
      if (n < min) {
        min = n ;
      }
    } 
    System.out.print("For numbers  between " + s + " to " +  b +  " ");
    if (useRandom) {
       System.out.print("(random numbers)") ;
    }else {
      System.out.print("(not random numbers)") ;
    }
    System.out.println(" the min guess is " + min + " max guess is " + max) ;
  }

  private static void testBench() { 
    //CANNOT CHANGE CODE BELOW. MUST USE AS IS
    test(1,10,10,false,true) ;
    test(1,1000000,1000000,false,false);
    test(1,1000000,1000,true,false);
  }

  public static void main(String[] args) {
    //CANNOT CHANGE CODE BELOW. MUST USE AS IS
    System.out.println("BarAttender.java");
    testBench();
    System.out.println("DONE");
  }
}

/* OUTPUT STARTS HERE

BarAttender.java
For numbers  between 1 to 10 (not random numbers) the min guess is 1 max guess is 4
For numbers  between 1 to 1000000 (not random numbers) the min guess is 1 max guess is 20
For numbers  between 1 to 1000000 (random numbers) the min guess is 10 max guess is 20
DONE

 */
