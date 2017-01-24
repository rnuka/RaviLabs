package objects;

/**
 * File Name: Cstring.java 
 * Implements C String
 * 
 * @author rnuka
 * @year 2016
 */
/*
 * To compile you require: CharArray.java Cstring
 */

public class Cstring {
  private CharArray d; //Infinite array of char
  static IntUtil u = new IntUtil();
  //Cannot add any more data fields


  //Constructors
  public Cstring (Character c){
    d = new CharArray();
    d.set(0,c);
    d.set(1,'\0');
  }

  public Cstring (String s){
    int len = s.length();
    d = new CharArray(len+1);

    for (int i = 0; i < len; i++){
      d.set(i,s.charAt(i));
    }
    d.set(len,'\0');
  }

  public Cstring (){
    d = new CharArray(1);
    d.set(0,'\0');
  }

  //WRITE ALL FUNCTIONS SO THAT ALL TESTS WILL PASS
  public void append(Cstring s){
    int size = d.size();
    for(int i=0;i<=s.size();i++){
      d.set(size+i,s.get(i));
    }
  }


  public Cstring clone(){

    Cstring clone = new Cstring();
    clone.append(this);
    /*for(int i=0; i<=this.d.size(); i++){
      clone.d.set(i,this.d.get(i));
    }*/
    return clone;
  }



  public void append(String s){
    int size = d.size();
    for(int i=0; i<s.length(); i++){
      d.set(size+i,s.charAt(i));
    }
    d.set(d.size(),'\0');
  }

  public Cstring add(String s){
    Cstring t = clone();
    Cstring cs = new Cstring(s);
    t.append(cs);
    return t;
  }

  public Cstring add(Cstring s){
    Cstring t = clone();
    t.append(s);
    return t;
  }

  public void reverse(){
    this.d.reverse();
  }

  public void pLn(String s){
    System.out.print(s);
    d.pLn(0, d.size());
  }

  public boolean isEqual(Cstring t){

    if(t == null){
      return false;
    }

    for(int i=0; i<=t.size(); i++){
      if(this.get(i) != t.get(i)){
        return false;
      }
    }

    return true;
  }

  public int size(){
    return this.d.size();
  }

  public char get(int pos){
    return this.d.get(pos);
  }

  public void set(int pos, char c){
    this.d.set(pos,c);
  }


  //CANNOT CHANGE ANYTHING BELOW 
  private static void testBasic() {
    Cstring a = new Cstring('b') ;
    a.pLn("a = ") ;
    Cstring b = new Cstring('7') ;
    b.pLn("b = ") ;
    Cstring c = new Cstring("123456789012345678901234567890123456789012345678901234567890") ;
    c.pLn("c = ") ;
    Cstring d = c.clone() ;
    d.pLn("d = ") ;
    Cstring e = new Cstring("A quick brown fox jumped over a lazy dog") ;
    e.pLn("e = ") ;
    Cstring f = new Cstring("Gateman sees name garageman sees nametag") ;
    f.pLn("f =  ") ;
    f.reverse() ;
    f.pLn("f' = ") ;
  }
  
  private static void testAdd() {
    Cstring a = new Cstring("UCSC") ;
    Cstring b = new Cstring("Extension") ;
    Cstring c = a.add(b) ;
    a.pLn("a = ") ;
    b.pLn("b = ") ;
    c.pLn("c = ") ;
    Cstring d = c.add("USA") ;
    d.pLn("d = ") ;
    a.append(b) ;
    a.pLn("a+b = ") ;
    a.append("World") ;
    a.pLn("a+b+World = ") ;
  }
  
  private static void testEqual() {
    Cstring a = new Cstring("123456789012345678901234567890123456789012345678901234567890") ;
    a.pLn("a = ") ;
    Cstring b = new Cstring("123456789012345678901234567890123456789012345678901234567890") ;
    b.pLn("b = ") ;
    u.myassert(a.isEqual(b)) ;
    Cstring c = new Cstring("12345678901234567890123456789012345678901234567890123456789") ;
    c.pLn("c = ") ;
    u.myassert(a.isEqual(c) == false);
  }
  
  private static void testBench() {
    System.out.println("-----------Basic----------------");
    testBasic();
    System.out.println("-----------Addition----------------");
    testAdd() ;
    System.out.println("-----------Equal----------------");
    testEqual() ;
  }
  
  public static void main(String[] args) {
    System.out.println("Cstring.java");
    testBench();
    System.out.println("Done");
  }
}