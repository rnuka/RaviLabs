package practice.coding.arrays;

/**
 * Created by rnuka on 11/18/16.
 */
/*

Question: Modify the array by moving all the zeros to the end (right side).
The order of other elements doesn’t matter.

Let’s have an example. For array [1, 2, 0, 3, 0, 1, 2], the program can output [1, 2, 3, 1, 2, 0, 0].
 */
public class ArrangeZerosEnd {

    /* ===================Solution:1 BEGIN (Too many lines when compared with Solution:2)=============== */

    public void rearrangeArray(int[] array){
        int i = 0;
        //find first zero element
        while(i<array.length && array[i] !=0){
            i++;
        }

        //if zero element exists
        if(i<array.length){
            int beginIndex = i;
            //keep on swapping first zero element with non zero elements
            for(int j=beginIndex+1; j<array.length; j++){
                if(array[j] !=0){
                    swap(array, beginIndex, j);
                    beginIndex++;  //important: after swap begin index should move to next index not to j
                }
            }
        }
    }

    public void swap(int[] array, int from, int to){
        System.out.println("calling swap from:: "+from+" to:: "+to);
        array[from] = array[to];
        array[to] = 0;
    }

    /* ===================Solution:1 END =============== */



    /* ===================Solution:2 BEGIN =============== */

    public void rightShiftZeros(int[] input){

        int count = 0;

        //shift all non zeros to front
        for(int i=0; i<input.length; i++){
            if(input[i] !=0){
                input[count++]=input[i];
            }
        }

        //Now update rest of elements from current count value to length to zeros
        for(int i=count;i<input.length; i++){
            input[count++]=0;
        }
    }


    /* ===================Solution:2 END =============== */


    /* Solution-3 Optimal Way with minimal shifts or swaps */

    public void shift(int[] array){
        int left = 0;
        int right = array.length -1 ;
        while(left < right){
            //move left until non-zero element is found
            while(array[left] == 0){
                left++;
            }

            //move right until zero element is found
            while(array[right] != 0){
                right--;
            }

            //swap
            swap2(array, left, right);
        }
    }

    public void swap2(int[] array, int from, int to){
        System.out.println("calling swap from:: "+from+" to:: "+to);
        array[to] = array[from];
        array[from] = 0;
    }





    public void myassert(boolean x){
        if(!x){
            throw new IllegalArgumentException("Assert Fails");
        }
    }

    public void testcase3(){
        System.out.println("testcase-3 begin");
        int[] input = {0,0,0,0,9,2,0,0,1,2,0,3,0};
        shift(input);
        System.out.println(java.util.Arrays.toString(input));
    }

    public void testcase2(){
        System.out.println("testcase-2 begin");
        int[] input = {0,0,0,0,9,2,0,0,1,2,0,3,0};
        rightShiftZeros(input);
        System.out.println(java.util.Arrays.toString(input));
    }

    public void testcase1(){
        System.out.println("testcase-1 begin");
        int[] input = {0,0,0,0,9,2,0,0,1,2,0,3,0};
        rearrangeArray(input);
        System.out.println(java.util.Arrays.toString(input));
    }

    public void testbench(){
       // testcase1();
       // testcase2();
        testcase3();
    }

    public static void main(String args[]){
        ArrangeZerosEnd a = new ArrangeZerosEnd();
        a.testbench();
    }
}
