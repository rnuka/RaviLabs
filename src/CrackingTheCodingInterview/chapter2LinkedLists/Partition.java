package CrackingTheCodingInterview.chapter2LinkedLists;

/**
 * Created by rnuka on 10/11/15.
 */
/*
Question 2.4:: Write code to partition a linked list around a value x, such that all nodes less than
x come before all nodes greater than or equal to x.
 */
/*
Assumption: All elements are unique
*/
public class Partition {

    //partition based in key value passed and return head of modified list
    Node partition(Node head, int data){
        Node n = head;

        //swap the key node as pivot/head if exists
        head = swap(head, head.data, data);


        System.out.println("parition begins");

        //using two counters complete the partition
        Node pivot = head;
        Node i = head;
        Node j = head;

        while(j.next != null){
            if(j.next.data < pivot.data ){
                //head = swap(head, i.next.data, j.next.data);
                System.out.println("swapping j.data="+j.data+" and i.data="+i.data);
                int temp = i.next.data;
                i.next.data = j.next.data;
                j.next.data = temp;
                i = i.next;
            }
            j = j.next;
        }

        int temp = i.data;
        i.data = pivot.data;
        pivot.data = temp;

        return head;

    }

    Node swap(Node head, int from, int to){
        Node n1 = head;
        while(n1 != null){
            if(n1.data == from){
                break;
            }
            n1 = n1.next;
        }

        Node n2 = head;
        while(n2 != null){
            if(n2.data == to){
                break;
            }
            n2 = n2.next;
        }

        n1.data = to;
        n2.data = from;

        return head;
    }


    //Book Code:
    Node partition2(Node head, int k) {
        Node before = null;
        Node after = null;
        Node pivot = null;

        Node n = head;
        while(n != null){
            Node next = n.next;
            if(n.data < k){
                n.next =  before;
                before = n;
            }else if(n.data == k){
                n.next = pivot;
                pivot = n;
            }
            else{
                n.next = after;
                after = n;
            }
            n = next;
        }

        if(before == null && pivot != null){
            pivot.next = after;
            return pivot;
        }

        if(before == null && pivot == null){
            return after;
        }

        head = before;
        while(before.next != null){
            before = before.next;
        }

        before.next = pivot;

        if(after != null){
            pivot.next = after;
        }

        return head;
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
        Partition p = new Partition();
        ls.head = p.partition2(ls.head, 5);
        ls.print();
    }
}
