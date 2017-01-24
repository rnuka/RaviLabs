package practice.coding.trees;

/*
Given a binary tree

     TreeLinkNode {
      TreeLinkNode left;
      TreeLinkNode right;
      TreeLinkNode next;
    }
Populate each next pointer to point to its next right node. If there is no next right node,
the next pointer should be set to NULL.

Initially, all next pointers are set to NULL.

Note:

You may only use constant extra space.

You may assume that it is a perfect binary tree (ie, all leaves are at the same level,
and every parent has two children).

Followup: What if it is just a binary tree (not perfect binary tree)

Example:
--------
Given the following perfect binary tree,
         1
       /  \
      2    3
     / \  / \
    4  5  6  7

After calling your function, the tree should look like:
         1 -> NULL
       /  \
      2 -> 3 -> NULL
     / \  / \
    4->5->6->7 -> NULL
 */
public class PopulateNextRightPointers {

    public static class TreeLinkNode{
        int data;
        TreeLinkNode left;
        TreeLinkNode right;
        TreeLinkNode next;

        public TreeLinkNode(int data){
            this.data = data;
        }

        public TreeLinkNode(int data, TreeLinkNode left, TreeLinkNode right){
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }

    public void dfs(TreeLinkNode root){
        dfs(root,null);
    }

    //Assume tree is balanced binary tree
    //Note: below approach uses recursion and hence it is not O(1) space complexity
    //       as recursion stack tree holds memory and in this case it will be O(n)
    private void dfs(TreeLinkNode root, TreeLinkNode rightConnection){

        //null root means nothing
        if(root==null){
            return;
        }

        //first assign right connection
        root.next = rightConnection;

        //if left child exists, always assign right child as right connection
        if(root.left != null){
            dfs(root.left, root.right);
        }

        //if right child exists, always assign current right connection's left child
        // i.e. for example for Node 5, assign 2's right connection's left child
        if(root.right != null){
            if(rightConnection != null) {
                dfs(root.right, rightConnection.left);
            }else{
                dfs(root.right, null);
            }
        }
    }

    //Solution for perfect binary tree
    private void dfsWhileLoop(TreeLinkNode root){
        TreeLinkNode parent = root;
        TreeLinkNode first = null; //first is first node to traverse

        while(parent != null){

            //preserve first child node of next level so that it becomes first parent in next parent level.
            if(first==null){
                first = parent.left;
            }

            // quit if left most leaf node becomes parent because by that time all pointers are populated.
            if(parent.left == null && parent.right == null) { // quit if leaf node
                return;
            }else { //Otherwise keep traversing
                if (parent.left != null) {
                    parent.left.next = parent.right;
                }

                /*Check if right most element in current level is reached.
                 If so, go to next level otherwise continue to move to right nodes as parent and keep assigning
                Note: After node 2 is handled (assign right as next.left), as it still has right element 3,
                        then make 3 as parent and go on.
                */

                if (parent.next != null) {
                    parent.right.next = parent.next.left;
                    parent = parent.next;
                } else { //right most element reached, get ready for next level.
                    parent = first;
                    first = null;
                }
            }

        }
    }

    //Generic Solution: For any binary tree
    public void populateNextPointers(TreeLinkNode root){
        TreeLinkNode parent = root;
        TreeLinkNode first = null;
        TreeLinkNode last = null;
        while(parent !=null){

            /*
                preserve first node of level in first so that once current parent is done
                "first" becomes parent for next new level
             */
            if(first==null){
                //As not perfect binary tree, left and right may or may not exist. so check n assign
                if(parent.left != null){
                    first = parent.left;
                }else if(parent.right != null){
                    first = parent.right;
                }
            }

            /*
            if parent has left child then see if "last" node is in middle element or first element of level
            and then assign next pointers accordingly.
             */

            if(parent.left != null){
                if(last!=null){
                    last.next = parent.left;
                }
                last = parent.left;

            }


            /*
            if parent has right child then see if "last" node is in middle element or first element of level
            and then assign next pointers accordingly.

            Note: if parent has left and right nodes, note that first left nodes are assigned to last in
                   above if condition.
             */
            if(parent.right != null){
                if(last!=null){
                    last.next = parent.right;
                }
                last = parent.right;
            }

            //if current parent is last element in current parental row or not. keep moving accordingly.
            //if parent.next == null means thats the end of row and hence assign parent to first to start new level
            if(parent.next != null){
                parent = parent.next;
            }else{
                parent = first;
                first = null;
                last = null;
            }
        }
    }




    public void printTree(TreeLinkNode root){
        if(root==null){
            System.out.println("NULL");
        }else {
            System.out.println(root.data + " has next node as" +
                    (root.next == null ? "NULL" : root.next.data));
            if (root.left != null) {
                printTree(root.left);
            }
            if (root.right != null) {
                printTree(root.right);
            }
        }
    }

    public void testcase3(){
        System.out.println("***** Begin TESTCASE-3 *****");
        TreeLinkNode n4 = new TreeLinkNode(4);
        TreeLinkNode n5 = new TreeLinkNode(5);
        TreeLinkNode n6 = new TreeLinkNode(6);
        TreeLinkNode n7 = new TreeLinkNode(7);
        TreeLinkNode n2 = new TreeLinkNode(2,n4,n5);
        TreeLinkNode n3 = new TreeLinkNode(3,n6,n7);
        TreeLinkNode n1 = new TreeLinkNode(1,n2,n3);

        populateNextPointers(n1);
        printTree(n1);


    }

    public void testcase2(){
        System.out.println("***** Begin TESTCASE-2 *****");
        TreeLinkNode n4 = new TreeLinkNode(4);
        TreeLinkNode n5 = new TreeLinkNode(5);
        TreeLinkNode n6 = new TreeLinkNode(6);
        TreeLinkNode n7 = new TreeLinkNode(7);
        TreeLinkNode n2 = new TreeLinkNode(2,n4,n5);
        TreeLinkNode n3 = new TreeLinkNode(3,n6,n7);
        TreeLinkNode n1 = new TreeLinkNode(1,n2,n3);

        dfsWhileLoop(n1);
        printTree(n1);


    }

    public void testcase1(){
        TreeLinkNode n4 = new TreeLinkNode(4);
        TreeLinkNode n5 = new TreeLinkNode(5);
        TreeLinkNode n6 = new TreeLinkNode(6);
        TreeLinkNode n7 = new TreeLinkNode(7);
        TreeLinkNode n2 = new TreeLinkNode(2,n4,n5);
        TreeLinkNode n3 = new TreeLinkNode(3,n6,n7);
        TreeLinkNode n1 = new TreeLinkNode(1,n2,n3);

        dfs(n1);
        printTree(n1);


    }

    public void testbed() {
        testcase2();
        //testcase3();
    }

    public static void main(String args[]){
        PopulateNextRightPointers p = new PopulateNextRightPointers();
        p.testbed();
    }
}
