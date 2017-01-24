package practice.coding.sort;

public class MergeSort {
    
   void mergeSort(int[] original){
       int[] helper = new int[original.length];
       mergeSort(original, helper, 0, original.length-1);
   }

   private void mergeSort(int[] original, int[] helper, int low, int high){

       if(low>=high){
           return;
       }

       int mid = (low + high) / 2;
       mergeSort(original,helper,low,mid);
       mergeSort(original,helper,mid+1,high);
       merge(original,helper,low, mid, high);

   }

   private void merge(int[] original, int[] helper, int low, int middle, int high){
       //copy elements into helper array
       for(int i=low; i<=high; i++){
           helper[i] = original[i];
       }


       //sort
       int current = low;
       int left = low;
       int right = middle+1;
       while(left <= middle && right <= high) {
           if (helper[left] <= helper[right]) {
               original[current] = helper[left];
               left++;
           }else{
               original[current] = helper[right];
               right++;
           }
           current++;
       }

       //copy remaining left side elements
       int remaining = middle-left;
       for(int i=0; i<=remaining; i++){
           original[current+i]=helper[left+i];
       }

   }

    //test
    public static void main(String[] args){
        int[] array = {11,4,14,23,2001,99,59,65,23,11,43,49,73,81,99,2,3,4,5};
        //int[] array = {11,4,14,99,65};
        System.out.println("array before sorting:");
        for(int p=0;p<array.length;p++){
            System.out.print(array[p]+"  ");
        }
        System.out.println("\n length="+(array.length));
        MergeSort m = new MergeSort();
        m.mergeSort(array);

        //print sorted array
        System.out.println("Final sorted array:");
        for(int p=0;p<array.length;p++){
            System.out.print(array[p]+"  ");
        }
    }
}
