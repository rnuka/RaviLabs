package practice.coding.arrays;
import java.util.*;
/*
* Question: Given an unsorted array of integers, find a subarray which adds to a given number.
* If there are more than one subarrays with sum as the given number, print any of them.

Examples:

Input: arr[] = {1, 4, 20, 3, 10, 5}, sum = 33
Ouptut: Sum found between indexes 2 and 4

Input: arr[] = {10, 2, -2, -20, 10}, sum = -10
Ouptut: Sum found between indexes 0 to 3

Input: arr[] = {-10, 0, 2, -2, -20, 10}, sum = 20
Ouptut: No subarray with given sum exists

Approach:   Use a map to store running sum and index. Check to see if
--------    (K-currSum) is already present in map then the sub array found.

* */
public class SubArrayKSum {

    public void printSubarrays(int[] input, int k){
        Map<Integer,Integer> totals = new HashMap<Integer,Integer>();
        int currSum = 0;
        for(int i=0; i<input.length; i++){
            currSum+=input[i];
            if(input[i]==k){
                System.out.println(" sum found at index"+i);
                return;
            }
            else if(currSum==k){
                System.out.println("sum found from index 0 to "+i);
                return;
            }
            else if(totals.containsKey(currSum-k)){
                System.out.println("sum found from index::"+(totals.get(currSum-k)+1)+"to::"+i);
                return;
            }else{
                //update totals map
                totals.put(currSum,i);
            }
        }
    }

    public static void main(String[] args) {
        SubArrayKSum subArray = new SubArrayKSum();
        int[] input = {5, 6, 1, -2, -4, 3, 1, 5};
        subArray.printSubarrays(input, 5);
    }


}
