package practice.coding.sort;

public class QuickSort {
    
    public void qSort(int[] oArray, int low, int high){

     if(low<high){
         //partition
         int pivot = partition(oArray, low, high);
       
         //left splits
         qSort(oArray, low, pivot-1);
         
         //right splits
         qSort(oArray, pivot+1, high);
     }

    }
    
    public int partition(int[] oArray, int low, int high){
    
        int pivot = low;

        if(low >= high){
            return pivot;
        }

        int i=low+1;
        int j=low+1;

        //start partition
        while(j<=high){
            if(oArray[j] < oArray[pivot]){
                //swap
                swap(oArray, i, j);
                i++;
            }
            j++;
        }

        //final swap of pivot and i
        swap(oArray,i-1,pivot);
        return i-1;

    }
    
    public void swap(int[] oArray, int a, int b){
        if(a!=b) {
            int temp = oArray[a];
            oArray[a] = oArray[b];
            oArray[b] = temp;
        }
        
    }

    public static void main(String[] args){
        //int[] array = {11,4,14,23,2001,99,59,65,23,11,43,49,73,81,99,2,3,4,5};
        int[] array = {4,2,7,6,1};
        //int[] array = {11,4,14,99,65};
        System.out.println("array before sorting:");
        for(int p=0;p<array.length;p++){
            System.out.print(array[p]+"  ");
        }
        System.out.println("\n lenght="+(array.length));
        QuickSort q = new QuickSort();
        q.qSort(array,0,array.length-1);

        //print sorted array
        System.out.println("Final sorted array:");
        for(int p=0;p<array.length;p++){
            System.out.print(array[p]+"  ");
        }
    }
    
}
