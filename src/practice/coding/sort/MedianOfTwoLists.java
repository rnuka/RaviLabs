package practice.coding.sort;

import java.util.Arrays;

/*
Leetcode: https://leetcode.com/problems/median-of-two-sorted-arrays/

Question: There are two sorted arrays nums1 and nums2 of size m and n respectively.

Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).

Example 1:
nums1 = [1, 3]
nums2 = [2]

The median is 2.0
Example 2:
nums1 = [1, 2]
nums2 = [3, 4]

The median is (2 + 3)/2 = 2.5
 */

/*
Key point: each of the input list is sorted already
 */
public class MedianOfTwoLists {

    //Time complexity O(n) approach which is not as per question
    public double median(int[] a, int[] b){  //Make sure, a is shorter array always
        int a_index = 0;
        int b_index = 0;
        int medianIndex = (a.length + b.length)/2;
        int median1 = a[0], median2 = a[0];
        for(int count = 0 ; count < medianIndex; count++){
            if(a_index < a.length && a[a_index] < b[b_index]){
                median1 = a[a_index];
                if(count==medianIndex-2){
                    median2 = a[a_index];
                }
                a_index++;
            }else{
                median1 = b[b_index];
                if(count==medianIndex-2){
                    median2 = b[b_index];
                }
                b_index++;
            }

        }
        if(medianIndex%2==0){
            return (double)(median1+median2)/(double)2;
        }else {
            return median1;
        }
    }


    //Optimal Solution:
    public double median2(int[] a, int[] b, int a_low, int a_high, int b_low, int b_high){
        double a_median = medianSingleList(a, a_low, a_high);
        double b_median = medianSingleList(b, b_low, b_high);
        //if a has bigger value numbers than b, then median should lie between b upper half and a lower half
        if(a_median > b_median){
            int a_mid = a.length/2;
            int b_mid = b.length/2;
            //recurse until only two elements in each array
           // median2()
            //TODO: pending code
        }
        return 0.0;
    }

    public double medianSingleList(int[] list, int low, int high){
        if((high-low)%2!=0){
            return (double)(list[(high-low)/2]+list[high-low/2-1])/(double)2;
        }else{
            return (double)list[(high-low)/2];
        }
    }


    public void testcase1(){
        int[] a = {1,2};
        int[] b = {3,4};

        System.out.println("Median of "+ Arrays.toString(a)+" and "+Arrays.toString(b)+" is::"+median(a,b));
    }

    public void testbed(){
        testcase1();
    }

    public static void main(String args[]){
        MedianOfTwoLists m = new MedianOfTwoLists();
        m.testbed();
    }
}
