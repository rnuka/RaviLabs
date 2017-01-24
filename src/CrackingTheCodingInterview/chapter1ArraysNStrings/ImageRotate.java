package CrackingTheCodingInterview.chapter1ArraysNStrings;

import java.util.Arrays;

/**
 * Created by rnuka on 10/7/15.
 */
/*
Question 1.6: Given an image represented by an NxN matrix, where each pixel in the image is
4 bytes, write a method to rotate the image by 90 degrees. Can you do this in
place?
 */
public class ImageRotate {

    //My Code::: with additional data structure

    //method takes NXN matrix as input and rotates
    int[][] rotate(int[][] input){

        int[][] output = new int[input.length][input.length];
        for(int i=0; i<input.length; i++)
            for(int j=0; j<input.length; j++)
                output[i][j] = input[input.length-1-j][i];
        return output;
    }

    //another solution
    public static int[][] rotation (int[][] input){
        int size = input.length;
        int[][] output = new int[size][size];
        for(int i = 0; i < input.length; i++){
            for(int j = 0; j< input.length; j++){
                //copy first row to nth column and second row to n-1th column and so on
                output[j][size-1-i] = input[i][j];
            }
        }
        return output;
    }


    //Book Code::: Without additional data structure (Optimized to remove offset and made more readable by adding left and right walls)
    public void rotate(int[][] matrix, int n) {
        for (int layer = 0; layer < n/2 ; ++layer) {
            int topLayer = layer;
            int bottomLayer = n - 1 - layer;
            int leftWall = topLayer;
            int rightWall = n - 1 - layer;

            for(int i = 0; i < (rightWall-leftWall); ++i) {

                // save top left value of current rotation
                int topLeft = matrix[topLayer][leftWall+i];

                // top left = bottom left
                matrix[topLayer][leftWall+i] = matrix[bottomLayer-i][leftWall];
                //matrix[first][i] = matrix[last-i][first];

                // bottom left = bottom right
                 matrix[bottomLayer-i][leftWall] = matrix[bottomLayer][rightWall - i];

                 //bottom right = top right
                 matrix[bottomLayer][rightWall - i] = matrix[topLayer+i][rightWall];

                 // top right = preserved top left
                 matrix[topLayer+i][rightWall] = topLeft;

                 //offset++;
                 }
             }
         }

    //Print matrix
    void printImage(int[][] input){
        for(int[] row : input){
            System.out.println(Arrays.toString(row));
        }
    }

    //Test
    public static void main(String args[]){
        int[][] input = new int[4][4];
        int counter=0;
        for(int i=0; i<input.length; i++)
            for(int j=0; j<input.length; j++)
                input[i][j]=++counter;


        ImageRotate ir = new ImageRotate();
        ir.printImage(input);
        System.out.println();
        //ir.printImage(ir.rotate(input));

        ir.rotate(input,4);

        ir.printImage(input);


    }
}
