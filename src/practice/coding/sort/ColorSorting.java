package practice.coding.sort;

import java.util.Arrays;

/*
Question: Given an array with n objects colored red, white or blue, sort them so that objects of the same color are adjacent,
 with the colors in the order red, white and blue.

Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.

Animation Link: http://www.cs.miami.edu/home/burt/learning/Csc517.101/workbook/countingsort.html

 */
public class ColorSorting {

    public void sortColors(int[] colors, int n){
        int[] counts = new int[n];

        //populate colors array counts of each color 0,1,2
        for(int i=0;i<colors.length;i++){
            int colorIndex = colors[i];
            counts[colorIndex]++;
        }

        System.out.println(Arrays.toString(counts)); //Java Library Feature

        //Update original array in sorted way
        int k=0;
        for(int i=0; i<n;i++){
            int indexColorCount = counts[i];
            if(indexColorCount>0) {
                for (int j = 0; j < indexColorCount; j++) {
                    colors[k++] = i;
                }
            }
        }
    }

    public void testcase1(){
        int[] input = {1,3,5,3,4,3,3,2,3,4,3,5,2,4,2,2};
        sortColors(input, 6);
        System.out.println(Arrays.toString(input));
    }

    public void testbed(){
        testcase1();
    }

    public static void main(String args[]){
        ColorSorting cs = new ColorSorting();
        cs.testbed();
    }

}
