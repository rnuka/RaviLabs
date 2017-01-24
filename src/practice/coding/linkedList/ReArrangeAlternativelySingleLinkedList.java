package practice.coding.linkedList;

/*
Return the head node of the singly linked list with each pair of nodes swapped.
If there is a last odd node leave it in place.

Example:
Input: 1 -> 2 -> 3 -> 4 -> 5
Output: 2 -> 1 -> 4 -> 3 -> 5
 */
public class ReArrangeAlternativelySingleLinkedList {

    public Node reArrange(Node head){

        if(head == null || head.next == null) {
            return head;
        }

        Node newHead;

        if(head.next != null){
            newHead = head.next;
        }else{
            return head;
        }

        Node curr = head;
        Node prev = null;
        while(curr != null && curr.next !=null){
            Node next = curr.next;
            Node nextNext = next.next;

            curr.next = nextNext;
            next.next = curr;
            if(prev != null){
                prev.next = next;
            }
            prev = curr;
            curr = nextNext;
        }

        return newHead;
    }

    //Using recursion:
    Node swapPairs(Node head){
        if(head == null || head.next == null){ //if null or only single element left then return head i.e. basecase
            return head;
        }else {
            Node newHead = head.next;
            head.next = swapPairs(head.next.next);
            newHead.next = head;
            return newHead;
        }
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

    public void testcase2(){
        System.out.println("********** TESTCASE-2 **********");
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
        Node newRoot = swapPairs(n1);
        System.out.println("After arrangement");
        printList(newRoot);
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
        Node newRoot = reArrange(n1);
        System.out.println("After arrangement");
        printList(newRoot);
    }

    public void testbed(){
        testcase1();
        testcase2();
    }

    public static void main(String args[]){
        ReArrangeAlternativelySingleLinkedList r = new ReArrangeAlternativelySingleLinkedList();
        r.testbed();
    }
}
