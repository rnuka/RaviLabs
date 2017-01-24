package practice.coding.dynamicProgramming;


/*
The Longest Increasing Subsequence (LIS) problem is to find the length of the longest
subsequence of a given sequence such that all elements of the subsequence are sorted in
increasing order.


Example: the length of LIS for input = {10, 22, 9, 33, 21, 50, 41, 60, 80} is 6
--------                    and LIS is {10, 22, 33, 50, 60, 80}.

More Examples:
-------------
Input  : arr[] = {3, 10, 2, 1, 20}
Output : Length of LIS = 3
The longest increasing subsequence is 3, 10, 20

Input  : arr[] = {3, 2}
Output : Length of LIS = 1
The longest increasing subsequences are {3} and {2}

Input : arr[] = {50, 3, 10, 7, 40, 80}
Output : Length of LIS = 4
The longest increasing subsequence is {3, 7, 40, 80}

 */

/*
 DP Approach:

 f(n) = 1 when n = 1
 f(n) = 1+ max( f(n-i) ) for all i:0->(n-1) where value(n) > value (i)


 */

import java.util.Arrays;

public class LongestIncreasingSubSequence {

    public int longestSubSequence(int[] input){
        int longest = 1;

        int[] lis = input.clone();
        Arrays.fill(lis, 1);

        for(int i=1; i<input.length; i++){
            for(int j=0; j<i; j++){
                if(input[i] > input[j] &&
                    lis[i] < (lis[j] + 1)
                        ){
                    lis[i] = lis[j] + 1;
                }
                if(lis[i] > longest){
                    longest = lis[i];
                }
            }
        }

        return longest;
    }

    public void testcase2(){
        int[] input = {4,3,5};
        System.out.println("Testcase2 \n LIS: "+longestSubSequence(input));
    }

    public void testcase1(){
        int[] input = {3,4,5};
        System.out.println("LIS: "+longestSubSequence(input));
    }

    public void testbed(){
        testcase1();
        testcase2();
    }

    public static void main(String args[]){
        LongestIncreasingSubSequence lis = new LongestIncreasingSubSequence();
        lis.testbed();
    }

}
