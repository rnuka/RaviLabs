package CrackingTheCodingInterview.chapter2LinkedLists;

/**
 * Created by rnuka on 10/10/15.
 */
/*
Question 2.3: Implement an algorithm to delete a node in the middle of a singly linked list,
given only access to that node.
EXAMPLE
Input: the node c from the linked list a->b->c->d->e
Result: nothing is returned, but the new linked list looks like a- >b- >d->e
 */
public class DeleteMiddle {


    //My Code: Wrong interpretation of question, head is not provided and
    // element to delete is not exact middle element - so ZERO score

    //Delete middle element and return new head if head gets modified
    Node deleteMiddle(Node head){

        if(head != null && head.next == null) {
            head = null;
            return head;
        }

        Node fast = head;
        Node slow = head;
        while(fast!= null && fast.next != null){
            fast = fast.next.next;
            if(fast != null && fast.next != null)
                slow = slow.next;
        }
        if(slow.next != null) {
            slow.next = slow.next.next;
        }
        return head;
    }

    //Book Code
    boolean deleteElement(Node n){

        //we cannot delete if element is null or if it is last element of linkedlist
        if(n==null || n.next == null){
            return false;
        }
        n.data = n.next.data;
        n.next = n.next.next;
        return true;
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
        DeleteMiddle dm = new DeleteMiddle();
        //ls.head = dm.deleteMiddle(ls.head);
        dm.deleteElement(ls.head.next.next);
        ls.print();
    }
}
