package CrackingTheCodingInterview.chapter3StacksAndQueues;

import java.util.Stack;

/**
 * Created by rnuka on 10/16/15.
 */
/*
3.6 Write a program to sort a stack in ascending order (with biggest items on top).
You may use at most one additional stack to hold items, but you may not copy the
elements into any other data structure (such as an array). The stack supports the
following operations: push, pop, peek, and isEmpty.
 */
public class StackSort {

    //take stack as input and sort
    public Stack<Integer> sort(Stack<Integer> stack){
        Stack<Integer> outputStack = new Stack<Integer>();

        //loop through stack and take top to the temp and compare with top
        // from output stack and shuffle accordingly as if in disks in towers of hanoi(but here just 2 towers)
        while(!stack.isEmpty()){
            int top = stack.pop();
            if(!outputStack.isEmpty()) {
                while (top < outputStack.peek()){
                    stack.push(outputStack.pop());
                }
            }
            outputStack.push(top);
        }
        return outputStack;
    }

    //test
    public static void main(String[] args) {
        Stack<Integer> inputStack = new Stack<Integer>();
        inputStack.push(4);
        inputStack.push(2);
        inputStack.push(6);
        inputStack.push(1);
        StackSort stkSort = new StackSort();

        inputStack = stkSort.sort(inputStack);

        while(!inputStack.isEmpty()){
            System.out.println("top is"+inputStack.pop());
        }

    }
}
