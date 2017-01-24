package practice.coding.arrays;

/**
 * Created by rnuka on 5/24/16.
 */
public class Shuffle {

    public void pairShuffle(String[] sarray) {

        if(sarray == null){
            return;
        }
        pairShuffle(sarray,0,sarray.length-1);

    }

    private void pairShuffle(String[] sarray, int low, int high){

        if(high <= low){
            return;
        }

        int mid = (low+high)/2;

        //if mid+1 with low+1 are diff then swap;
        if(low+1<mid+1){
            swap(sarray,low+1,mid+1);
        }

        //if low+2 and mid+1 are not same then swap and recurse
        if(low+2<mid+1){
            swap(sarray,low+2,mid+1);
            pairShuffle(sarray,low+2,high);
        }

    }

    private void swap(String[] sarray, int a, int b){
        String temp = sarray[a];
        sarray[a] = sarray[b];
        sarray[b] = temp;
    }

    public void printArray(Object[] arr){
        if(arr == null){
            return;
        }
        //else print
        for(int i=0; i<arr.length; i++){
            System.out.print(" " + arr[i]);
        }
    }

    public void myassert(boolean x){
        if(!x){
            throw new IllegalArgumentException("Assert Fail");
        }
    }

    protected void testnull(){
        System.out.println("\n ----before---");
        printArray(null);
        pairShuffle(null);
        System.out.println("\n ----after----");
        printArray(null);
    }

    protected void testbasic(){
        String[] sarray = {"a1","a2","a3","b1","b2","b3"};
        String[] tarray = {"a1","b1","a2","b2","a3","b3"};
        System.out.println("\n ----before---");
        printArray(sarray);
        pairShuffle(sarray);
        System.out.println("\n ----after----");
        printArray(sarray);
        for(int i=0; i<sarray.length;i++){
            myassert(sarray[i] == tarray[i]);
        }

    }

    protected void testbed(){
        testbasic();
        testnull();
    }

    public static void main(String args[]){
        Shuffle s = new Shuffle();
        s.testbed();
    }
}
