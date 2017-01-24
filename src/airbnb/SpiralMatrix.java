package airbnb;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;

/**
 * Created by rnuka on 5/27/16.
 */
public class SpiralMatrix {

    public static void printSpiral(String filePath){
        int i=0;
        int rows = 0;
        int cols = 0;
        String input;
        int[][] inputArray = null;
        try {
            //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedReader br = new BufferedReader(new FileReader(filePath));
            while ((input = br.readLine()) != null) {
                //first row
                if (i == 0) {
                    //initialize matrix
                    String[] sarray = input.split(",");
                    rows = Integer.parseInt(sarray[0]);
                    cols = Integer.parseInt(sarray[1]);
                    inputArray = new int[rows][cols];
                } else {
                    String[] row = input.split(",");
                    int j=0;
                    for(String s: row){
                        inputArray[i - 1][j] = Integer.parseInt(s);
                        j++;
                    }
                }
                i++;
            }
        }catch(Exception e){
            e.printStackTrace();
        }

        System.out.println("");
        //print matrix
        for(int p=0; p<rows; p++){
            for(int j=0;j < cols; j++){
                System.out.print(" "+inputArray[p][j]);
            }
            System.out.println("");
        }
        System.out.println("");

        //print spiral matrix now
        int tops=((cols/2+cols%2)>=(rows/2))?(rows/2):(cols/2+cols%2);
        int total = cols*rows;


        int offset = 0;
        int counter = 0;
        while(offset <= tops ){
            //System.out.println("inside tops="+offset);
            //print tops
            for(int k=offset; k<(cols-offset); k++){
                if(counter<total) {
                    System.out.print(" T" + inputArray[offset][k]);
                    counter++;
                }
            }

            //print rights
            for(int k=(offset+1);k<(rows-offset); k++){
                if(counter<total) {
                    System.out.print(" R" + inputArray[k][cols - offset - 1]);
                    counter++;
                }
            }

            //print downs
            for(int k=(cols-offset-2);k>=offset; k--){
                if(counter<total) {
                    System.out.print(" D" + inputArray[rows - offset - 1][k]);
                    counter++;
                }
            }

            //print lefts
           // System.out.println("counter="+counter);
            for(int k=(rows-offset-2);k>offset; k--){
                if(counter<total) {
                    System.out.print(" L" + inputArray[k][offset]);
                    counter++;
                }
            }


            offset++;

        }
        System.out.println("");
    }

    protected static void testSingleRowCol(){
        System.out.println();
        System.out.println("----spiral matrix single row-----");
        System.out.println();

        printSpiral("/Users/rnuka/test/test3.txt");

        System.out.println();
        System.out.println("----spiral matrix single column-----");
        System.out.println();
        printSpiral("/Users/rnuka/test/test4.txt");
    }

    protected static void testbasic(){
        System.out.println();
        System.out.println("----spiral matrix basic testcases-----");
        System.out.println();
        printSpiral("/Users/rnuka/test/test1.txt");
        printSpiral("/Users/rnuka/test/test.txt");
    }

    protected static void testbed(){
        testbasic();
        testSingleRowCol();
    }

    public static void main(String[] args){
        testbed();
    }
}
