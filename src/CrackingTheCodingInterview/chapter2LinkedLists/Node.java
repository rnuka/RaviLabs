package CrackingTheCodingInterview.chapter2LinkedLists;

/**
 * Created by rnuka on 10/9/15.
 */
public class Node {
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
