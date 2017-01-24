package practice.coding.customDataStructures;

/**
 * Created by rnuka on 10/9/15.
 */
public class LinkedList {

    public static class Node{
        Node next;
        int data;

        //Constructor
        public Node(int data){
            this.data = data;
        }

        public int compareTo(Object o){
            Node that = (Node)o;
            if(this.data < that.data)
                return -1;
            if(this.data == that.data)
                return 0;
            return 1;
        }
    }


    Node head;

    //add at tail
    void addAtTail(int data){

        Node n = new Node(data);

        Node curr = head;

        if(head==null) {
            head = n;
            return;
        }

        while(curr.next != null)
            curr = curr.next;

        curr.next = n;
        return;
    }

    //delete
    Node deleteNode(Node head, int data){

        Node curr = head;

        if(curr.data == data ) {
            this.head = head.next;
            return this.head;
        }

        while(curr.next != null) {
            if(curr.next.data == data) {
                curr.next = curr.next.next;
                return head;
            }
            curr = curr.next;
        }
        return head;
    }

    Node sort(Node head){

        return this.head;
    }

    void print(){
        Node n = head;
        while(n != null){
            System.out.print(n.data+"->");
            n = n.next;
        }
    }
}
