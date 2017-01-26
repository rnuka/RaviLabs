package practice.coding.dynamicProgramming;

/*
Given an unsorted array of integers, find the length of the longest consecutive elements sequence.
For example,
Given [100, 4, 200, 1, 3, 2] ,
The longest consecutive elements sequence is [1, 2, 3, 4] . Return its length: 4 .
Your algorithm should run in O(n) complexity.
 */
/*
copy array to hash set and use two while loop to look for element+1 value and element-1 value
Approach: http://www.programcreek.com/2013/01/leetcode-longest-consecutive-sequence-java/
 */

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/*
Keypoints:
1. How to treat duplicate elements i.e.ignore them or count
for e.g. 1,2,3,4,4 should return length 4 or 5? Assume: 4
2. negative elements are possible?
3. sorted? No
 */
public class LongestConsecutiveSequence {

    public int longestConsecutiveElementSequence(int[] input){
        Set<Integer> inputSet = new HashSet<>();
        for(int i: input){
            inputSet.add(i);
        }
        int maxCount = 0;
        for(int start :  input) {
            if(inputSet.contains(start)) {
                inputSet.remove(start);
                int count = 1;
                int left = start-1;
                //remove all lefts and count left side consecutives
                while (inputSet.contains(left)){
                    count++;
                    inputSet.remove(left);
                    left = left -1;
                }
                int right = start + 1;
                //remove all rights and count right side consecutive elements
                while(inputSet.contains(right)){
                    count++;
                    inputSet.remove(right);
                    right = right + 1;
                }

                maxCount = Math.max(maxCount, count);
            }
        }
        return maxCount;
    }

    void testcase1(int[] input){
        System.out.println("Longest sequence for input::"+ Arrays.toString(input)+" is::"+longestConsecutiveElementSequence(input));
    }
    void testbed(){
        testcase1(new int[]{100,4,99,3,2,200,1});
    }

    public static void main(String args[]){
        LongestConsecutiveSequence l = new LongestConsecutiveSequence();
        l.testbed();
    }

}
