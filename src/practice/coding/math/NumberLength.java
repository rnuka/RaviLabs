package practice.coding.math;

/**
 * Created by rnuka on 5/4/16.
 */
/*
* Input: array of length 6 with number 0 to 5 in random positions, and a input index is provided
* e.g. array{2,5,4,1,3,0} and input index = 3
* a[3]=1
* a[1]=5
* a[5]=0
* a[0]=2
* a[2]=4
* a[4]==3 (3 found after 6 lookups so return 6)
* */
public class NumberLength {
    public static int findLength(int[] arr, int index){
        int currentIndex = index%10;
        int target = (index<10)?Integer.parseInt(Integer.toString(index).substring(0,1)):Integer.parseInt(Integer.toString(index).substring(1,2));
        System.out.println("currentIndex="+currentIndex+" target="+target);
        if(arr[currentIndex]==target)
            return 1;
        index = (index<10)?Integer.parseInt("1"+String.valueOf(index)+arr[currentIndex]):Integer.parseInt(String.valueOf(index)+arr[currentIndex]);
        System.out.println("index="+index);
        return findLength(arr, index)+1;
    }

    public static void main(String args[]){
        int[] arr = {5,0,2,1,3,4};
        System.out.println("length = "+findLength(arr,0));
    }
}
