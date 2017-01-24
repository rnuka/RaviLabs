package practice.coding.linkedList;

public class ReverseLinkedList {
    public ReverseLinkedList() {
    }
    Node head;

    //print
    public void printList(){
        Node currNode = head;
        while(currNode != null){
            System.out.print(currNode.data+"->");
            currNode= currNode.next;
        }
    }

    //add
    public void addNode(int data){
        if(head == null)
            head = new Node(data);
        else {
            Node temp = head;
            while(temp.next != null)
                temp=temp.next;
            temp.next = new Node(data);
        }

    }

    //reverse
    public void reverseList(Node currNode){
        //empty list or single node
        if(currNode == null)
            return;
        //base case
        if(currNode.next == null){
            head=currNode;
            return;
        }

        //other recursions
        reverseList(currNode.next);
        currNode.next.next=currNode;
        currNode.next=null;
    }


    //reverse using recursion
    //Explanation: http://stackoverflow.com/questions/14080758/reversing-a-linkedlist-recursively-in-c
    public Node reverse(Node head){
        if(head == null){
            return null;
        }

        if(head.next == null){
            return head;
        }

        Node rest = reverse(head.next);
        head.next.next = head;
        head.next = null;

        return rest;

    }

    public void testcase2(){
        System.out.println(" **** using REVERSE method ******");
        ReverseLinkedList reverseList = new ReverseLinkedList();
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;

        Node newHead = reverseList.reverse(n1);

        while(newHead != null){
            System.out.print(newHead.data+"->");
            newHead = newHead.next;
        }

    }

    public void testcase1(){
        ReverseLinkedList reverseList = new ReverseLinkedList();
        reverseList.addNode(1);
        reverseList.addNode(2);
        reverseList.addNode(3);
        reverseList.addNode(4);
        reverseList.addNode(5);
        reverseList.addNode(6);


        reverseList.printList();
        System.out.println("");
        reverseList.reverseList(reverseList.head);
        reverseList.printList();
    }

    public void testbed(){
        //testcase1();
        testcase2();
    }

    //test
    public static void main(String[] args){
        ReverseLinkedList r = new ReverseLinkedList();
        r.testbed();
        
        
    }
}
