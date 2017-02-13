package CrackingTheCodingInterview.chapter3StacksAndQueues;

import java.util.Stack;

/**
 * Created by rnuka on 10/15/15.
 */
/*
Question 3.2 How would you design a stack which, in addition to push and pop, also has a
function min which returns the minimum element? Push, pop and min should all
operate in 0(1) time.
 */
public class MinimumStack extends Stack<Integer> {

    Stack<Integer> minStack;

    public MinimumStack() {
        minStack = new Stack<Integer>();
    }


    //push
    public void push(int data){
        if(minStack == null || data < min()){
            minStack.push(data);
        }
        super.push(data);
    }

    //pop with min functionality
    public Integer pop(){
        int temp = pop();
        if(temp == min()){
            minStack.pop();
        }
        return temp;
    }

    //return minimum element from the stack
    int min(){
        if(minStack.isEmpty()){
            return Integer.MAX_VALUE;
        }else {
            return minStack.peek();
        }
    }

    //test
    public static void main(String[] args){
        MinimumStack se = new MinimumStack();
        se.push(10);
        se.push(2);
        se.push(5);
        se.push(1);
        System.out.println("min=" + se.min());
        se.pop();
        System.out.println("min=" + se.min());
    }


}
