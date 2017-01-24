package objects;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * File Name: BigUnsignedNumber.java 
 * Infinite capacity Unsigned Number
 *
 * @author
 * @year 2016
 */
/*
 * To compile you require: BigUnsignedNumber.java CharArray.java Cstring IntUtil.java
 */

class BigUnsignedNumber {
  private Cstring d; //data
  static IntUtil u = new IntUtil();
  //Cannot add any more data fields

  //Constructors
  public BigUnsignedNumber(int n){
    this.d = new Cstring(String.valueOf(n));
  }

  public BigUnsignedNumber(char n){
    this.d = new Cstring(n);
  }

  public BigUnsignedNumber(String n){
    this.d = new Cstring(n);
  }

  public BigUnsignedNumber(){
    this.d = new Cstring();
  }


  //WRITE ALL FUNCTIONS SO THAT ALL TESTS WILL PASS

  public void pLn(String s){
    this.d.pLn(s);
  }

  public BigUnsignedNumber clone(){
    BigUnsignedNumber clone = new BigUnsignedNumber();
    clone.d = this.d.clone();
    return clone;
  }

  public void append(BigUnsignedNumber s){
    this.d.append(s.d);
  }

  public int size(){
    return this.d.size();
  }

  public int get(int pos){
    return Character.getNumericValue(this.d.get(pos));
  }

  public void set(int pos, char c){
    this.d.set(pos, c);
  }

  public void set(int pos, int c){
    char ch = (char)(c+48);
    set(pos, ch);
  }

  public Boolean isEqual(BigUnsignedNumber b){

    //null case
    if(b == null){
      return false;
    }

    //unequal lengths
    if(this.size() != b.size()){
      return false;
    }

    //equal lengths
    for(int i=0; i<b.size(); i++){
      if(this.get(i) != b.get(i)){
        return false;
      }
    }

    return true;
  }

  public Boolean isEqual(int a){
    BigUnsignedNumber that = new BigUnsignedNumber(a);
    return isEqual(that);
  }

  public Boolean isEqual(String s){
    BigUnsignedNumber that = new BigUnsignedNumber(s);
    return isEqual(that);
  }

  public BigUnsignedNumber add(BigUnsignedNumber b){
    int carry = 0;
    BigUnsignedNumber result = new BigUnsignedNumber();
    int bSize = b.size();
    int aSize = this.size();
    int rSize = 0;

    while(bSize>0 && aSize >0){
      int currSum = this.get(aSize-1)+b.get(bSize-1)+carry;
      carry = currSum > 9 ? 1 : 0;
      result.d.set(rSize++,(char)(currSum%10+48));
      bSize--;
      aSize--;

    }

    while(aSize > 0){
      int currSum = this.get(aSize-1)+carry;
      result.d.set(rSize++,(char)(currSum%10+48));
      aSize--;
    }

    while(bSize > 0){
      int currSum = b.get(bSize-1)+carry;
      carry = currSum > 9 ? 1 : 0;
      result.d.set(rSize++,(char)(currSum%10+48));
      bSize--;
    }

    if(carry > 0){
      result.d.set(rSize++,'1');
    }

    result.d.set(rSize,'\0');

    result.d.reverse();
    return result;
  }


  public BigUnsignedNumber mult(BigUnsignedNumber b){
    BigUnsignedNumber c = new BigUnsignedNumber();
    int cIndex = 0;
    int offsetIndex = 0;
    int carry =0;

    for(int i=b.size()-1; i>=0;i--) {
      int pos =0;
      for (int j = this.size()-1; j >= 0; j--){
        int temp = (b.get(i)*this.get(j)+carry);
        carry = temp > 9 ? temp/10 : 0;
        temp %=10;
        cIndex = offsetIndex+pos;
        ++pos;
        if(c.get(cIndex)>=0){
          temp = temp+c.get(cIndex);
          carry = temp > 9 ? (temp/10+carry) : carry;
          temp %=10;
        }
        c.set(cIndex++, (char) (temp + 48));
      }
      if(carry>0){
        c.d.set(cIndex++,(char)(carry+48));
        carry = 0;
      }
      ++offsetIndex;
    }

    c.d.set(cIndex, '\0');
    c.d.reverse();
    return c;
  }

  //tail recursion approach of factorial
  public static BigUnsignedNumber factorial(int n){
    BigUnsignedNumber sum = new BigUnsignedNumber(1);
    return fact(n, sum);
  }

  private static BigUnsignedNumber fact(int n, BigUnsignedNumber sum){
    if(n == 1)
      return sum;
    BigUnsignedNumber bigN = new BigUnsignedNumber(n);
    return fact(n-1, sum.mult(bigN));
  }



  //CANNOT CHANGE ANYTHING BELOW


  private static void test1() {
    BigUnsignedNumber b = new BigUnsignedNumber(10);
  }

  private static void testBench() {
    System.out.println("------------test1---------------------");
    test1();
  }

  public static void main(String[] args) {
    System.out.println("BigUnsignedNumber.java");
    testBench();
    System.out.println("Done");
  }
}