package practice.coding.arrays;

/*
Given a 2d grid map of '1' s (land) and '0' s (water), count the number of islands. An island is surrounded by water and
 is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all
 surrounded by water.

Example 1:
----------
Input:
        11110
        11010
        11000
        00000

Output: 1

Example 2:
----------
Input:
        11000
        11000
        00100
        00011
Output: 3

 */
public class NumberOfIslands {
    public int countIslands(int[][] input){
        if (input == null){
            return 0;
        }

        int[][] dp = new int[input.length+1][input[0].length+1];

        //populate dp with .
        for(int i=1;i<dp.length;i++){
            for(int j=1;j<dp[0].length;j++){
                dp[i][j]=input[i-1][j-1];
            }
        }

        int count=1;

        for(int i=1; i<dp.length; i++){
            for(int j=1; j<dp[0].length;j++){
                if(dp[i][j]==1){
                    //existing island
                    if(dp[i-1][j]>0 || dp[i][j-1]>0){
                        dp[i][j]= Math.max(dp[i-1][j],dp[i][j-1]);
                    }else{ //new island
                        dp[i][j]=count++;
                    }
                }
            }
        }
        return count-1;
    }

    public void testcase2(){
        int[][] input = {{1,1,0,0,0},
                         {1,1,0,0,0},
                         {0,0,1,0,0},
                         {0,0,0,1,1}};
        System.out.println("Number of islands ::"+countIslands(input));
    }

    public void testcase1(){
        int[][] input = {{1,1,1,1,0},
                         {1,1,0,1,0},
                         {1,1,0,0,0},
                         {0,0,0,0,0}};
        System.out.println("Number of islands ::"+countIslands(input));
    }

    public void testbed(){
        //testcase1();
        testcase2();
    }

    public static void main(String args[]){
        NumberOfIslands n = new NumberOfIslands();
        n.testbed();
    }
}
