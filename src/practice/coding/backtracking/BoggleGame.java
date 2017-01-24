package practice.coding.backtracking;

import java.util.*;

/**
 * Created by rnuka on 7/9/16.
 */
/*
* Given a MXN board and dictionary of words, find all possible words from boggle
* Rule: search for words that can be constructed from the letters of sequentially adjacent cubes,
*       where "adjacent" cubes are those horizontally, vertically, and diagonally neighboring
 */
public class BoggleGame {
    Map<String, Integer> dictionary = new HashMap<String,Integer>();
    char[][] board  ={  {'a','b','c','d'},
                        {'n','t','i','p'},
                        {'k','n','g','e'},
                        {'o','s','u','a'}
                     };

    //Constructor
    public BoggleGame(String dictionaryFilepath, int M, int N){

        //Load dictionary or load from file path
        dictionary.put("ant", 1);
        dictionary.put("tank", 2);
        dictionary.put("pig", 1);
        dictionary.put("gun", 1);
        dictionary.put("tic", 1);
        dictionary.put("bank", 2);
        dictionary.put("pea", 1);
        dictionary.put("pit", 1);
        dictionary.put("azure", 3);
        dictionary.put("dazzle", 4);

        //Load boggle board
        /*board = new char[M][N];
        for(int i=0; i<M; i++){
            for(int j=0; j<N; j++){
                Random rn = new Random();
                int letter = rn.nextInt(26)+1;
                //add 96 to start lowercase ascii from 97 onwards.
                board[i][j] = (char)(letter+96);
            }
        }*/


        //print boggle board
        System.out.println("**********  Boggle board  **************");
        for(int i=0; i<M; i++){
            for(int j=0; j<N; j++){
                System.out.print(board[i][j]+" ");
            }
            System.out.println();
        }
    }

    List<String> results = new ArrayList<String>();

    //solver
    public void boggleWords(char[][] board){

        //handle null board case
        if(board == null){
            return;
        }

        //valid baord scenarios
        int rows = board.length;
        int cols = board[0].length;


        boolean[][] flagBoard = new boolean[rows][cols];

        //loop through all letters and see if you can form valid words
        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                flagBoard[i][j]=true;
                solve(board,flagBoard, rows, cols, i, j, ""+board[i][j]);
            }
        }
    }

    public void solve(char[][] board, boolean[][] flagboard, int rows, int cols, int curri, int currj, String buffer){

    }

    public static void main(String args[]){
        BoggleGame bg = new BoggleGame("test",5,5);

    }
}
