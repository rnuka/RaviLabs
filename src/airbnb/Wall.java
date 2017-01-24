package airbnb;

/**
 * Created by rnuka on 5/30/16.
 */
/*
You have 4 types of Lego™ blocks, of sizes (1 x 1 x 1), (1 x 1 x 2), (1 x 1 x 3), and
(1 x 1 x 4). Assume that you have an infinite number of blocks of each type. For
brevity, we can call these types, respectively, the 1-block, 2-block, 3-block and
4-block, or even (1), (2), (3) and (4).
Using these blocks, you want to make a wall of height N and width M. The wall
should be a solid continuous structure with no holes. The wall should be
structurally connected, so no straight vertical should exist that would allow the
wall to be separated in two without cutting one or more bricks.

Input:
The first line contains the number of test cases T. T test cases follow. Each case
contains two integers, N and M.
Output:
Output T lines, one for each test case, containing the number of ways to build
the wall.
As the numbers can be very large, output the result modulo 1,000,000,007.

Constraints:
1 ≤ T ≤ 100
1 ≤ N,M ≤ 1000

Sample Input:
4
2 2
3 2
2 3
4 4
Sample Output:
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;


public class Wall {
    //public method
    public long calculateWays(int height, int width){
        return numberOfWaysBeforeSplits(height,width)-numberOfWaysCanSplit(height, width);
    }

    //private method: calculate number of ways blocks can be arranged including vertical splits
    private long numberOfWaysBeforeSplits(int height, int width){

        //width or height cannot be negative
        if(width <1 || height <1)
            return 0;

        //in this case we cannot form a wall as there will be always vertical split
        if(height==1 && width>4)
            return 0;

        //otherwise calculate
        long curr=0;
        long prev1=0;
        long prev2=0;
        long prev3=0;
        long prev4=1;
        for(int i=1;i<=width; i++){
            curr = prev1+prev2+prev3+prev4;
            prev1 = prev2;
            prev2 = prev3;
            prev3 = prev4;
            prev4 = curr;
        }
        curr = (long)Math.pow(curr,height);
        return curr;
    }

    //private method: calculate how many ways a wall can be split vertically
    private long numberOfWaysCanSplit(int height, int width){
        //todo
        return 0L;
    }

    public static void main(String args[] ) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
        Wall s = new Wall();
        BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
        int i=0;
        int numberOfInputs=0;
        String input;
        while((input=br.readLine()) != null){
            if(i==0){
                numberOfInputs=Integer.parseInt(input);
            }else{

                int j=0;
                int height=0;
                int width = 0;

                for(String str : input.split(",")){
                    if(j==0){
                        height = Integer.parseInt(str);
                    }else{
                        width = Integer.parseInt(str);
                    }
                    j++;
                }
                //invoke function
                System.out.println("height="+height+" width="+width);
                s.calculateWays(height, width);
            }

            i++;
        }
    }
}
