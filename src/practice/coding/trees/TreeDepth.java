package practice.coding.trees;

/**
 * Created by rnuka on 6/6/16.
 */
public class TreeDepth {

    public int getTreeDepth(Node root){

        //base case
        if(root == null){
            return 0;
        }

        //recursion
        return Math.max(getTreeDepth(root.left),getTreeDepth(root.right))+1;

    }

    public static void main(String args[]){

        TreeDepth td = new TreeDepth();

        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);
        n1.left = n2;
        n2.left = n3;
        //n1.right = n4;
        n3.right = n5;
        n5.left = n4;
        System.out.println("depth="+td.getTreeDepth(n1));


    }

}
