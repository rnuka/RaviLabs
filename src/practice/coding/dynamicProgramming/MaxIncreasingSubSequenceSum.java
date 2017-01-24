package practice.coding.dynamicProgramming;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/*Given an array of n positive integers. Write a program to find the sum of maximum sum subsequence
 * of the given array such that the integers in the subsequence are sorted in increasing order.
 * For example, if input is {1, 101, 2, 3, 100, 4, 5}, then output should be 106 (1 + 2 + 3 + 100),
 * if the input array is {3, 4, 5, 10}, then output should be 22 (3 + 4 + 5 + 10)
 * and if the input array is {10, 5, 4, 3}, then output should be 10
 * */


public class MaxIncreasingSubSequenceSum {
    public MaxIncreasingSubSequenceSum() {
    }
    
    static int[] arr = {-2, -11, 101, 4,3, 5, 9, 5, 100, 4, 5};
    static int[] sumList = {-2, -11, 101, 4,3, 5, 9, 5, 100, 4, 5};
    static Map<Integer,List> maxListElements= new HashMap<Integer,List>();
    static int maxPosition=0;
    static int maxSum=0;
    
    public static void main(String args[]){
        
       for (int i=1;i<arr.length;i++){
          List tempSet = new ArrayList();
          for(int j=0;j<i;j++){
              if (arr[i] > arr[j] &&
                    sumList[i] < sumList[j] + arr[i]){
                  sumList[i]+=arr[j];
                  tempSet.add(arr[j]);
              }
          }
          
          //add last element as it is missed in earlier for-loop
          tempSet.add(arr[i]);
          
          //assign the set elements to set Array
          maxListElements.put(i,tempSet);
           
       }
       
       //sumList has maximum values populated
       for(int k=0;k<sumList.length;k++){
           System.out.println("sum of "+k+"th positon="+sumList[k]);
           if(sumList[k]>maxSum){
               maxPosition=k;
               maxSum=sumList[k];
           }
       }
       
       System.out.println("maximum sum="+maxSum);
       System.out.println("maximum sum="+maxListElements.get(maxPosition));
    
    }
    
    
}
