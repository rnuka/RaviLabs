package practice.coding.trees;

import java.util.*;
import java.util.LinkedList;

/**
 * Sample input:
 *
 *          1
 *         / \
 *        3   5
 *       /   / \
 *      2   4   7
 *     / \   \
 *    9   6   8
 
 *
 * Expected output:
 *    1
 *    3 5
 *    2 4 7
 *    9 6 8
 *    ==========
 */

class PrintBinaryTree {
 
  public static void printTree(Node root){
  //implementation here
    System.out.println("begin");
    Queue<Node> currentQueue = new LinkedList<Node>();


    //if root is null
    if(root == null)
        return;

    //else
    currentQueue.add(root);
    currentQueue.add(null);

    while(!currentQueue.isEmpty()) {
        Node currentNode = currentQueue.remove();
        //if null
        if(currentNode == null) {
            System.out.println(" ");
            //add null at the queue end if more childs present in queue
            if(!currentQueue.isEmpty())
                currentQueue.add(null);
        }
        else{
            if(currentNode.left != null) {
                currentQueue.add(currentNode.left);
            }
            if(currentNode.right != null) {
               // System.out.print("<->RT");
                currentQueue.add(currentNode.right);
            }
            System.out.print(" " + currentNode.data);
        }
    }
    
  }
  
  public static void main(String[] args){
    PrintBinaryTree tree = new PrintBinaryTree();
    Node n9= new Node(9,null, null);
    Node n8 = new Node(8,null,null);
    Node n6= new Node(6,null, null);
    Node n7 = new Node(7,null,null);
    Node n2= new Node(2,n9, n6);
    Node n3 = new Node(3,n2,null);
    Node n4 = new Node(4,null,n8);
    Node n5 = new Node(5,n4,n7);
    Node root= new Node(1,n3,n5);
    tree.printTree(root);
     
  }

}

