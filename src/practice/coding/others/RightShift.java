package practice.coding.others;

/**
 * Created by rnuka on 10/19/15.
 */
/*
input: an array of integers and M positions to right shift
output: shifted array
 */
public class RightShift {

    /*
    step-1: reverse the input array by swapping all elements (in 1 iteration swap first with last and so on)
    step-2: reverse 0 to M
    step-3: reverse M to Length
     */
    int[] rShift(int[] arr, int m){
        return(reverse(reverse(reverse(arr, 0, arr.length),0,m),m,arr.length));
    }

    //reverse
    public int[] reverse(int[] arr, int low, int high){
        for(int i=low; i<=high/2; i++){
            int temp = arr[low];
            arr[low] = arr[high];
            arr[high] = temp;
        }
        return arr;
    }

    //test
    public static void main(String[] args){

    }
}
