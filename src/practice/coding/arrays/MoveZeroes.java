package practice.coding.arrays;

import java.util.Arrays;

/*
Given an array nums , write a function to move all 0 's to the end of it while maintaining the relative order of the
non-zero elements.

Example:
--------
Input = [0, 1, 0, 3, 12] , after calling your function, nums should be [1, 3, 12, 0, 0]

Note:
-----
1. You must do this in-place without making a copy of the array.
2. Minimize the total number of operations.
 */


/// NOTE - NOTE - NOTE ****  CHECK the code of ArrangeZeroEnd.java class file for better solution.


public class MoveZeroes {
    public void move(int[] input){
        int index = input.length -1;
        for(int i=0; i<index; i++){ //Note: i<index is very important otherwise zeros will not be in end.
            if(input[i]==0){
                swap(input,i,index);
                index--;
            }
        }
    }

    public void swap(int[] input, int from, int to){
        input[from]=input[to];
        input[to]=0;
    }

    public void testcase1(){
        int[] input = {0, 1, 0, 3, 12};
        move(input);
        System.out.println(Arrays.toString(input));
    }

    public void testbed(){
        testcase1();
    }

    public static void main(String args[]){
        MoveZeroes m = new MoveZeroes();
        m.testbed();
    }
}
