/**
 * Created by rnuka on 2/2/16.
 */

public class RotateMatrix{
    /*input: NXN matrix
              output: NXN matrix
           */
    static int[][] rotate(int[][] input, int size){
        int[][] output = new int[size][size];
        //int colOffset = 0;
        for(int i=0; i<size; i++){
            //int rowOffset = 0;
            for(int j=0; j<size; j++){
                output[j][(size-1)-i] = input[i][j];
                //rowOffset++;

            }
            //colOffset++;
        }

        return output;

    }

    public static void main(String args[]){
        int[][] input = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        int[][] output = null;
        int size =4;
        output = rotate(input, size);

        for(int i=0; i<size; i++){
            for(int j=0; j<size; j++){
                System.out.print(" "+output[i][j]);

            }
            System.out.println();
        }
    }


}
