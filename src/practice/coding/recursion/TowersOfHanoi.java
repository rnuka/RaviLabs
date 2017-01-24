package practice.coding.recursion;

import java.util.Stack;

/**
 * Created by rnuka on 3/28/16.
 */
public class TowersOfHanoi {

    //method to move discs
    public void moveDiscs(int size, Stack<Integer> source, Stack<Integer>  buffer, Stack<Integer>  destination) {

        //base case
        if(size == 1){
            int top = source.pop();
            //System.out.println("top is "+top);
            destination.push(top);
            return;
        }

        //part-1 move n-1 discs to buffer
        moveDiscs(size-1,source,destination, buffer);



        //part-2 move nth disc
        int largest = source.pop();
        System.out.println("largest is "+largest);
        destination.push(largest);

        //part-3 move n-1 discs to target
        moveDiscs(size-1,buffer,source,destination);
    }

    public static void main(String args[]){
        Stack<Integer> A = new Stack<Integer>();
        Stack<Integer> B = new Stack<Integer>();
        Stack<Integer> C = new Stack<Integer>();

        A.push(4);
        A.push(3);
        A.push(2);
        A.push(1);
        TowersOfHanoi toh = new TowersOfHanoi();

        toh.print(A);


        A.push(4);
        A.push(3);
        A.push(2);
        A.push(1);
        toh.moveDiscs(4, A, B, C);

        //print target
        toh.print(C);


    }

    public void print(Stack<Integer> s){
        //print source

        int size = s.size();
        for(int i =0; i<size; i++){
            int top = s.pop();
            System.out.println("top="+top);
        }
    }





}
