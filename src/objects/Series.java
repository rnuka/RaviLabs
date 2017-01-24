package objects;
import java.math.BigInteger;
import  java.text.DecimalFormat;
/**
 * File Name: Series.java 
 * 
 * @author CHANDRA RATHINA
 * @year 2016
 */

class Series {
  private static final IntUtil u = new IntUtil();
  
  
  private static void testLog(int start, int end, int incr) {
    //WRITE CODE
      DecimalFormat df = new DecimalFormat("#.00000");

      for (int i = start; i <= end; i = i + incr){
          System.out.print( "\t" + i );
          System.out.print("\t" + df.format( Math.log10(i) / Math.log(10) )  );
          System.out.print("\t\t" + df.format( Math.log(i) / Math.log(2) ));
          System.out.print("\t\t" + df.format( Math.log(i) ) );
          System.out.println();
      }

  }

  private static void testLog() {
    System.out.println("    n  base10     base2     base e") ;
    testLog(1,10,1) ;
    testLog(10,100,10) ; 
    testLog(100,1000,100) ;
    testLog(1000,10001,9000) ;
  }
  
  /*
   * 1 + 1/2 + 1/4 + 1/8 + 1/16 +... + = 2
   */
  private static void seriesConvergesAbsolutely() { 
    //WRITE CODE HERE for n = 100
      double sum = 0;
      for (double i = 1; i <= 100; i++){
          sum = sum + ( 1.0d / Math.pow(2,i) );
      }
      System.out.println("seriesConvergesAbsolutely = " + (sum+1.0d) );
  }
  
  /*
   * 1 + 1/2 + 1/3 + 1/4 + 1/5 + .. = 
   */
  private static void harmonicSeries() {
    //WRITE CODE HERE for n = 100
      double sum = 0;
      for (double i = 1; i <= 100; i++){
          sum = sum + (1.0/i);
      }
      System.out.print("harmonicSeries = " + sum );
      System.out.println(" = log(100) + 0.57721566 = " + (Math.log(100) + 0.57721566) );
  }
  
  private static void chess() {
    //WRITE CODE
      Long sum =  new Long(0); //=  new BigInteger("0");

      for (int i = 0; i < 63; i++ ){
          sum += (long)Math.pow(2,i);
      }
      BigInteger squares_1_to_63 = new BigInteger(sum.toString());

      Long square64 = new Long( (long)Math.pow(2,63));

      BigInteger square_64 = new BigInteger(square64.toString());

      System.out.println( "Chess = " + squares_1_to_63.add(square_64).toString());

  }
  
  private static void testbed() {
    testLog();
    seriesConvergesAbsolutely();
    harmonicSeries() ;
    chess() ;
  }
  
  public static void main(String[] args) {
    System.out.println("Series.java");
    testbed();
    System.out.println("Done");
  }
}

/* OUTPUT STARTS HERE

Series.java
    n  base10     base2     base e
	1	.00000		.00000		.00000
	2	.13074		1.00000		.69315
	3	.20721		1.58496		1.09861
	4	.26147		2.00000		1.38629
	5	.30356		2.32193		1.60944
	6	.33795		2.58496		1.79176
	7	.36702		2.80735		1.94591
	8	.39221		3.00000		2.07944
	9	.41442		3.16993		2.19722
	10	.43429		3.32193		2.30259
	10	.43429		3.32193		2.30259
	20	.56503		4.32193		2.99573
	30	.64151		4.90689		3.40120
	40	.69577		5.32193		3.68888
	50	.73785		5.64386		3.91202
	60	.77224		5.90689		4.09434
	70	.80132		6.12928		4.24850
	80	.82650		6.32193		4.38203
	90	.84872		6.49185		4.49981
	100	.86859		6.64386		4.60517
	100	.86859		6.64386		4.60517
	200	.99932		7.64386		5.29832
	300	1.07580		8.22882		5.70378
	400	1.13006		8.64386		5.99146
	500	1.17215		8.96578		6.21461
	600	1.20654		9.22882		6.39693
	700	1.23561		9.45121		6.55108
	800	1.26080		9.64386		6.68461
	900	1.28301		9.81378		6.80239
	1000	1.30288		9.96578		6.90776
	1000	1.30288		9.96578		6.90776
	10000	1.73718		13.28771		9.21034
seriesConvergesAbsolutely = 2.0
harmonicSeries = 5.187377517639621 = log(100) + 0.57721566 = 5.182385845988092
Chess = 18446744073709551614
Done

 */