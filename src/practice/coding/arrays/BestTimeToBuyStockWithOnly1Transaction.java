package practice.coding.arrays;

/*
Say you have an array for which the i element is the price of a given stock on day i.
If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock),
design an algorithm to find the
maximum profit.

Example 1:
----------
Input: [7, 1, 5, 3, 6, 4]
Output: 5
max. difference = 6-1 = 5 (not 7-1 = 6, as selling price needs to be larger than buying price)

Example 2:
----------
Input: [7, 6, 4, 3, 1]
Output: 0
In this case, no transaction is done, i.e. max profit = 0.
 */
public class BestTimeToBuyStockWithOnly1Transaction {

    //Approach: Start from the end and check current vs rightMax to get max profit.
    //Note: Same can be done by starting from begin and captureu leftMin and check with curr to get max profit.
    public int maxProfix(int[] input){

        int rightMax = input[input.length-1];
        int maxProfit = 0;
        for(int i=input.length-2;i>=0; i--){
            maxProfit = Math.max(maxProfit, (rightMax-input[i]));
            if(rightMax<input[i]){
                rightMax = input[i];
            }

        }
        return maxProfit;
    }

    public void testcase2(){
        System.out.println(" **** TESTCASE-2 *****");
        int[] input = {7, 6, 4, 3, 1};
        System.out.println("Max profit for input="+maxProfix(input));
    }

    public void testcase1(){
        int[] input = {7, 1, 5, 3, 6, 4};
        System.out.println("Max profit for input="+maxProfix(input));
    }

    public void testbed(){
        testcase1();
        testcase2();
    }

    public static void main(String args[]){
        BestTimeToBuyStockWithOnly1Transaction b = new BestTimeToBuyStockWithOnly1Transaction();
        b.testbed();
    }
}
