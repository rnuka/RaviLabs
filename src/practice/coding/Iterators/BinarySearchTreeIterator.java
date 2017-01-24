package practice.coding.Iterators;

import java.util.Iterator;
import java.util.Stack;

/*
Implement an iterator over a binary search tree (BST). Your iterator will be initialized with the root node of a BST.
Calling next() will return the next smallest number in the BST.
Note: next() and hasNext() should run in average O(1) time and uses O(h) memory, where h is the height of the tree.
 */
public class BinarySearchTreeIterator implements Iterator<BinarySearchTreeIterator.Node> {

    Stack<Node> stack = new Stack<>();

    public class Node{
        int data;
        Node left,right;
        public Node(int data){
            this.data = data;
        }
    }

    //Add root to left leaf to stack
    public BinarySearchTreeIterator(Node root){
        Node curr = root;
        while(curr != null){
            stack.push(curr);
            curr = curr.left;
        }

    }

    @Override
    public Node next(){
        if(hasNext()) {
            Node curr = stack.pop();
            //Note: Below logic is crucial before going to next node in stack,
            //      makesure right sub tree of current pop element is handled.
            if (curr.right != null) {
                Node newRoot = curr.right;
                while (newRoot != null) {
                    stack.push(newRoot);
                    newRoot = newRoot.left;
                }
            }
            return curr;
        }else{
            return null;
        }
    }

    @Override
    public boolean hasNext(){
        return !stack.isEmpty();
    }


}
