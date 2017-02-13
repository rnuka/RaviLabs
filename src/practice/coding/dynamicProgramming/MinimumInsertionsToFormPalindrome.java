package practice.coding.dynamicProgramming;

/*
Given a string, find the minimum number of characters to be inserted to convert it to palindrome.

Before we go further, let us understand with few examples:
    ab: Number of insertions required is 1. bab
    aa: Number of insertions required is 0. aa
    abcd: Number of insertions required is 3. dcbabcd
    abcda: Number of insertions required is 2. adcbcda which is same as number of insertions in the substring bcd(Why?).
    abcde: Number of insertions required is 4. edcbabcde


Subproblem:

    min_insertions(s,low,high) = 1           if high = low+1 and s[high] != s[low]
                               = 0           if high = low+1 and s[high] == s[low]
                               = min_insertions(low+1,high-1)          if low=high
                               = min { min_insertions(low,high-1),
                                       min_insertions(low+1,high) }    Otherwise


 */
public class MinimumInsertionsToFormPalindrome {
}
