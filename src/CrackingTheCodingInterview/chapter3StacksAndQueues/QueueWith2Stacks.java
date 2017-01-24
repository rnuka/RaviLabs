package CrackingTheCodingInterview.chapter3StacksAndQueues;

import java.util.Stack;

/**
 * Created by rnuka on 10/16/15.
 */
/*
Question: 3.5 Implement a MyQueue class which implements a queue using two stacks.
 */
public class QueueWith2Stacks<T> {
    Stack<T> enqueueStack, dequeueStack;

    //constructor
    public QueueWith2Stacks(){
        enqueueStack = new Stack<T>();
        dequeueStack = new Stack<T>();
    }

    //dequeue()
    public T dequeue(){
        //if dequeue stack is empty then copy elements from second stack and update first stack
        if(dequeueStack.isEmpty()){
            while(!enqueueStack.isEmpty()){
                dequeueStack.push(enqueueStack.pop());
            }

        }

        if(!dequeueStack.isEmpty()){
            return dequeueStack.pop();
        }
        return null;
    }

    //enqueue()
    public void enqueue(T data){
        enqueueStack.push(data);
    }

    //size()
    public int size(){
        return enqueueStack.size() + dequeueStack.size();
    }

    //test
    public static void main(String[] args){
        QueueWith2Stacks queue = new QueueWith2Stacks();
        queue.enqueue(1);
        queue.enqueue("rvi");
        System.out.println("size=" + queue.size());
        queue.enqueue(3);
        System.out.println("next pop=" + queue.dequeue());
        System.out.println("next pop="+queue.dequeue());
        System.out.println("next pop="+queue.dequeue());
        System.out.println("next pop="+queue.dequeue());

    }
}
