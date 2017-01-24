package practice.coding.arrays;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

/*
Question: Find the kth largest element in an unsorted array. Note that it is the kth largest element in the
sorted order, not the kth distinct element.

For example, given [3,2,1,5,6,4] and k = 2, return 5.

Note: You may assume k is always valid, 1 ≤ k ≤ array's length
 */
public class FindKthLargestInArray {

    /*APPROACH-1: using minHeap - create a window of K elements and keep adding the elements to heap when size>k
     remove min element by the time all elements are processed n-k smallest elements are removed and
     root is kth largest.
     RunTime: O(nlogk) and space O(k)
    */
    int getKthLargest(int[] input, int k){
        Queue<Integer> minHeap = new PriorityQueue<>();
        for(Integer i: input){
            minHeap.offer(i);
            if(minHeap.size()>k){
                minHeap.poll();
            }
        }
        return minHeap.peek();
    }

    /*
    APPROACH-2: using modified version of quick sort.
    Rule: pivot divides elements into two buckets <p and >p, so if partition is continued and
    whenever pivot position=k then we got kth largest element.
    Advantage: No need to fully sort the array
    Average Run time: o(n) and worst run time is: o(n2)
     */
    int getKthLargest2(int[] input, int k){
        if(k>input.length){
            return Integer.MIN_VALUE;
        }
        return getKthLargestParition(input, k, 0, input.length - 1);
    }

    int getKthLargestParition(int[] input, int k, int low, int high){
        if(low>=high){
            return input[low];
        }
        int pivot = input[low];
        int i=low+1;
        int j=low+1;
        while(j<=high){
            if(input[j]<pivot){
                swap(input, i,j);
                i++;
            }
            j++;
        }

        //swap pivot with i-1 to send pivot to its correct position
        swap(input, low, i-1);
        if(k-1==input.length-i){
            return pivot;
        }else if(k<i-1){
            return getKthLargestParition(input, k, low, i-2);
        }else{
            return getKthLargestParition(input, k, i, high);
        }


    }

    void swap(int[] input, int i, int j){
        int temp = input[i];
        input[i] = input[j];
        input[j] = temp;
    }

    public void testcase2(){
        System.out.println("******* TESTCASE-2 **********");
        int[] input = {3,2,1,5,6,4};
        int k = 2;
        System.out.println(k+"th largest element in array "+ Arrays.toString(input)+" is:: "+getKthLargest2(input, k));
    }

    public void testcase1(){
        int[] input = {3,2,1,5,6,4};
        int k = 2;
        System.out.println(k+"th largest element in array "+ Arrays.toString(input)+" is:: "+getKthLargest(input,k));
    }

    public void testbed(){
        testcase1();
        testcase2();
    }

    public static void main(String args[]){
        FindKthLargestInArray f = new FindKthLargestInArray();
        f.testbed();
    }


}
