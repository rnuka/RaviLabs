package CrackingTheCodingInterview.chapter1ArraysNStrings;

/**
 * Created by rnuka on 10/8/15.
 */
/*
Question 1.7: Write an algorithm such that if an element in an MxN matrix is 0, its entire row
and column are set to 0.
 */
/*
Assumptions:
    1. All elements are integers
    2. M > 0 and N > 0
    3. Allowed to use additional storage
*/
public class ZeroMatrix {

    //sets entire row and column to 0 if intersection element is 0
    Integer[][] flush(Integer[][] input){
        Integer[][] output = new Integer[input.length][input[0].length];
        for(int i=0; i< input.length; i++){
            for(int j=0; j<input[0].length; j++){
                if (input[i][j] == 0) {
                    //set row elements to 0
                    for(int k=0; k< input[0].length ; k++)
                        output[i][k] = 0;

                    //set column elements to 0
                    for(int k=0; k< input[0].length ; k++)
                        output[k][j] = 0;
                }else{
                    if(output[i][j] == null)
                        output[i][j] = input[i][j];
                }
            }
        }
        return output;
    }

    //Print matrix
    void printImage(Integer[][] input){
        for(int i=0; i<input.length; i++) {
            System.out.println("");
            for (int j = 0; j < input.length; j++)
                System.out.print(" " + input[i][j]);
        }
    }

    //Test
    public static void main(String args[]){
        Integer[][] input = new Integer[4][4];
        int counter=0;
        for(int i=0; i<input.length; i++)
            for(int j=0; j<input.length; j++)
                input[i][j]=++counter;

        //override one element to 0
        input[1][2] = 0;

        ZeroMatrix zm = new ZeroMatrix();
        zm.printImage(input);
        System.out.println();
        zm.printImage(zm.flush(input));
    }
}
