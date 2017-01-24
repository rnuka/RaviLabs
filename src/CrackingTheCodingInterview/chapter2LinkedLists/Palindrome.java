package CrackingTheCodingInterview.chapter2LinkedLists;

import java.util.Stack;

/**
 * Created by rnuka on 10/15/15.
 */
/*
Question 2.7 Implement a function to check if a linked list is a palindrome
 */
public class Palindrome {

    boolean isPalindrom(Node head){

        Node fast = head;
        Node slow = head;
        Stack<Node> stack = new Stack<Node>();

        //by the end of loop slow will be at middle element
        while(fast != null && fast.next != null){
            stack.add(slow);
            fast = fast.next.next;
            slow = slow.next;
        }

        //in this case slow is on exact middle element and length is odd so skip middle element
        if (fast != null){
            slow = slow.next;
        }

        //compare remaining slow elements from stack
        while(slow != null){
            if(slow.compareTo(stack.pop()) != 0){
                return false;
            }
            slow = slow.next;
        }
        return true;
    }

    public static void main(String[] args){

        LinkedList ls = new LinkedList();
        ls.addAtTail(1);
        ls.addAtTail(2);
        ls.addAtTail(1);
        ls.addAtTail(1);
        ls.print();
        //ls.deleteNode(ls.head, 1);
        System.out.println("");
        //ls.print();
        Palindrome pl = new Palindrome();
        //ls.head = kl.fromKthElement(ls.head, 5);
        System.out.println("is list palindrome::"+pl.isPalindrom(ls.head));

    }
}
