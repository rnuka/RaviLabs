package practice.coding.trees;

/**
 * Created by rnuka on 5/24/16.
 */
public class MirrorBST {
    public void mirror(Node root){
        //Null Case
        if(root == null){
            return;
        }

        Node temp = root.left;
        root.left = root.right;
        root.right = temp;
        mirror(root.left);
        mirror(root.right);

        /*

        //if both childs are present
        if(root.left != null && root.right != null){
            Node temp = root.left;
            root.left = root.right;
            root.right = temp;
            mirror(root.left);
            mirror(root.right);
        }

        //if only left child present
        if(root.left != null && root.right == null){
            root.right = root.left;
            root.left = null;
            mirror(root.right);
        }

        //if only right child presetn
        if(root.right != null && root.left == null){
            root.left = root.right;
            root.right = null;
            mirror(root.left);
        }

        */
    }

    protected void testnull(){
        System.out.println("------Start NULL test case--------");
        mirror(null);
        System.out.println("------End NULL test case----------");
    }

    protected void testbasic(){
        System.out.println("------Start basic test cases--------");
        Node a = new Node(3);
        Node b = new Node(1);
        Node c = new Node(2);
        Node d = new Node(6);
        Node e = new Node(5);
        Node f = new Node(7);
        Node g = new Node(8);

        //3 nodes
        Node root = d;
        root.left = a;
        root.right = g;
        a.right=e;
        a.left=c;
        c.left=b;

        PrintBinaryTree p = new PrintBinaryTree();
        p.printTree(root);
        mirror(root);
        p.printTree(root);
        System.out.println("------End basic test cases--------");
    }

    protected void testbed(){
        testbasic();
        testnull();
    }

    public static void main(String args[]){
        MirrorBST m = new MirrorBST();
        m.testbed();
    }
}
