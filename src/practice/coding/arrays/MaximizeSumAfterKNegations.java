package practice.coding.arrays;

import java.util.PriorityQueue;

/*
Given an array of size n and a number k. We must modify array K number of times.
Here modify array means in each operation we can replace any array element arr[i] by -arr[i].
We need to perform this operation in such a way that after K operations, sum of array must be maximum?

Examples:

Input : arr[] = {-2, 0, 5, -1, 2}
        K = 4
Output: 10
// Replace (-2) by -(-2), array becomes {2, 0, 5, -1, 2}
// Replace (-1) by -(-1), array becomes {2, 0, 5, 1, 2}
// Replace (0) by -(0), array becomes {2, 0, 5, 1, 2}
// Replace (0) by -(0), array becomes {2, 0, 5, 1, 2}

Input : arr[] = {9, 8, 8, 5}
        K = 3
Output: 20
 */
public class MaximizeSumAfterKNegations {

    public int maxSum(int[] input, int k){
        //populate a priority queue based on input.
        PriorityQueue pq = new PriorityQueue();
        for(int i=0; i<input.length; i++){
            pq.add(input[i]);
        }

        //negative min element always by k times
        for(int counter = 0; counter<k; counter++){
            pq.add(-1 * (int)pq.poll());
        }


        //return sum
        int sum = 0;
        while(!pq.isEmpty()){
            sum += (int)pq.poll();
        }

        return sum;

    }

    public void testcase1(){
        int[] input = {-2, 0, 5, -1, 2};
        System.out.println("max sum="+maxSum(input,4));
    }

    public void testbed(){
        testcase1();
    }

    public static void main(String args[]){
        MaximizeSumAfterKNegations m = new MaximizeSumAfterKNegations();
        m.testbed();
    }

}
