package CrackingTheCodingInterview.chapter2LinkedLists;

/**
 * Created by rnuka on 10/15/15.
 */
public class ReverseLinkedList {

    //given head node returns a new head node with reverse list
    Node reverse(Node head){
        Node n = head;
        Node reverse = null;
        while(n != null){
            Node next = n.next; //preserve next node in temp
            n.next = reverse;
            reverse = n;
            n = next;
        }
        return reverse;
    }

    //test
    public static void main(String args[]){
        LinkedList ls = new LinkedList();
        ls.addAtTail(1);
        ls.addAtTail(3);
        ls.addAtTail(4);
        ls.addAtTail(2);
        ls.addAtTail(6);
        ls.addAtTail(5);
        ls.print();
        //ls.deleteNode(ls.head, 1);
        System.out.println("");
        //ls.print();
        ReverseLinkedList rl = new ReverseLinkedList();
        ls.head = rl.reverse(ls.head);
        ls.print();
    }
}
