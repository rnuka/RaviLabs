package practice.coding.trees;

/*
Given a binary tree, print boundary nodes of the binary tree Anti-Clockwise starting from the root.
For example, boundary traversal of the following tree is “20 8 4 10 14 25 22”

         20
       /    \
      8      22
     / \       \
    4   12      25
       /  \
      10   14

 */

/*
Approach: 3 step approach
step-1: print left boundary
step-2: print leaves
step-3: print right boundary (bottom to top)
 */
public class BoundaryTraversal {
    public void printBoundary(Node root){
        if(root == null){
            return;
        }
        System.out.println("root=" + root.data);
        printLeftBoundary(root.left);
        printLeaves(root);
        printRightBoundary(root.right);
    }

    private void printLeftBoundary(Node root){
        if(root == null){
            return;
        }
        if(root.left != null){
            System.out.println("left boundary(lt) = " + root.data);
            printLeftBoundary(root.left);
        }else if(root.right != null){
            System.out.println("left boundary(rt)="+root.data);
            printLeftBoundary(root.right);
        }
    }

    private void printLeaves(Node root){
        if(root == null){
            return;
        }
        if(root.left != null){
            printLeaves(root.left);
        }

        if(root.left == null && root.right == null){
            System.out.println("leaf node="+root.data);
        }

        if(root.right != null){
            printLeaves(root.right);
        }
    }

    private void printRightBoundary(Node root){
        if(root == null){
            return;
        }
        if(root.right != null){
            printRightBoundary(root.right);
            System.out.println("right boundary(rt) = " + root.data);
        }else if(root.left != null){
            printRightBoundary(root.right);
            System.out.println("right boundary(lt)=" + root.data);
        }
    }

    public void testcase1(){
        Node n1 = new Node(20);
        Node n2 = new Node(8);
        Node n3 = new Node(22);
        Node n4 = new Node(4);
        Node n5 = new Node(12);
        Node n6 = new Node(25);
        Node n7 = new Node(10);
        Node n8 = new Node(14);
        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        n3.right = n6;
        n5.left = n7;
        n5.right = n8;
        printBoundary(n1);
    }

    public void testbed(){
        testcase1();
    }

    public static void main(String[] args){
        BoundaryTraversal b = new BoundaryTraversal();
        b.testbed();
    }
}
