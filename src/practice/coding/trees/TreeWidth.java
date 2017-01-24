package practice.coding.trees;

/*
Question: Given a binary tree, find the width of the tree
* */
public class TreeWidth {

    public int width(Node root){
        return width(root,0);
    }

    private int width(Node root, int level){
        if(root == null)
            return level;
        return width(root.right,level+1)-width(root.left,level-1)+1;
    }

    public static void main(String[] args){
        TreeWidth tw = new TreeWidth();
        Node n1 = new Node(10);
        Node n2 = new Node(20);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);
        n1.left = n2;
        n2.left = n3;
        n3.right = n5;
        n5.left = n4;
        System.out.println("width="+tw.width(n1));

    }
}
