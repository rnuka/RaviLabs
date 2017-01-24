package practice.coding.dynamicProgramming;

import java.util.Arrays;

/*

optimal substructure:

       |-  0 if p = 0
C[p] = |
       |_  min  { 1 + C[p − di] } if p > 0
             i:di≤p

* */
public class MinimalCoinChange {


    //recursive approach.
    public int minimalChangeRecursive(int[] denom, int k){
        if(k<=0){
            return 0;
        }

        int min = Integer.MAX_VALUE;
        for(int i=0; i<denom.length; i++){
            if(denom[i]<=k){
                int count = 1+minimalChangeRecursive(denom,k-denom[i]);
                if(count < min){
                    min = count;
                }
            }
        }
        return min;
    }


    /*DP Approach*/
    public int minimalChangeDp(int[] denom, int k) {

        /* Dp approach call */
        int[][] dp = new int[denom.length+1][k+1];

        //initialize
        for(int[] currArray : dp){
            Arrays.fill(currArray, -1);
        }

        return minimalChangeDp(denom, dp, denom.length-1, k);
    }

    private int minimalChangeDp(int[] denom, int[][] dp, int currentDenomIndex, int currentChange){
        if(currentChange<=0){
            return 0;
        }

        //check if previously calculated
        if(dp[currentDenomIndex][currentChange] != -1){
            return dp[currentDenomIndex][currentChange];
        }

        //Otherwise calculate min change
        int min = Integer.MAX_VALUE;
        //for(int i=0; i<denom.length; i++){
        for(int i=0; i<=currentDenomIndex; i++){
            if(denom[i] <= currentChange){
                int count = 1+minimalChangeDp(denom, dp, i, (currentChange - denom[i]));
                if(count < min){
                    min = count;
                }
            }
        }

        System.out.println("for denomination until ::"+denom[currentDenomIndex]+" to get change::"+currentChange+" need ::"+min);

        //update dp
        if(min==Integer.MAX_VALUE){
            min=0;
        }
        dp[currentDenomIndex][currentChange] = min;

        return dp[currentDenomIndex][currentChange];
    }

    public static void main(String args[]){
        MinimalCoinChange m = new MinimalCoinChange();
        int[] denom = {2,5,10,25};
        int k = 1;
        System.out.println("Minimal change to get "+k+" cents is: "+m.minimalChangeRecursive(denom, k));
        System.out.println("Minimal change using DP to get "+k+" cents is: "+m.minimalChangeDp(denom, k));
    }
}
