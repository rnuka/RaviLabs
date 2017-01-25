package practice.coding.arrays;

import java.util.stream.IntStream;

/**
 * Created by rnuka on 6/5/16.
 */
/*
Equilibrium index of an array is an index such that the sum of elements at lower indexes is equal to
the sum of elements at higher indexes. For example, in an arrya A:

A[0] = -7, A[1] = 1, A[2] = 5, A[3] = 2, A[4] = -4, A[5] = 3, A[6]=0

3 is an equilibrium index, because:
A[0] + A[1] + A[2] = A[4] + A[5] + A[6]

6 is also an equilibrium index, because sum of zero elements is zero,

i.e., A[0] + A[1] + A[2] + A[3] + A[4] + A[5]=0

7 is not an equilibrium index, because it is not a valid index of array A.

Write a function int equilibrium(int[] arr, int n); that given a sequence arr[] of size n,
returns an equilibrium index (if any) or -1 if no equilibrium indexes exist.

 */

/*
Forumula : (TS-CS-LS) = LS is equilibrium index
Approach: Assume LS is Left Sum, TS is total Sum, RS is right Sum and CS is current index value
    then start from i=0 and traverse until end or until LS is greater than RS and see if equilibrium found.

    for(int i=0; i<n && LS < RS; i++){
        LS += CS;
        RS = TS - CS - LS;
        if(LS==RS){
            return i;
        }
    }

*/

public class Equilibrium {
    public int equalIndex(int[] a){

        int size = a.length;

        //get totalSum using Java8 stream
        int totalSum = IntStream.of(a).sum();


        //if sum is a odd number return -1 and no need to check further as no equilibrium exists if sum is odd
        //Wrong ?
        if(totalSum%2 !=0){
            return -1;
        }

        //once totalSum is found, then compare left sum with totalSum-(i+1..n elements)
        int leftSum = 0;
        for(int i=0; i<size; i++){
            totalSum -= a[i];
            if(leftSum == totalSum){
                return i;
            }
            leftSum += a[i];
        }

        return -1;
    }

    public void myassert(boolean x){
        if(!x){
            throw new IllegalArgumentException("Assert Fails");
        }
    }

    public void testbasic2(){
        int[] a = {-1,-1,-1,-1,1,1,2,2,-3,-1};
        int equalIndex = equalIndex(a);
        System.out.println(" equal index="+equalIndex);
        myassert(equalIndex==6);
    }

    public void testbasic(){
        int[] a = {1,3,2,4};
        int equalIndex = equalIndex(a);
        System.out.println(" equal index="+equalIndex);
        myassert(equalIndex == 2);
    }

    public void testbench(){
        testbasic();
        testbasic2();
    }

    public static void main(String[] args){
        Equilibrium e = new Equilibrium();
        e.testbench();
    }
}
