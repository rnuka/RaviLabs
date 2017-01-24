package practice.coding.dynamicProgramming;

/*

Given a value N, if we want to make change for N cents, and we have infinite supply of
each of S = { S1, S2, .. , Sm} valued coins, how many ways can we make the change?
The order of coins doesn’t matter.

Example-1:
----------
For N = 4 and S = {1,2,3}, there are four solutions: {1,1,1,1},{1,1,2},{2,2},{1,3}.
So output should be 4.

Example-2:
---------
For N = 10 and S = {2, 5, 3, 6},
there are five solutions: {2,2,2,2,2}, {2,2,3,3}, {2,2,6}, {2,3,5} and {5,5}. So the output should be 5.


Algorithm:

Optimal Substructure:

To count total number solutions, we can divide all set solutions in two sets.
1) Solutions that do not contain mth coin (or Sm).
2) Solutions that contain at least one Sm.
Let count(S[], m, n) be the function to count the number of solutions,
 then it can be written as sum of count(S[], m-1, n) and count(S[], m, n-Sm).

Therefore, the problem has optimal substructure property as the problem can be solved using solutions to subproblems.

 */

public class CoinChangeTotalWays {

    public static int totalWays(int[] denom, int m, int n){

        //Important: change of 0 cents is 1 way that is empty denomination
        if(n==0) {
            return 1;
        }

        //negative denomination index or negative target cents is 0
        if(m<0 || n <0){
            return 0;
        }

        //if only one denomination i.e. 0th index and that matches with target n cents then take it
        if(m==0 && denom[m]==n){
            return 1;
        }

        return(totalWays(denom, m-1, n)+totalWays(denom,m,(n-denom[m])));

    }

    public static void main(String[] args){
        int[] denom = {1,2,3};
        System.out.println("total ways of coin change to get 6 cents::"+totalWays(denom,denom.length-1,6));
    }
}
