package practice.coding.arrays;

import java.util.Arrays;

/*
Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.

If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).

The replacement must be in-place, do not allocate extra memory.

Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
1,2,3 → 1,3,2
3,2,1 → 1,2,3
1,1,5 → 1,5,1
[1,3,2] -> [2,1,3]

[4,2,0,2,3,2,0] -> [4,2,0,3,0,2,2]

https://leetcode.com/problems/next-permutation/

Solution: http://www.programcreek.com/2014/06/leetcode-next-permutation-java/
 */
public class NextPermutation {
    public void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        //find index whose right value is greater than left i.e. decreasing element otherwise continue while loop.
        while (i >= 0 && nums[i + 1] <= nums[i]) {
            i--;
        }
        if (i >= 0) {
            int j = nums.length - 1;
            while (j >= 0 && nums[j] <= nums[i]) {
                j--;
            }
            swap(nums, i, j);
        }
        reverse(nums, i + 1);
    }

    private void reverse(int[] nums, int start) {
        int i = start, j = nums.length - 1;
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public void testcase3(){
        int[] input = {2,3,1};
        System.out.println("Next permutation of input"+Arrays.toString(input)+" is::");
        nextPermutation(input);
        System.out.println(Arrays.toString(input));
    }

    public void testcase2(){
        int[] input = {1,2};
        System.out.println("Next permutation of input"+Arrays.toString(input)+" is::");
        nextPermutation(input);
        System.out.println(Arrays.toString(input));
    }

    public void testcase1(){
        int[] input = {1,2,3};
        System.out.println("Next permutation of input"+Arrays.toString(input)+" is::");
        nextPermutation(input);
        System.out.println(Arrays.toString(input));
    }

    public void testbed(){
       // testcase1();
       testcase2();
        //testcase3();
    }

    public static void main(String args[]){
        NextPermutation np = new NextPermutation();
        np.testbed();
    }
}
