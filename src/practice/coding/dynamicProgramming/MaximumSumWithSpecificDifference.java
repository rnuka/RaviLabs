package practice.coding.dynamicProgramming;

import java.util.Arrays;

/*

Question:  Maximum sum of pairs with specific difference
Given an array of integers and a number k. We can pair two number of array if difference between
them is strictly less than k. The task is to find maximum possible sum of disjoint pairs.
Sum of P pairs is sum of all 2P numbers of pairs.

Examples:

Input  : arr[] = {3, 5, 10, 15, 17, 12, 9}, K = 4
Output : 62

Then disjoint pairs with difference less than K are,
(3, 5), (10, 12), (15, 17)
So maximum sum which we can get is 3 + 5 + 12 + 10 + 15 + 17 = 62

Note that an alternate way to form disjoint pairs is,
(3, 5), (9, 12), (15, 17), but this pairing produces lesser sum.

Input  : arr[] = {5, 15, 10, 300}, k = 12
Output : 25

optimal substructure: After sorting,
if(arr[n]-arr[n-1] < k )
    f(n) = arr[n]+arr[n-1]+f(n-2)
else
    f(n) = f(n-1)

Hint: Sorting and then start checking from end of array to capture bigger numbers first to get max sum.
* */
public class MaximumSumWithSpecificDifference {

    public int maxSumPairs(int[] arr, int K){
        int sum=0;
        Arrays.sort(arr);
        for(int i=arr.length-1;i>0;i--){
            if(arr[i]-arr[i-1]<K){
                sum+=arr[i]+arr[i-1];
                i--;
            }

        }
        return sum;
    }

    public static void main(String args[]){
        MaximumSumWithSpecificDifference maxSumDiffPairs = new MaximumSumWithSpecificDifference();
        int[] arr = {3, 5, 10, 15, 17, 12, 9};
        System.out.println("max Sum:: "+maxSumDiffPairs.maxSumPairs(arr,4));

    }

}
