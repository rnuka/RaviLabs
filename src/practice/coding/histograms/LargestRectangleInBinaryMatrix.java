package practice.coding.histograms;

import java.util.Stack;

/*
Given a binary matrix, find the maximum size rectangle binary-sub-matrix with all 1’s.

Input :   0 1 1 0
          1 1 1 1
          1 1 1 1
          1 1 0 0

Output : 8 because of    1 1 1 1
                         1 1 1 1
 */

/*
Approach: Solving similar to "Largest Rectangle in Histogram way"
 */

public class LargestRectangleInBinaryMatrix {


    public int maximalRectangle(int[][] matrix) {
        int m = matrix.length;
        int n = m == 0 ? 0 : matrix[0].length;
        int[][] height = new int[m][n + 1];

        int maxArea = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    height[i][j] = 0;
                } else {
                    height[i][j] = i == 0 ? 1 : height[i - 1][j] + 1;
                }
            }
        }

        for (int i = 0; i < m; i++) {
            int area = maxAreaInHist(height[i]);
            if (area > maxArea) {
                maxArea = area;
            }
        }

        return maxArea;
    }

    private int maxAreaInHist(int[] height) {
        Stack<Integer> stack = new Stack<Integer>();

        int i = 0;
        int max = 0;

        while (i < height.length) {
            if (stack.isEmpty() || height[stack.peek()] <= height[i]) {
                stack.push(i++);
            } else {
                int t = stack.pop();
                max = Math.max(max, height[t]
                        * (stack.isEmpty() ? i : i - stack.peek() - 1));
            }
        }

        return max;
    }

    public void testcase1(){
        int[][] arr = new int[][]{
            {0, 1, 1, 0},
            {1, 1, 1, 1},
            {1, 1, 1, 1},
            {1, 1, 0, 0}
        };

        System.out.println("max area for input is::"+maximalRectangle(arr));

    }

    public void testbed(){
        testcase1();
    }

    public static void main(String args[]){
        LargestRectangleInBinaryMatrix lr = new LargestRectangleInBinaryMatrix();
        lr.testbed();
    }
}
