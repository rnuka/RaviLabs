package practice.coding.dynamicProgramming;

/*
Say you have an array for which the ith element is the price of a given stock on day
1. Design an algorithm to find the maximum profit. You may complete at most k transactions.

Note:
You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
 */

/*
The problem can be solve by using dynamic programming. The relation is:

local[i][j] = max(global[i-1][j-1] + max(diff,0), local[i-1][j]+diff)
global[i][j] = max(local[i][j], global[i-1][j])
We track two arrays - local and global.

Local Array: The local array tracks maximum profit of j transactions &
the last transaction is on ith day.

Global Array: The global array tracks the maximum profit of j transactions until ith day.

Links:
http://www.programcreek.com/2014/02/leetcode-best-time-to-buy-and-sell-stock-ii-java/
http://www.programcreek.com/2014/02/leetcode-best-time-to-buy-and-sell-stock-iv-java/


 */
public class BestTimeToBuyAndSellStockDP {

    public int maxProfit(int k, int[] prices) {
        if (prices.length < 2 || k <= 0)
            return 0;

        int[] local = new int[k + 1];
        int[] global = new int[k + 1];

        for (int i = 0; i < prices.length - 1; i++) {
            int diff = prices[i + 1] - prices[i];
            for (int j = k; j >= 1; j--) {
                local[j] = Math.max(global[j - 1] + Math.max(diff, 0), local[j] + diff);
                global[j] = Math.max(local[j], global[j]);
            }
        }

        return global[k];
    }

    public void testcase1(){
        int[] input = {1,3,1,8,10,6};
        int k=3;
        System.out.println("Maximum profit with k="+k+" transaction="+maxProfit(k, input));
    }

    public void testbed(){
        testcase1();
    }

    public static void main(String args[]){
        BestTimeToBuyAndSellStockDP b = new BestTimeToBuyAndSellStockDP();
        b.testbed();
    }
}
