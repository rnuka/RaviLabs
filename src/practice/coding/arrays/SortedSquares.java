package practice.coding.arrays;

import java.util.Arrays;

/*
Given: sorted array of integers
Return: sorted array of squares of those integers
Ex: [1,3,5] -> [1,9,25]

Integers can be negative.
 */
//TODO: Pending O(1) space logic
public class SortedSquares {
    public void sortSquares(int[] a){
        int[] temp = new int[a.length];
        int low = 0;
        int high = a.length-1;
        int k = a.length-1;
        while(low<=high && low<a.length){
            if(a[low]*a[low] > a[high]*a[high]){
                temp[k--]=a[low]*a[low];
                low++;
            }else{
                temp[k--]=a[high]*a[high];
                high--;
            }
        }
        //a = Arrays.copyOf(temp, temp.length);
        for(int i=0; i<a.length; i++){
            a[i]=temp[i];
        }
    }

    public void testcase2(){
        System.out.println("***** TESTCASE-2 *******");
        int[] a = {-6,-3,1,5};
        sortSquares(a);
        System.out.println("sorted square array is" + Arrays.toString(a));
    }

    public void testcase1(){
        int[] a = {-5,1,3,6};
        sortSquares(a);
        System.out.println("sorted square array is" + Arrays.toString(a));
    }

    public void testbed(){
        testcase1();
        testcase2();
    }

    public static void main(String args[]){
        SortedSquares s = new SortedSquares();
        s.testbed();
    }
}
