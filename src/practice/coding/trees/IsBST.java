package practice.coding.trees;

/**
 * Created by rnuka on 5/25/16.
 Question: Given a preorder list of tree in an array, return true or false if the tree is BST
 */
public class IsBST {

    public boolean isBST(int[] tree){

        return isBST(tree, 0,tree.length-1);

    }

    private boolean isBST(int[] tree, int low, int high){
        System.out.println("low="+low+" high="+high);
        if(high<=low){
            return true;
        }

        int root = low;

        //move right until you get a value greater than root.
        int i=root+1;
        boolean rst = false;
        int lstTop = low;

        //navigate left subtree
        while(tree[root]>tree[i] && i<high){
            i++;
        }

        //if a greater value is found before reaching end of tree
        if(i<high){
            lstTop = i-1;
            rst = true;
        }else{
            return true;
        }

        //navigate right sub tree
        while(rst && i<=high){
            if(tree[root]>tree[i]){
                return false;
            }
            i++;
        }

        //recurse subtrees
        return isBST(tree,low+1,lstTop)&&isBST(tree,lstTop+1,high);
    }

    protected void testbasic(){
        int[] tarray = {5,3,2,8,7,9,6};
        System.out.println("testbasic isBst="+isBST(tarray));
        myassert(isBST(tarray));

    }

    private void myassert(boolean x){
        if(!x){
            throw new IllegalArgumentException("Assert Fail");
        }
    }

    protected void testbed(){
        testbasic();
    }

    public static void main(String args[]){
        IsBST ib = new IsBST();
        ib.testbed();
    }

}
