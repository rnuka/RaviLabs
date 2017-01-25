package CrackingTheCodingInterview.chapter2LinkedLists;

/**
 * Created by rnuka on 10/15/15.
 */
/*
Question 2.5 You have two numbers represented by a linked list, where each node contains a
single digit. The digits are stored in reverse order, such that the Ts digit is at the
head of the list. Write a function that adds the two numbers and returns the sum
as a linked list.
EXAMPLE
Input: (7-> 1 -> 6) + (5 -> 9 -> 2).That is, 617 + 295.
Output: 2 -> 1 -> 9.That is, 912.
FOLLOW UP
Suppose the digits are stored in forward order. Repeat the above problem.
EXAMPLE
Input: (6 -> 1 -> 7) + (2 -> 9 -> 5).That is, 617 + 295.
Output: 9 -> 1 -> 2.That is, 912.
 */
public class SumList {
    //add two linkedlist nodes as sum
    Node sum2LinkedLists(Node first, Node second){
        System.out.println("inside sum list");
        int carry = 0;
        Node n1 = first;
        Node n2 = second;

        Node sumHead = null;

        while(n1 != null || n2 !=null) {

            int currentSum = carry;

            if(n1 != null) {
                currentSum += n1.data;
            }

            if(n2 != null) {
                currentSum += n2.data;
            }

            carry = currentSum > 10 ? 1 : 0;

            currentSum = currentSum % 10;

            Node n = new Node(currentSum);

            n.next = sumHead;
            sumHead = n;
            System.out.println("sum.data="+sumHead.data);

            n1 = n1.next;
            n2 = n2.next;
        }
        //if any carry is left after last sum
        if(carry > 0){
            Node n = new Node(carry);
            n.next = sumHead;
            sumHead = n;
        }
        return sumHead;
    }

    //test
    public static void main(String args[]){
        LinkedList ls = new LinkedList();
        ls.addAtTail(1);
        ls.addAtTail(3);
        ls.addAtTail(4);
        ls.print();
        System.out.println("");

        LinkedList ls2 = new LinkedList();
        ls2.addAtTail(2);
        ls2.addAtTail(4);
        ls2.addAtTail(9);
        ls2.print();
        System.out.println("");


        LinkedList ls3 = new LinkedList();
        SumList sl = new SumList();
        ls3.head = sl.sum2LinkedLists(ls.head, ls2.head);
        ls3.print();
    }

}
