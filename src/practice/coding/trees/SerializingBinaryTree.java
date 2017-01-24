package practice.coding.trees;


import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
Question:
Serialization is to store tree in a file so that it can be later restored. The structure of tree must be maintained.
Deserialization is reading tree back from file.

Note: There is no restriction on how your serialization/deserialization algorithm should work.
        You just need to ensure that a binary tree can be serialized to a string and this string
        can be deserialized to the original tree structure.


      Serialization     -    File    -      Deserialization

           20                                   20
         /    \           ------              /    \
        8      22    =>  | FILE |    =>      8      22
      /  \                ------           /  \
     4    12                              4    12
         /   \                                /   \
       10     14                            10     14

* */
public class SerializingBinaryTree {
    class TreeNode{
        int val;
        TreeNode left, right;
        TreeNode(int val){
            this.val = val;
        }
    }

    public String serialize(TreeNode root){
        StringBuilder sb = new StringBuilder();
        serialize(root, sb);
        return sb.toString();
    }

    private void serialize(TreeNode x, StringBuilder sb){
        if (x == null) {
            sb.append("# ");
        } else {
            sb.append(x.val + " ");
            serialize(x.left, sb);
            serialize(x.right, sb);
        }
    }

    public TreeNode deserialize(String s){
        if (s == null || s.length() == 0) return null;
        StringTokenizer st = new StringTokenizer(s, " ");
        return deserialize(st);
    }

    private TreeNode deserialize(StringTokenizer st){
        if (!st.hasMoreTokens())
            return null;
        String val = st.nextToken();
        if (val.equals("#"))
            return null;
        TreeNode root = new TreeNode(Integer.parseInt(val));
        root.left = deserialize(st);
        root.right = deserialize(st);
        return root;
    }

    public void levelOrderTraversal(TreeNode root, TreeNode levelIndicator){
        Queue<TreeNode> treeQueue = new LinkedList<TreeNode>();

        treeQueue.add(root);
        treeQueue.add(levelIndicator);
        while(!treeQueue.isEmpty()){
            TreeNode currNode = treeQueue.poll(); //remove first element in queue

            //if currNode is null i.e. level change indicator
            if(currNode==levelIndicator ) {
                System.out.println("");
                if (!treeQueue.isEmpty())
                    treeQueue.add(levelIndicator); //insert at end
            }
            else{ //insert currNode childs at the end of queue
                System.out.print(currNode.val+"   ");
                if(currNode.left != null) {
                    treeQueue.add(currNode.left);
                }
                if(currNode.right != null) {
                    treeQueue.add(currNode.right);
                }
            }

        }
    }

    public void testcase2(){
        System.out.println("deserialing..");
        levelOrderTraversal(deserialize("10 5 7 # # 17 # # 20 # 30 # #"), null);
    }

    public void testcase1(){
        TreeNode n1 = new TreeNode(10);
        TreeNode n2 = new TreeNode(5);
        TreeNode n3 = new TreeNode(20);
        TreeNode n4 = new TreeNode(7);
        TreeNode n5 = new TreeNode(17);
        TreeNode n6 = new TreeNode(30);
        n1.left=n2;
        n1.right=n3;
        n2.left=n4;
        n2.right=n5;
        n3.right=n6;
        levelOrderTraversal(n1,null);
        System.out.println("serialized tree::"+serialize(n1));
    }

    public void testbed(){
        testcase1();
        testcase2();
    }

    public static void main(String args[]){
        SerializingBinaryTree sbt = new SerializingBinaryTree();
        sbt.testbed();
    }
}
