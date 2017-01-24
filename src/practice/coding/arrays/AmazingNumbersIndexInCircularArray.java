package practice.coding.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Define amazing number as: its value is less than or equal to its index. Given a circular array,
find the starting position, such that the total number of amazing numbers in the array is maximized.
Example 1: 0, 1, 2, 3
Ouptut: 0. When starting point at position 0, all the elements in the array are equal to its index.
So all the numbers are amazing number.
Example 2: 1, 0 , 0
Output: 1. When starting point at position 1, the array becomes 0, 0, 1. All the elements are amazing number.
If there are multiple positions, return the smallest one.

should get a solution with time complexity less than O(N^2)

Explanation: https://www.careercup.com/question?id=6018738030641152
 */
public class AmazingNumbersIndexInCircularArray {


    //brute-force approach O(n^2)
    int getMaxAmazingNumbersPositionBf(int[] input){
        int maxAmazingNumbersIndex = 0; int maxAmazingNumbers=0;
        for(int i=0; i<input.length; i++){
            int amazingNumbersCount = 0;
            for(int j=i; j<i+input.length; j++){
                if(input[j%input.length]<=(j-i)){
                    amazingNumbersCount++;
                }
            }
            if(amazingNumbersCount>maxAmazingNumbers){
                maxAmazingNumbers = amazingNumbersCount;
                maxAmazingNumbersIndex = i;
            }
        }
        return maxAmazingNumbersIndex;
    }


    //Optimal Solution: O(n)
    int getMaxAmazingNumbersPosition(int[] input){
         /*class Interval{
            int startIndex;
            int endIndex;
            public Interval(int s, int e){
                startIndex = s;
                endIndex = e;
            }
         }*/

        //Traverse array and add inputs to the interval list
        //List<Interval> intervals = new ArrayList<>();
        int length = input.length;
        int[] count = new int[length];
        for(int i=0; i<length; i++){
            //for current element to be an amazing number it is possible only when numbers are less than or equal to length-1
            if(!(input[i]>length-1)){
                int start = (i+1)%(length);//next available index
                int end =   (i+(length-input[i]))%length;//Tricky part: i + offset(n-input[i])
                //int end = (length + (i - input[i])) % length;
                //Interval interval = new Interval(start, end);
                count[start]++;
                if(end+1<(length)){
                    count[end+1]--;
                }
                //count[(end+1)%(length-1)]--;
            }
        }

        int maxCount = 0;
        int maxIndex = -1;
        int sum = 0;
        for(int i=0; i<count.length; i++){
            sum+=count[i];
            if(sum>maxCount){
                maxCount=sum;
                maxIndex=i;
            }
        }
        return maxIndex;
    }

    public void testOptimal(int[] input){
        System.out.println("Amazing index(Optimal) for input" + Arrays.toString(input) + " is::" + getMaxAmazingNumbersPosition(input));
    }


    public void test(int[] input){
        System.out.println("Amazing index for input" + Arrays.toString(input) + " is::" + getMaxAmazingNumbersPositionBf(input));
    }



    public void testbed(){
        test(new int[]{4, 2, 8, 2, 4, 5, 3});
        test(new int[]{1, 2, 3, 4, 5, 6, 7});
//        test(new int[]{});
//        test(new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1});
//        test(new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0});
//        test(new int[]{1});
//        test(new int[]{1,2});
//        test(new int[]{1, 2, 3, 4, 5, 1, 2, 9, 10, 11, 1, 2, 3, 4, 5, 6});
        testOptimal(new int[]{4, 2, 8, 2, 4, 5, 3});
        testOptimal(new int[]{1, 2, 3, 4, 5, 6, 7});
    }

    public static void main(String args[]){
        AmazingNumbersIndexInCircularArray a = new AmazingNumbersIndexInCircularArray();
        a.testbed();
    }

}
