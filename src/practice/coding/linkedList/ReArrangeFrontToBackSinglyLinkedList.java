package practice.coding.linkedList;

/*
Question: Given a singly linked list: 1->2->3->4->5
Change it to 1->5->2->4->3 using O(1) space
 */
public class ReArrangeFrontToBackSinglyLinkedList {
    public Node rearrangeLinkedList(Node root){
        //step-1: split the node into two halves
        Node slow = root;
        Node fast = root;http://www.programcreek.com/2013/01/leetcode-longest-consecutive-sequence-java/
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }

        Node firstListEnd = slow;
        System.out.println("first List end="+firstListEnd.data);
        Node secondListBegin = slow.next;

        firstListEnd.next = null;  //splitting the list into two halves

        //step-2: reverse the second half of linked list
        Node secondListBeginAfterReverse = reverseList(secondListBegin);
        System.out.println("second half list after reverse");
        printList(secondListBeginAfterReverse);
        Node firstListBegin = root;

        //step-3: merge the first list with reversed second list alternately.
        Node node = new Node(0); //dummy node to start the merging process
        Node curr = node;
        while(firstListBegin != null && secondListBegin != null){
            if(firstListBegin != null){
                curr.next = firstListBegin;
                curr = curr.next;
                firstListBegin = firstListBegin.next;
            }
            if(secondListBeginAfterReverse != null){
                curr.next = secondListBeginAfterReverse;
                curr = curr.next;
                secondListBeginAfterReverse = secondListBeginAfterReverse.next;
            }
        }

        node = node.next;  //removing dummy node value which is at the beginning.
        return node;
    }

    public Node reverseList(Node root){
        if(root == null){
            return null;
        }

        Node prev = null, curr = root;
        while(curr != null){
            Node next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    public void printList(Node root){
        Node curr = root;
        if(curr == null){
            return;
        }
        System.out.println(" --------");
        while(curr != null){
            System.out.print("Node[" + curr.data + "]->");
            curr = curr.next;
        }
        System.out.println("");
    }

    public void testcase1(){
        System.out.println("********** TESTCASE-1 **********");
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;

        System.out.println("Before arrangement");
        printList(n1);
        Node newRoot = rearrangeLinkedList(n1);
        System.out.println("After arrangement");
        printList(newRoot);
    }



    public void testbed(){
        testcase1();
    }

    public static void main(String args[]){
        ReArrangeFrontToBackSinglyLinkedList r = new ReArrangeFrontToBackSinglyLinkedList();
        r.testbed();
    }
}
