package airbnb;

/**
 * Created by rnuka on 6/4/16.
 */
/*
Number of paths in a matrix
You are given a 2-Dimensional array with M rows and N columns. You are
initially positioned at (0,0) which is the top-left cell in the array. You are allowed
to move either right or downwards. The array is filled with 1's and 0's. A 1
indicates that you can move through that cell, a 0 indicates that you cannot
move through the cell. Given a function numberOfPaths which takes in the
above 2-D array, return the number of paths from the top-left cell to the
bottom-right cell (i.e. (0,0) to (M-1,N-1)).
Your task is to complete the body of the function and return a single integer
denoting the number of paths mentioned above. Since the answer can be large,
you have to return the number of paths modulo 1,000,000,007, i.e. ans % (10 +
7).

Constraints
1 ≤ N, M ≤ 1,000

Sample Input #1:
3 4
1 1 1 1
1 1 1 1
1 1 1 1

Output #1:
10

Explanation #1:
None of the values in the array is zero.

Counting all possible paths from (0,0) to

(2,3) gives us 10 possible paths as follows:

one path that goes all the way across top row (0,3)
Two paths that go right to cell (0,2) then turn down.
Three paths that go right to cell (0,1) then turn down.
Four paths that start by going down to cell (1,0).


Input #2:
2 2
1 1
0 1

Output #2:
1

Explanation #2:
You can move only right from the top-left cell: (0,0) to (0,1). After that, your only
move is to (1,1). Hence only 1 path.

*
* */
public class PathCounts {

    static int numberOfPaths(int [][]a,int M,int N) {

        if(a==null || M<=0 || N<=0){
            return 0;
        }

        if(a[M-1][N-1]==0){
            return 0;
        }



        int[][] pathCounter = new int[M][N];

        for(int i=M-1; i>=0; i--){
            for(int j=N-1; j>=0; j--){

                //target
                if(i==M-1 && j==N-1){
                    pathCounter[i][j]=1;
                }else {

                    int leftCount = 0;
                    int downCount = 0;
                    if (j< N-1){
                        leftCount=pathCounter[i][j+1];
                    }

                    if (i< M-1){
                        downCount=pathCounter[i+1][j];
                    }
                    pathCounter[i][j]=leftCount+downCount;

                    //if wall
                    if(a[i][j]==0){
                        pathCounter[i][j]=0;
                    }
                }
            }
        }

        return pathCounter[0][0];
    }

   public static void myasset(boolean x){
       if(!x){
           throw new IllegalArgumentException("Assert Failed");
       }
   }

    public static void testbasic1(){
        int[][] input = {{1,1,1,1},{1,1,1,1},{1,1,1,1}};
        int totalPaths = numberOfPaths(input,3,4);
        System.out.println("totalpaths="+totalPaths);
        myasset(totalPaths==10);

    }


    public static void testbasic2(){
        int[][] input = {{1,1,1},{1,0,1},{1,1,1}};
        int totalPaths = numberOfPaths(input,3,3);
        System.out.println("totalpaths="+totalPaths);
        myasset(totalPaths==2);
    }

    public static void testbasic3(){
        int[][] input = {{1,1,1,0,1},{1,0,1,0,1},{1,1,1,1,1},{1,0,1,1,0},{1,1,1,1,1}};
        int totalPaths = numberOfPaths(input,5,5);
        System.out.println("totalpaths="+totalPaths);
        myasset(totalPaths==7);
    }

    public static void testsinglerow(){
        int[][] input = {{1,1,1}};
        int totalPaths = numberOfPaths(input,1,3);
        System.out.println("totalpaths="+totalPaths);
        myasset(totalPaths==1);
    }

    public static void testsinglecol(){
        int[][] input = {{1},{1},{1}};
        int totalPaths = numberOfPaths(input,3,1);
        System.out.println("totalpaths="+totalPaths);
        myasset(totalPaths==1);
    }

    public static void testbed(){
        testbasic1();
        testbasic2();
        testsinglerow();
        testsinglecol();
        testbasic3();
    }

    public static void main(String args[]){
        testbed();
    }


}
