package practice.coding.trees;

/**
 * Created by rnuka on 6/15/16.
 */
/*
* Question: Find minimum element in binary Tree (not BST)
* */
public class MinimumElement {

    public int minimum(Node root){
        if(root == null){
            return Integer.MAX_VALUE;
        }
        return Math.min(Math.min(minimum(root.left),minimum(root.right)),root.data);
    }

    public static void main(String args[]){

        MinimumElement m = new MinimumElement();

        Node n1 = new Node(10);
        Node n2 = new Node(20);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);
        n1.left = n2;
        n2.left = n3;
        n3.right = n5;
        n5.left = n4;
        System.out.println("depth="+m.minimum(n1));

    }
}
