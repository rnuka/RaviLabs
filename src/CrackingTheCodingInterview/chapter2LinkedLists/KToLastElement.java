package CrackingTheCodingInterview.chapter2LinkedLists;

/**
 * Created by rnuka on 10/9/15.
 */
/*
Question 2.2: Implement an algorithm to find the kth to last element of a singly linked list.
 */
public class KToLastElement {

    //My Code: Wrong interpretation of question, thought need to print from K to last element
    //but as per book solution, it is (list.length-K)th i.e. Kth element from last


    //return elements from K position till end with new head
    Node fromKthElement(Node head, int k){
        Node n = head;
        int count = 0;
        while(n != null){
            if(++count == k){
                head = n; //assign new head i.e. kth element
                return head;
            }
            n = n.next;
        }
        return null; //when k is greater than list size return null
    }

    //Book Code: using recursion
    int KthElementFromEnd(Node head, int k){
        if(head == null)
            return 0;
        int i = KthElementFromEnd(head.next, k) + 1;
        if(i == k){
            System.out.println("Kth element is"+head.data);
        }
        return i;
    }

    //Book Code: using iteration
    Node KthNodeFromEnd(Node head, int k){
        Node fast = head;
        Node slow = head;

        int count = 1;
        //Move fast node till goes K elements
        for(int i=1 ; i < k; i++){
            if(fast.next == null) return null;
            fast = fast.next;
        }



        //Now move fast and slow elements and by the time fast is at the end slow is at (length-K)th element.
        while(fast.next != null){
            fast = fast.next;
            slow = slow.next;
        }

        return slow;

    }

    //test
    public static void main(String args[]){
        LinkedList ls = new LinkedList();
        ls.addAtTail(1);
        ls.addAtTail(2);
        ls.addAtTail(3);
        ls.addAtTail(1);
        ls.print();
        //ls.deleteNode(ls.head, 1);
        System.out.println("");
        //ls.print();
        KToLastElement kl = new KToLastElement();
        //ls.head = kl.fromKthElement(ls.head, 5);
        //kl.KthElementFromEnd(ls.head, 7);
        System.out.println("kth element = " + kl.KthNodeFromEnd(ls.head, 3).data);
        //ls.print();
    }
}
