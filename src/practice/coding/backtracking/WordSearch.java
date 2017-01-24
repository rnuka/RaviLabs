package practice.coding.backtracking;

/*
Given a 2D board and a word, find if the word exists in the grid.

The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those
horizontally or vertically neighboring. The same letter cell may not be used more than once.

For example, given board =

[
  ["ABCE"],
  ["SFCS"],
  ["ADEE"]
]
word = "ABCCED", -> returns true,
word = "SEE", -> returns true,
word = "ABCB", -> returns false.
 */
public class WordSearch {

    //use backtracking approach: Time Complexity: O(n^2 * length(targetWord))
    boolean findWord(char[][] board, String word){

        if(board==null){
            return false;
        }

        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[0].length; j++){
                if(dfs(board,word,  i, j, 0)){
                    return true;
                }
            }
        }

        return false;
    }

    boolean dfs(char[][] board, String word, int row, int col, int position){

        //Invalid row or col positions
        if(row < 0 || row >= board.length || col < 0 || col >= board[0].length){
            return false;
        }

        if(board[row][col]==word.charAt(position)){ //partial success case

            if(position == word.length()-1){ //success case
                return true;
            }

            //mark incoming row, col cell to invalid symbol so that it will not be considered again
            char temp = board[row][col];
            board[row][col]='#';

            if ( dfs(board,word,row-1,col,position+1)
                 ||   dfs(board,word,row+1,col,position+1)
                 ||   dfs(board,word,row,col-1,position+1)
                 ||   dfs(board,word,row,col+1,position+1)){
                return true;
            }

            //revert # to original character for next runs
            board[row][col]=temp;

        }

        return false;
    }

    public void testcase1() {
        char[][] board = {
                            {'A', 'B', 'C', 'E'},
                            {'S', 'F', 'C', 'S'},
                            {'A', 'D', 'E', 'E'}
                        };
        /*String target1 = "ABX";
        System.out.println("target1 present in board true/false ? ::"+findWord(board,target1));

        String target2 = "ABCXCED";
        System.out.println("target2 present in board true/false ? ::"+findWord(board,target2));

        String target3 = "ABCCED";
        System.out.println("target3 present in board true/false ? ::"+findWord(board,target3));
        */

        String target4 = "SEE";
        System.out.println("target4 present in board true/false ? ::"+findWord(board,target4));

        /*
        String target5 = "ABCB";
        System.out.println("target5 present in board true/false ? ::"+findWord(board,target5));
        */
    }

    public void testbed(){
        testcase1();
    }

    public static void main(String args[]){
        WordSearch w = new WordSearch();
        w.testbed();
    }
}
