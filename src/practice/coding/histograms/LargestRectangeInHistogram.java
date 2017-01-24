package practice.coding.histograms;

import java.util.Stack;

/*
Question:

Given n non-negative integers representing the histogram's bar height where the width of each bar is 1,
 find the area of largest rectangle in the histogram.


Example-1: Given histogram where width of each bar is 1, given heights = [2,1,5,6,2,3].


The largest rectangle can be formed is from bars with height 5 and 6 (2*5) area,
which has area = 10 unit.

Example-2:
Given heights = [2,1,5,6,2,3],
return 10.

 */
public class LargestRectangeInHistogram {

    //brute-force O(n2) solution
    public int maxRectangle(int[] heights){
        int maxArea = 0;
        for(int i=0; i<heights.length; i++){
            //Approach: start from i position and keep calculating minHeight and area until 0 index
            int minHeight = Integer.MAX_VALUE;
            for(int j=i;j>=0;j--){
                    minHeight=Math.min(minHeight,heights[j]);
                    maxArea = Math.max(minHeight*(i-j+1),maxArea);
            }
        }
        return  maxArea;
    }


    /*
     Optimal Solution O(n) approach: Though it looks O(n2) because of while loop inside while loop,
                                        it is O(2n) actually and hence O(n).
     */
    public int maxRectangle2(int[] heights ){

        if(heights.length == 0 || heights == null){
            return 0;
        }

        Stack<Integer> stack = new Stack<>();
        int i=0;
        int maxArea = 0;
        //Approach: push until a small element than previous is found and then start doing area calc by pop.
        while(i<heights.length){
            if(stack.isEmpty() || heights[i]>=heights[stack.peek()]){
                stack.push(i);
                i++;
            }else{
                int topIndex = stack.pop();
                int topValue = heights[topIndex];
                //int width = stack.isEmpty()? i : (i-stack.peek()-1);
                int width = i-topIndex; //width between topIndex to current i
                maxArea = Math.max(maxArea,(topValue*width));
            }
        }

        //there is chance that stack may not be empty if all elements are increasing.
        //if there are more in stack, then pop them out and see if it exceeds max area
        while(!stack.isEmpty()){
            int topIndex = stack.pop();
            int topValue = heights[topIndex];
            //int width = stack.isEmpty()? i : (i-stack.peek()-1);
            int width = i-topIndex;
            maxArea = Math.max(maxArea,(topValue*width));
        }

        return maxArea;
    }

    public void myassert(boolean x){
        if(!x){
            throw new IllegalArgumentException("Assert Fails");
        }
    }

    public void testcase4(){
        System.out.println("**** TESTCASE-4 *******");
        int[] heights = {8,1};
        System.out.println("Max area for is::"+maxRectangle2(heights));
        myassert(8 == maxRectangle2(heights));
    }

    public void testcase3(){
        System.out.println("**** TESTCASE-3 *******");
        int[] heights = {8,1};
        System.out.println("Max area for is::"+maxRectangle2(heights));
        myassert(8 == maxRectangle(heights));
    }

    public void testcase2(){
        System.out.println("**** TESTCASE-2 *******");
        int[] heights = {1,6,10,5,3};
        System.out.println("Max area for is::"+maxRectangle2(heights));
        myassert(15 == maxRectangle(heights));
    }

    public void testcase1(){
        System.out.println("**** TESTCASE-1 *******");
        int[] heights = {3,4,1,1};
        System.out.println("Max area for is::"+maxRectangle2(heights));
        myassert(6 == maxRectangle(heights));
    }

    public void testbed(){
        testcase1();
        testcase2();
        testcase3();
        testcase4();
    }

    public static void main(String args[]){
        LargestRectangeInHistogram lrh = new LargestRectangeInHistogram();
        lrh.testbed();
    }



}
