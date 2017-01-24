package practice.coding.trees;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Given two pre-order traversal arrays of two binary search tree respectively,
find first pair of non-matching leaves.

Print first pair of mis-matching leaves (first pair as in in-order) given two pre-order traversal arrays of BSTs.

e.g.


For
                  5
              4      8
            2  4    6  9
            Pre-order Sequence as [5,4,2,4,8,6,9]
                &
                  5
              3     8
            2  4   7  9
            Pre-order Sequence2 as [5,3,2,4,8,7,9]

            Print “6, 7”

Link: https://www.careercup.com/question?id=5186146490384384

Follow Up: If they are general binary trees instead of BSTs, could you solve it? give out your reason.
 */
public class FirstMismatchLeafGiven2PreorderArraysOfBST {

    public int[] firstMismatchLeafPair(int[] a, int[] b){
        if(a==null || b==null){
            return null;
        }

        int[] mismatchPair = new int[2];

        int[] aFlags = new int[a.length]; // 0 for non leaves and 1 for leaves

        int[] bFlags = new int[b.length];

        mark(a, 0, a.length - 1, aFlags);
        System.out.println("----Marking a is completed------");
        mark(b, 0, b.length - 1, bFlags);
        System.out.println("----Marking b is completed------");

        System.out.println("After marking aFlag=" + Arrays.toString(aFlags));
        System.out.println("After marking bFlag="+ Arrays.toString(bFlags));

        //compare leaves and return the pair
        List<Integer> aList = new ArrayList<>();
        List<Integer> bList = new ArrayList<>();
        addList(a,aFlags, aList);
        addList(b,bFlags, bList);

        //return the mismatch pair
        int size = Math.min(aList.size(), bList.size());
        int k=0;
        while(k<size){
            if(aList.get(k) != bList.get(k)){
                mismatchPair[0]=aList.get(k);
                mismatchPair[1]=bList.get(k);
                return mismatchPair;
            }
            k++;
        }

        if(aList.size() != bList.size()){
            mismatchPair[0]=k<aList.size()?aList.get(k):Integer.MIN_VALUE;
            mismatchPair[1]=k<bList.size()?bList.get(k):Integer.MIN_VALUE;
        }




        return mismatchPair;
    }

    void addList(int[] array, int[] flags, List<Integer> list){
        for(int i=0; i<array.length; i++){
            if(flags[i]==1){
                list.add(array[i]);
            }
        }
    }

    void mark(int[] array, int low, int high, int[] flags){
        flags[high]=1; //last node is always a leaf node.
        if(high-low<2){ //less than 3 nodes then base case
            return;
        }
        if(high-low==2){
            if(!(array[low]<array[high] && array[low]<array[high-1] ||
                    array[low]>array[high] && array[low]>array[high-1])){ //both elements are not less or not greater than root
                flags[high-1]=1; //i.e. high is right child and high-1 is left child
            }
        }else{ //i.e. more than 3 elements in window
            int lowFirstHalf = -1;
            int highFirsthalf = -1;
            int lowSecondHalf = -1;
            int highSecondhalf = -1;
            int curr = low+1;
            while(curr<array.length && array[low]>array[curr]){
                curr++;
            }

            if(curr-1 != low){ //if there exists some elements less than root
                lowFirstHalf=low+1;
                highFirsthalf = curr-1;
            }

            if(curr<high){ //if there are more than one high elements than root
                lowSecondHalf=curr;
                highSecondhalf=high;
            }else if(curr==high){ //if there is only one element high than root
                lowSecondHalf=curr;
                highSecondhalf=curr;
            }

            //recursion
            if(lowFirstHalf !=-1){
                mark(array, lowFirstHalf, highFirsthalf, flags);
            }

            if(lowSecondHalf !=-1){
                mark(array, lowSecondHalf, highSecondhalf, flags);
            }
        }
    }

    public void testcase1(){
        int[] a = {5,4,2,4,8,6,9};
        int[] b = {5,3,2,4,8,7,9};
        int[] c= firstMismatchLeafPair(a,b);
        System.out.println("results are::"+Arrays.toString(c));

    }

    public void testbed(){
        testcase1();
    }


    public static void main(String args[]){
        FirstMismatchLeafGiven2PreorderArraysOfBST f = new FirstMismatchLeafGiven2PreorderArraysOfBST();
        f.testbed();
    }



}
