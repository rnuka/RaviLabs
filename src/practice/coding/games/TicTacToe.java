package practice.coding.games;

/**
 * Created by rnuka on 10/17/15.
 */
/*
input: matrix with X and O
output: if there is a TIC-TAC-TOE game winner return true otherwise false
 */
public class TicTacToe {

    public boolean winnerExists(char[][] board){

        //declare
        char prevCol, prevRow, prevDiag1, prevDiag2;
        boolean colWinner, rowWinner, diagWinner1, diagWinner2;

        //traverse board

        //diagnol check is kept outside as it is based on both loops
        prevDiag1 = board[0][0];
        prevDiag2 = board[0][board.length-1-0];
        diagWinner1 = true;
        diagWinner2 = true;

        for(int i = 0; i < board.length; i++){

            //row check and column check is done by inner loop so initialized here
            prevRow = board[i][0];
            prevCol = board[0][i];
            colWinner = true;
            rowWinner = true;

            for(int j = 0; j < board[i].length; j++){

                //row check
                if(board[i][j] != prevRow){
                    rowWinner = false;
                }

                //column check
                if(board[j][i] != prevCol){
                    colWinner = false;
                }
            }

            //winner check
            if(rowWinner) {
                System.out.println("row winner");
                return true;
            } else if(colWinner) {
                System.out.println("colWinner");
                return true;
            }

            //diagnol1 check
            if(board[i][i] != prevDiag1){
                diagWinner1 = false;
            }

            //diagnol2 check
            if(board[i][board.length-1-i] != prevDiag2){
                diagWinner2 = false;
            }
        }

        if(diagWinner1) {
            System.out.println("diagWinner1");
            return true;
        }else if(diagWinner2) {
            System.out.println("diagWinner2");
            return true;
        }
        else{
            System.out.println("no winner");
            return false;
        }
    }

    //print board
    public void printBoard(char[][] board){
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[i].length; j++) {
                System.out.print(" "+board[i][j]);
            }
            System.out.println("");
        }
    }

    //test
    public static void main(String[] args){
        int n = 3; //size
        char[][] board = new char[n][n];
        //populate board randomly
        for(int i=0; i<n;i++){
            for(int j=0; j<n; j++){
                double randVal = Math.random();
                if(randVal > 0.5){
                    board[i][j]='X';
                }else{
                    board[i][j]='O';
                }
            }
        }

        //print board
        TicTacToe tc = new TicTacToe();
        tc.printBoard(board);
        tc.winnerExists(board);
    }
}
