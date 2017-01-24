package practice.coding.trees;

import java.util.List;

/**
 * Created by rnuka on 10/18/15.
 */
public class Node {
    int data;
    Node left;
    Node right;
    public Node(int d){
        this.data = d;
    }
    public Node(int value, Node left, Node right) {
        this.data = value;
        this.left = left;
        this.right = right;
    }

    void inOrderTraversal(){
        Node curr = this;
        inOrderTraversal(curr);
    }

    //inorder traversal when root is passed
    void inOrderTraversal(Node root){
        if(root != null) {
            inOrderTraversal(root.left);
            System.out.println(" root = "+root.data);
            inOrderTraversal(root.right);
        }
    }
}
