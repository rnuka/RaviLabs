package practice.coding.dynamicProgramming;

/*
Question: Given a rope of length n meters, cut the rope in different parts of integer lengths in a way
that maximizes product of lengths of all parts. You must make at least one cut.
Assume that the length of rope is more than 2 meters.

Examples:

Input: n = 2
Output: 1 (Maximum obtainable product is 1*1)

Input: n = 3
Output: 2 (Maximum obtainable product is 1*2)

Input: n = 4
Output: 4 (Maximum obtainable product is 2*2)

Input: n = 5
Output: 6 (Maximum obtainable product is 2*3)

Input: n = 10
Output: 36 (Maximum obtainable product is 3*3*4)
 */

/*
Approach: n length rod and assume you can cut at 1..n-1 anywhere, then

maxProduct(n) =     max  {  i * (n-i) ,
                            i * maxProduct(n-i) }
                 for all i:1 to n-1



 */
public class MaximumProductCutting {


    //Recursion approach:
    public static int maxProduct(int n){
        if(n<=1){
            return 1;
        }
        int maxProduct = Integer.MIN_VALUE;
        for(int i=1; i<n; i++){
            maxProduct  = Math.max(maxProduct, Math.max(i * (n - i),
                    i * maxProduct(n - i)));
        }

        return maxProduct;

    }


    //DP Approach
    public static int maxProductDp(int n){
        int[] dp = new int[n+1];
        //Arrays.fill(dp, -1);
        dp[0]=1;
        if(n<=1){
            dp[n]=1;
        }else {

            //Note: for easy math, treat the length from 1 to n
            for (int i = 1; i <= n; i++) {
                int maxProduct = Integer.MIN_VALUE;
                for(int j=1;j<=i/2;j++) {
                    maxProduct = Math.max(maxProduct, Math.max(j * (i - j), (j * dp[i - j])));
                }
                dp[i] = maxProduct;
            }
            //dp[n] = maxProduct;
        }
        return dp[n];
    }

    public static void main(String args[]){
        for(int i=2; i<3; i++) {
            System.out.println("Maximum product for length:" + i + " is ::" + maxProductDp(i));
        }


    }

}
