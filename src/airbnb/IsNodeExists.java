package airbnb;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by rnuka on 5/27/16.
 */
public class IsNodeExists {

    private static class Node{
        int data;
        Node left;
        Node right;

    }


    private static int isPresent(Node root, int val){

        //recursion approach
        if(root.data == val){
            return 1;
        }

        if(root.left != null && root.right != null){
            return ((isPresent(root.left, val)==1)||(isPresent(root.right,val)==1) == true? 1: 0);
        }

        if(root.left != null && root.right == null){
            return isPresent(root.left, val);
        }

        if(root.right != null && root.left == null){
            return isPresent(root.right, val);
        }

        return 0;

    }
}
