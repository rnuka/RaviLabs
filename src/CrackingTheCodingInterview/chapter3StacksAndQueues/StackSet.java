package CrackingTheCodingInterview.chapter3StacksAndQueues;

import java.util.Stack;

/**
 * Created by rnuka on 10/15/15.
 */
/*
Question 3.3 Imagine a (literal) stack of plates. If the stack gets too high, it migh t topple. Therefore,
in real life, we would likely start a new stack when the previous stack exceeds some
threshold. Implement a data structure SetOfStacks that mimics this. SetOf-
Stacks should be composed of several stacks and should create a new stack once
the previous one exceeds capacity. SetOfStacks.push() and SetOfStacks.
pop () should behave identically to a single stack (that is, pop () should return the
same values as it would if there were just a single stack).
FOLLOW UP
Implement a function popAt(int index) which performs a pop operation on a
specific sub-stack.
 */
public class StackSet {

    Stack<Stack<Integer>> stackSet = new Stack<Stack<Integer>>();
    static final int MAX_LIMIT=3;

    //push
    void push(int data){
        Stack<Integer> currStack = null;
        //peek top stack
        if(!stackSet.isEmpty()) {
            currStack = stackSet.peek();
        }
        if(currStack != null && currStack.size() != MAX_LIMIT){
            currStack.push(data);
        }else{
            //create new stack if earlier one is full or for the very first time
            Stack<Integer> s = new Stack<Integer>();
            s.push(data);
            stackSet.push(s);
        }
    }

    //pop
    Integer pop(){
        //peek top stack
        Stack<Integer> currStack = stackSet.peek();
        if(!currStack.isEmpty()){
            int data = currStack.pop();
            //remove if empty
            if(currStack.size() == 0){
                stackSet.pop();
            }
            return data;
        }
        return null;
    }

    //test
    public static void main(String[] args){
        StackSet s = new StackSet();
        s.push(1);
        s.push(2);
        s.push(3);
        System.out.println("no of stacks now:" + s.stackSet.size());
        s.push(4);
        s.push(1);
        s.push(2);
        s.push(3);
        System.out.println("no of stacks now:" + s.stackSet.size());
        s.pop();
        System.out.println("no of stacks now:"+s.stackSet.size());
    }

}
