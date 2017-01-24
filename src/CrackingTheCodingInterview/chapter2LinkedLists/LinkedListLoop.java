package CrackingTheCodingInterview.chapter2LinkedLists;

/**
 * Created by rnuka on 10/15/15.
 */

/*
Question 2.6 Given a circular linked list, implement an algorithm which returns the node at the
beginning of the loop.
 */

public class LinkedListLoop {

    public LinkedListLoop() {
    }

    public boolean isLoopExist( Node head){
        Node slowRunner=head;
        Node fastRunner=head;
        while(fastRunner != null && fastRunner.next != null){

            slowRunner = slowRunner.next;
            fastRunner = fastRunner.next.next;

            if(fastRunner == slowRunner){
                System.out.println("fastRunner.data="+fastRunner.data);
                return true;
            }

        }
        return false;
    }

    public Node loopStartNode( Node head){
        Node slowRunner = head;
        Node fastRunner = head;
        while(fastRunner != null && fastRunner.next != null){

            slowRunner = slowRunner.next;
            fastRunner = fastRunner.next.next;

            if(fastRunner == slowRunner){
                System.out.println("fastRunner.data="+fastRunner.data);
                break;
            }

        }

        //If there is no loop
        if(fastRunner == null || slowRunner == null){
            return null;
        }

        //If loop exists move slow to head and start fast from looplenth-k at same speed
        slowRunner = head;
        while(slowRunner != null){
            slowRunner = slowRunner.next;
            fastRunner = fastRunner.next;
            if(slowRunner == fastRunner){
                return fastRunner;
            }
        }

        return fastRunner;
    }

    public static void main(String[] args){

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
        kl.KthElementFromEnd(ls.head, 7);
        System.out.println("kth element = " + kl.KthNodeFromEnd(ls.head, 7));
        //ls.print();
        LinkedListLoop listLoop = new LinkedListLoop();

        System.out.println("Does Loop Exist? ANS::" + listLoop.isLoopExist(ls.head));
        System.out.println("Does Loop start node? ANS::"+listLoop.loopStartNode(ls.head));

    }
}
