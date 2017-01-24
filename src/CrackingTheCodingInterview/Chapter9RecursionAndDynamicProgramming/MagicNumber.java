package CrackingTheCodingInterview.Chapter9RecursionAndDynamicProgramming;

/**
 * Created by rnuka on 10/18/15.
 */
/*
Question 9.3: A magic index in an array A[l.. .n-l] is defined to be an index such that A[i] =
i. Given a sorted array of distinct integers, write a method to find a magic index, if
one exists, in array A.
FOLLOW UP
What if the values are not distinct?
 */
/*
input: array of distinct integers (in followup duplicates are allowed)
output: if there is any magic index
*/
public class MagicNumber {
    //recurse the method as in binary search and find magic index
    int findMagicIndex(int[] arr, int low, int high){

        int mid = (low+high)/2;

        //single element split
        if(low >= high){
            if(arr[low]==low){
                return low;
            }
            return -1;
        }

        findMagicIndex(arr, low, mid-1);
        findMagicIndex(arr, mid+1, high);

        return -1;
    }

    //test
    public static void main(String[] args){

    }
}
