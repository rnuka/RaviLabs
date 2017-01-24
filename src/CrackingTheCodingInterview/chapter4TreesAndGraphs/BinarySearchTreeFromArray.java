package CrackingTheCodingInterview.chapter4TreesAndGraphs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by rnuka on 10/17/15.
 */
/*
Question 4.3 Given a sorted (increasing order) array with unique integer elements, write an algorithm
to create a binary search tree with minimal height
 */
/*
Input: sorted array in ascending order
Output: BST root node
*/
public class BinarySearchTreeFromArray {

    //construct BST from Node array
    public Node constructBST(int[] arr, int low, int high){

        if(low > high){
            return null;
        }

        int mid = (low + high) / 2;
        Node  root = new Node(arr[mid]);
        root.left = constructBST(arr, low, mid - 1);
        root.right = constructBST(arr, mid + 1, high);

        return root;
    }

    //print tree
    public void printLevelOrder(Node root){
        Queue<Node> myQueue = new LinkedList<Node>();
        myQueue.add(root);
        myQueue.add(null);
        int counter = 0;
        //while queue is not empty, traverse in bfs approach
        while(!myQueue.isEmpty() && ++counter < 25){
            Node curr = myQueue.remove();

            //if null node comes which is level change indicator
            // then insert null at back if queue has still some elements
            if(curr == null ){
                if( !myQueue.isEmpty()) {
                    myQueue.add(curr);
                }
                System.out.println("");
            }else{
                //print level
                System.out.print(curr.data + " ");
                //otherwise add left and right childs to the queue
                if(curr.left != null){
                    myQueue.add(curr.left);
                }
                if(curr.right != null){
                    myQueue.add(curr.right);
                }
            }


        }

    }

    //test
    public static void main(String[] args){
        int n = 5;
        int[] input = new int[n];
        for(int i=0; i<n; i++){
            System.out.println("adding i as"+(i+1));
            //Node node = new Node(i+1);
            input[i] = i+1;
        }

        BinarySearchTreeFromArray bsta = new BinarySearchTreeFromArray();

        Node root = bsta.constructBST(input, 0, n-1);

        System.out.println("root = "+root.data);

        bsta.printLevelOrder(root);




    }



}
