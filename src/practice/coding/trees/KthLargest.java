package practice.coding.trees;

/*

 K’th Largest Element in BST when modification to BST is not allowed
Given a Binary Search Tree (BST) and a positive integer k, find the k’th largest element in the Binary Search Tree.

For example, in the following BST, if k = 3, then output should be 14, and if k = 5, then output should be 10.

           20
         /    \
        8      22
      /  \
     4    12
         /   \
       10     14

* */

import java.util.Stack;

public class KthLargest {

    public Node kthLargest(Node root, int k){

        Stack<Node> stack = new Stack();
        Node curr = root;
        int counter = 0;
        while(!stack.isEmpty() || curr !=null){
            if(curr != null){
                stack.push(curr);
                curr=curr.right;
            }else{
                Node temp = stack.pop();
                if(k==++counter){
                    return temp;
                }else{
                    curr = temp.left;
                }
            }
        }
        return null;
    }
}
