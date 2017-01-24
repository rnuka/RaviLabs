package practice.coding.arrays;

/*
Find duplicates in O(n) time and O(1) extra space
Given an array of n elements which contains elements from 0 to n-1, with any of these numbers appearing any number of times.
 Find these repeating numbers in O(n) and using only constant memory space.

For example, let n be 7 and array be {1, 2, 3, 1, 3, 6, 6}, the answer should be 1, 3 and 6.
* */
public class FindDuplicatesIn_O_N_time_n_O_1_space {
    /*Hint: elements are from 0 to n-1 which should help to solve in O(1) space. Use sign as indicator.
            As all elements are positive, change nth index to negative if u come across n in array and use it to identify duplicate.
     */

    public void duplicates(int[] array){

        for(int i=0; i<array.length; i++){
            if(array[Math.abs(array[i])] >=0 ){
                //add negative sign to look next time when we come across same number
                array[Math.abs(array[i])] = -1*array[Math.abs(array[i])];
            }else{
                System.out.println(Math.abs(array[i])+",");
            }

        }
    }

    public void testcase1(){
        int[] input = {1,2,3,1,3,6,6};
        duplicates(input);
    }

    public void testbed(){
        testcase1();
    }
    public static void main(String args[]){
        FindDuplicatesIn_O_N_time_n_O_1_space fn = new FindDuplicatesIn_O_N_time_n_O_1_space();
        fn.testbed();
    }

}
