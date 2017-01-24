package practice.coding.arrays;

/**
 * Created by rnuka on 12/2/16.
 */
/*
* Given an array of size MxN print the diagonals
* Note: Optimal Solution is in main method below.
* */
public class PrintArrayDiagnolly {

        //TODO: Testing pending
        public void printDiagnolly(int[][] input){
                int rows = input.length;
                int columns = input[0].length;
                int count = 0;
                int i = rows -1 ;
                int j = 0, row,col;
                while(count < rows * columns){
                    row = i;
                    col = j;

                    while(i < rows && j < columns){
                        System.out.print(input[i][j]);
                        i++;
                        j++;
                        count++;
                    }

                    i = (row-1 >= 0) ? row-1 : 0;
                    j = (row-1 >= 0 ) ? 0 : col+1;


                }
        }

        public void testcase1(){
                int[][] input = {
                        {1,2,3,4},
                        {5,6,7,8},
                        {9,10,11,12}
                };
                printDiagnolly(input);
        }

        public void testbed(){
                testcase1();
        }

        public static void main(String args[]){
            PrintArrayDiagnolly p = new PrintArrayDiagnolly();
            //p.testbed();


            int n = 3;
            int m = 4;
            int arr[][] = new int[n][m];
            arr[0] = new int[] { 1, 2, 3, 4 };
            arr[1] = new int[] { 5, 6, 7, 8 };
            arr[2] = new int[] { 9, 10, 11, 12 };

            //ist=>i_start
            //jst=>j_start
            int i=n-1,j=0,ist,jst,count=0;
            while(count<n*m){
                ist=i;jst=j;
                while(i<n && j<m){
                    System.out.print(arr[i][j]+" ");
                    count++;
                    i++;j++;
                }
                System.out.println();
                i=(ist-1)>=0?ist-1:0;
                //j=(jst==0 && (ist-1)>=0)?0:jst+1;
                j=(ist-1)>=0?0:jst+1;
            }

        }
}
