package practice.coding.trees;

/*
Question: Implement a binary search tree
* */


public class BinarySearch {

    int size;

    static Node root;


    /**
     * Adding a new node to Binary Tree
     * @param node
     */
    public void add(Node node){

        root = add(root, node);
    }

    /**
     * private call to do add src.main.Node recursively
     * @param currRoot
     * @param currNode
     */
    private Node add(Node currRoot, Node currNode){

        if(currRoot == null){
            currRoot = currNode;
        }
        else if(currNode.data <= currRoot.data) {
            currRoot.left =   add(currRoot.left, currNode);
        }
        else if(currNode.data > currRoot.data) {
            currRoot.right =  add(currRoot.right, currNode);
        }

        return currRoot;
    }

    /**
     * print tree in Pre-order Traversal
     * @param root
     */
    public void printPreOrder(Node root){
        if(root.left != null){
            printPreOrder(root.left);
        }
        System.out.println(root.data);
        if(root.right != null){
            printPreOrder(root.right);
        }
    }


    /**
     * Removing node from Binary Tree
     * @param node
     */
    public void remove(Node node){
        root = remove(root,node);
    }

    private Node remove(Node croot, Node cnode){

        if(croot == null){
            return croot;
        }

        if(cnode.data < croot.data){ //remove from lst if found
            croot.left = remove(croot.left, cnode);
        }else if (cnode.data > croot.data){ //remove from rst if found
            croot.right = remove(croot.right, cnode);
        }else if(croot.left != null && croot.right != null){ // two children
            Node temp = findMin(croot.right);
            croot.data = temp.data;
            croot.right = remove(croot.right, temp);
        }else{
            croot = (croot.left != null ? croot.left : croot.right); //i.e either leaf node or only one child exists
        }

        return croot;

    }


    private Node findMin(Node root){

        if(root == null){
            return null;
        }
        return root.left == null ? root : findMin(root.left);
    }



    /**
     * Check if tree is empty or not, return true if empty
     * @return
     */
    public boolean isEmpty(){
        return (size == 0);
    }


    /**
     * Check if node data is present in given Binary tree
     * @return
     */
    public boolean isExist(Node node){
        return isExist(root, node);
    }

    private boolean isExist(Node croot, Node cnode){

        if(croot == null || cnode == null){
            return false;
        }

        if(cnode.data == croot.data){
            return true;
        }
        boolean foundInLst = false;
        boolean foundInRst = false;

        if(croot.left != null && croot.data > cnode.data) {
            foundInLst = isExist(croot.left, cnode);
        }

        if(croot.right != null && croot.data < cnode.data) {
            foundInRst = isExist(croot.right, cnode);
        }

        return (foundInLst || foundInRst);
    }


    /**
     * size of binary tree
     */
    public int size(){
        return size;
    }


}
