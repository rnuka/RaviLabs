package practice.coding.trees;

/**
 * Created by rnuka on 6/22/16.
 */
/*
*Given a BST, find second smallest element
 */
public class SecondSmallestElementinBST {

    public Node findSecondSmallest(Node root){

        //Null root
        if(root == null){
            return root;
        }

        //No childs
        if(root.left == null && root .right == null){
            return null;
        }

        //Only left subtree
        else if(root.left == null){
            return findLeftMostElement(root.right);
        }

        //look from one level above to see if we should return root or child from sub tree
        else if(root.left != null && root.left.left == null && root.left.right !=null){
            return findLeftMostElement(root.left.right);
        }

        //look from one level above to see if we should return root or child from sub tree
        else if(root.left != null && root.left.left == null && root.left.right ==null){
            return root;
        }

        return findSecondSmallest(root.left);
    }

    private Node findLeftMostElement(Node root){
        //base case - 1
        if(root==null){
            return null;
        }
        //base case - 2
        if(root.left==null){
            return root;
        }
        return findLeftMostElement(root.left);
    }



    //TEST SCRIPTS
    //============

    public void myassert(boolean x){
        if(!x){
            throw new IllegalArgumentException("Assert Fails");
        }
    }

    public void testbasic4(){
        Node a = new Node(10);
        myassert(findSecondSmallest(a) == null);
        System.out.println("End of test case 4 - success");
    }

    //no left subtree and only right subtree exists
    public void testbasic3(){
        Node a = new Node(10);
        //Node b = new Node(5);
        // Node c = new Node(6);
        Node d = new Node(11);
        Node e = new Node(12);
        //a.left = b;
        // b.right = c;
        a.right = d;
        d.right=e;

        myassert(findSecondSmallest(a).data == 11);
        System.out.println("End of test case 3 - success");
    }


    //left most child has no right subtree
    public void testbasic2(){
        Node a = new Node(10);
        Node b = new Node(5);
       // Node c = new Node(6);
        Node d = new Node(11);

        a.left = b;
       // b.right = c;
        a.right = d;

        myassert(findSecondSmallest(a).data == 10);
    }

    //left most child has right subtree
    public void testbasic1(){
        Node a = new Node(10);
        Node b = new Node(5);
        Node c = new Node(6);
        Node d = new Node(11);

        a.left = b;
        b.right = c;
        a.right = d;

        myassert(findSecondSmallest(a).data == 6);
    }

    public void testbed(){
        testbasic1();
        testbasic2();
        testbasic3();
        testbasic4();
    }

    public static void main(String args[]){
        SecondSmallestElementinBST sse = new SecondSmallestElementinBST();
        sse.testbed();
    }


}
