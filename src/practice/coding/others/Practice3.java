package practice.coding.others;

/**
 * Created by rnuka on 12/13/15.
 */
/*
i/p NXN matrix
o/p rotation of matrix by 90 degrees
 */
public class Practice3 {
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

    public static void main(String args[]){
        int[][] input = new int[3][3];
        int counter=0;
        for(int i = 0; i < input.length; i++){
            for(int j = 0; j< input.length; j++){
                input[i][j]=++counter;
            }
        }

        //print input
        System.out.println("input::");
        for(int i = 0; i < input.length; i++){
            for(int j = 0; j< input.length; j++){
                System.out.print(input[i][j]);
            }
            System.out.println();
        }

        //print output
        int[][] output = new int[3][3];
        output = rotation(input);
        System.out.println("output::");
        for(int i = 0; i < output.length; i++){
            for(int j = 0; j< output.length; j++){
                System.out.print(output[i][j]);
            }
            System.out.println();
        }

    }
}
