package pinterest;

/**
 * Created by rnuka on 12/3/16.
 */
/*
Question: You’re given a board game which is a row of squares, each labeled with an integer.
This can be represented by a list, e.g.

[1, 3, 2, 0, 5, 2, 8, 4, 1]

Given a start position on the board, you “win” by landing on a zero,
 where you move by jumping from square to square either left or right the number of spaces
 specified on the square you’re currently on.

Your task is to implement the function:

def can_win(board, pos): returns True if you can win the board from that starting pos, False otherwise


 */
public class JumpGame {
    //using recursion
    public boolean canWin(int[] board, int pos){


        if(board == null || pos < 0 || board[pos] < 0){
         return false;
        }
        //true case
        if(board[pos]==0){
         return true;
        }

        //recursion case
        int leftPos = pos - board[pos];
        int rightPos = pos + board[pos];

        System.out.println(" pos="+pos+",board[pos]="+board[pos]+" leftPos="+leftPos+" , rightPos="+rightPos);


        if(leftPos >=0 && rightPos < board.length){
            return canWin(board,leftPos) || canWin(board, rightPos);
        }else if(leftPos >=0){
             return canWin(board,leftPos);
          }else if(rightPos < board.length){
             return canWin(board,rightPos);
        }
        return false;
    }

    public void testcase1(){
        int[] board = {1, 3, 2, 0, 5, 2, 8, 4, 1};
        for(int i=0; i<board.length; i++) {
            int pos = i;
            System.out.println(" ------------------- i="+i+" -------------------------");
            System.out.println("result for given board with start pos::" + pos + " is ::" + canWin(board, pos));
        }
    }

    public void testbed(){
        testcase1();
    }

    public static void main(String args[]){
        JumpGame j = new JumpGame();
        j.testbed();

    }


}
