package practice.coding.backtracking;

import java.util.*;

/**
 * Created by rnuka on 11/12/16.
 */
/*
* Question: Given a board of NXN chess board, return the positions of N queens to be placed.
* 1. Start from 0,0 position and see if the queen can be placed, if yes go to step-2 otherwise go to 0,1
*       and then to 0,2 and so on until 0,n
* 2. If yes in step-1, then go to 1,0 and traverse 1,0 to 1,N and see if the next queen can be placed
* 3. If total queens = N, then save the position of queens in results.
*
* example: 8X8 Chess board
* output: [(0,0),(1,2),(2,4), (3,6), (4,1), (5,3), (6,5), (7,7)] etc (all possible combinations)
* */
public class NQueen {

    public List<int[]> solveBoard(int N){
        List<int[]> results = new ArrayList();
        int[] currentBoard = new int[N];

        //initialize currentBoard to -1
        Arrays.fill(currentBoard,-1);

        placeQueens(N, results, currentBoard, 0);
        return results;
    }

    private void placeQueens(int N, List<int[]> results,
                            int[] currentBoard, int currentQueen){


        if(currentQueen==N){ //base case, placed all queens
            results.add(currentBoard.clone());
        }else { //otherwise
            for (int col = 0; col < N; col++) {
                if (validate(currentQueen, col, currentBoard)) {
                    currentBoard[currentQueen] = col;
                    placeQueens(N, results, currentBoard, currentQueen + 1);
                }

            }
        }



    }

    boolean validate(int currentQueen, int targetColumn, int[] currentBoard ){

        for(int row=0; row<currentQueen; row++){
            //if targetColumn  has a queen previously
            if(currentBoard[row]==targetColumn){
                return false;
            }

            //if (x,y) (currentQueen i.e. row, targetColumn) has diagonal queens previously
            if(Math.abs(currentQueen-row)==Math.abs(currentBoard[row]-targetColumn)){
                return false;
            }
        }

        return true;
    }


    public static void main(String args[]){
        NQueen n= new NQueen();
        int N =4;
        List<int[]> results = n.solveBoard(N);

        //print all positions
        for(int[] currentSet: results){
            for(int i=0; i<N; i++){
                System.out.print("-->"+currentSet[i]);
            }
            System.out.println("******");
        }

    }
}
