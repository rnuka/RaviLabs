package practice.coding.dynamicProgramming;

/*
Question: Given an array of positive numbers, find the maximum sum of a subsequence with the constraint
that no 2 numbers in the sequence should be adjacent in the array.
Example1: 3 2 7 10 should return 13 (sum of 3 and 10)
Example2: 3 2 5 10 7 should return 15 (sum of 3, 5 and 7).
 */

/*
Approach: DP
      f(n) = max(f(n-1), f(n-2)+v(n)) where v(n) is value of n
 */
public class MaxSubSequenceSumWithNo2Consecutive {
}
