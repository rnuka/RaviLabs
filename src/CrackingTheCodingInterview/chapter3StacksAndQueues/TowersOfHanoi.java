package CrackingTheCodingInterview.chapter3StacksAndQueues;

import java.util.Stack;

/**
 * Created by rnuka on 10/15/15.
 */
/*
Question 3.4 In the classic problem of the Towers of Hanoi, you have 3 towers and N disks of
different sizes which can slide onto any tower. The puzzle starts with disks sorted
in ascending order of size from top to bottom (i.e., each disk sits on top of an even
larger one). You have the following constraints:
(T) Only one disk can be moved at a time.
(2) A disk is slid off the top of one tower onto the next rod.
(3) A disk can only be placed on top of a larger disk.
Write a program to move the disks from the first tower to the last using Stacks.
 */
public class TowersOfHanoi {

    //for given 3 towers with one source move all n disks from source to destination using a buffer
    void moveDisks(int n, Stack origin, Stack destination, Stack buffer){
        //base case
        if(n <= 0){
            return;
        }

        Integer top = null;
        if(!origin.isEmpty()) {
            top = (Integer) origin.pop();
        }
        //System.out.println("n is"+n);


        //move n-1 disks from origin to buffer using destination as temp space
        moveDisks(n - 1, origin, buffer, destination);
        destination.push(top); //take n from origin and push
        System.out.println("pushing" + destination.peek());
        moveDisks(n-1, buffer, destination, origin);
    }

    //test
    public static void main(String args[]){
        int NUM_OF_DISKS = 3;
        Stack<Integer> origin = new Stack<Integer>();
        Stack<Integer> buffer = new Stack<Integer>();
        Stack<Integer> destination = new Stack<Integer>();
        for (int i = 1; i <= NUM_OF_DISKS; i++){
            origin.push(i);
            System.out.println("origina element"+origin.peek());
        }

        TowersOfHanoi toh = new TowersOfHanoi();
        toh.moveDisks(NUM_OF_DISKS, origin, buffer, destination);
        System.out.println("destination size=" + destination.size());
        while(!destination.isEmpty()) {
            System.out.println("desination element::"+destination.pop());
        }
    }
}
