package CrackingTheCodingInterview.chapter4TreesAndGraphs;

import practice.coding.trees.BNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by rnuka on 9/30/15.
 */
public class BinaryTree {

    BNode root;

    int treeHeight;
    int height;


    List<BNode> traversalResult = new ArrayList<BNode>();

    //inorder traversal when root is passed
    List<BNode> inOrderTraversal(BNode root){

        if(root != null) {
            inOrderTraversal(root.getLeft());
            traversalResult.add(root);
            inOrderTraversal(root.getRight());
        }
        return traversalResult;
    }

    //preorder traversal when root is passed
    List<BNode> preOrderTraversal(BNode root){
        if(root != null) {
            traversalResult.add(root);
            preOrderTraversal(root.getLeft());
            preOrderTraversal(root.getRight());
        }
        return traversalResult;
    }

    //postorder traversal when root is passed
    List<BNode> postOrderTraversal(BNode root){
        if(root != null) {
            postOrderTraversal(root.getLeft());
            postOrderTraversal(root.getRight());
            traversalResult.add(root);
        }
        return traversalResult;
    }

    List<BNode> levelOrderTraversal(BNode root, BNode levelIndicator){
        Queue<BNode> treeQueue = new LinkedList<BNode>();

        if(root == null)
            return traversalResult;
        treeQueue.add(root);
        treeQueue.add(levelIndicator);
        while(!treeQueue.isEmpty()){
            BNode currNode = treeQueue.remove(); //remove first element in queue
            //if currNode is null i.e. level change indicator
            if(currNode==levelIndicator ) {
                if (!treeQueue.isEmpty())
                    treeQueue.add(levelIndicator); //insert at end
            }
            else{ //insert currNode childs at the end of queue
                treeQueue.add(currNode.getLeft());
                treeQueue.add(currNode.getRight());
            }
            traversalResult.add(currNode);
        }
        return traversalResult;
    }

    //height
    int height(BNode root){
        if(root != null){
            height++;
            height(root.getLeft());
            height(root.getRight());
            //leaf node
            if(root.getLeft() == null && root.getRight() == null){
                if(height>treeHeight)
                    treeHeight=height;
                height = 0;

            }
        }
        return treeHeight;
    }


    //test
    public static void main(String args[]){
        BNode b2= new BNode("ravi");
        BNode b3= new BNode(3);
        BNode b1= new BNode(1);
        BNode b4= new BNode(4);
        BNode b5= new BNode(5);


        b1.setLeft(b2);
        b1.setRight(b3);

        b2.setLeft(b4);
        b4.setLeft(b5);

        BinaryTree bt = new BinaryTree();
        bt.root = b1;

        System.out.println("Inorder Traversal::");
        bt.traversalResult.clear();
        bt.inOrderTraversal(b1);
        for(BNode currNode: bt.traversalResult){
            System.out.println("value="+currNode.getData());
        }

        System.out.println("Preorder Traversal::");
        bt.traversalResult.clear();
        bt.preOrderTraversal(b1);
        for(BNode currNode: bt.traversalResult){
            System.out.println("value="+currNode.getData());
        }

        System.out.println("Postorder Traversal::");
        bt.traversalResult.clear();
        bt.postOrderTraversal(b1);
        for(BNode currNode: bt.traversalResult){
            System.out.println("value="+currNode.getData());
        }

        System.out.println("height of the tree="+bt.height(bt.root));
        System.out.println("height of the tree="+bt.height);
    }

}
