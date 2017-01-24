package objects;
/**
 * File Name: Length.java 
 *
 * 
 * @author Chandra Rathina
 * @year 2015
 */

class Length {
  private static final IntUtil u = new IntUtil();
  
  private static int length_easy(int [] s, int target) {
    int loopCount = 0 ;
    int curr = target ;
    while(s[curr] != target){
      loopCount++;
      curr=s[curr];
    }
    return loopCount;
  }
  

    private static int length(int [] arr, int index) {
        //WRITE CODE HERE

        int origindex = index & 0xff; //use last 8 bits to store original value

        int bitIndex = (index >> 31) & 1; //use this bit for 1st time call vs recursion call

        int arrIndex = bitIndex>0?((index >>8) & 0xff):arr[origindex]; //to get the recursive index

        //base condition
        if ( arrIndex == origindex ) return 0;

        index = (1<<31) | (arr[arrIndex]<<8) | origindex;  //composite index which contains orig value, recur index

        return length(arr, index) + 1;

    }
  
  public static void testbed() {
    //CANNOT CHANGE BELOW
    int s[] = {5,1,0,4,2,3} ;
    int y = length_easy(s,3) ;
    System.out.println("length_easy y = " + y);
    u.myassert(y == 4) ;
    int b[] = {5,1,0,4,2,3} ;
    int x = length(s,3) ;
    System.out.println("length x = " + x);
    u.myassert(x == y) ;
    for (int i = 0; i < s.length; ++i) {
      u.myassert(s[i] == b[i]);
    }
    System.out.println("Assert passed");
  }
  
  public static void testbed1() {
    //CANNOT CHANGE BELOW
    int s[] = {5,1,0,4,2,3} ;
    int b[] = {5,1,0,4,2,3} ;
    int l = s.length ;
    for (int j = 0; j < l ; ++j) {
      System.out.println("---------------------j = " + j + " ------------------");
      int y = length_easy(s,j) ;
      System.out.println("length_easy y = " + y);
      int x = length(s,j) ;
      System.out.println("length x = " + x);
      u.myassert(x == y) ;
      for (int i = 0; i < s.length; ++i) {
        u.myassert(s[i] == b[i]);
      }
      System.out.println("---------------------Assert passed--------------------");
    }
  }
  
  public static void main(String[] args) {
    System.out.println("Length.java");
    testbed() ;
    testbed1() ;
  }
}