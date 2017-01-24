package CrackingTheCodingInterview.chapter2LinkedLists;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by rnuka on 10/9/15.
 */
/*
Question 2.1: Write code to remove duplicates from an unsorted linked list.
FOLLOW UP
How would you solve this problem if a temporary buffer is not allowed?
 */
public class RemoveDuplicates{

    //My code is close to book code, so book code not copied here
    //remove duplicates by using a list as buffer to check
    void removeDuplicates(Node head){
        if(head == null)
            return;
        Node n = head;
        Set<Integer> buffer = new HashSet<Integer>(); //buffer to check against for duplicates
        buffer.add(n.data);
        while(n.next != null){
            if(buffer.contains(n.next.data)) {
                n.next = n.next.next; //skip duplicate element
            }else {
                buffer.add(n.next.data); //add new element to buffer
                n = n.next;
            }
        }
    }

    public static void main(String args[]){
        LinkedList ls = new LinkedList();
        ls.addAtTail(1);
        ls.addAtTail(2);
        ls.addAtTail(3);
        ls.addAtTail(2);
        ls.addAtTail(3);
        ls.addAtTail(1);
        ls.print();
        System.out.println("");
        RemoveDuplicates rd = new RemoveDuplicates();
        rd.removeDuplicates(ls.head);
        ls.print();
    }

}
