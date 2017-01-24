package practice.coding.sort;

public class QuickSortMiddle {
    public QuickSortMiddle() {
    }
    
    public void qSort(int[] oArray, int low, int high){
    

     int pivot;
     
     if(low<high){
         //partition
         pivot = partition(oArray, low, high);
       
         //left splits
         qSort(oArray, low, pivot-1);
         
         //right splits
         qSort(oArray,pivot+1,high);
     }else{
         return;
     }
     
     
        
    }
    
    public int partition(int[] oArray, int low, int high){
    
    int pivot = (low+high)/2;
    int i=low;
    int j=low;
    
    if(low<high){
        swap(oArray,low,pivot);
        pivot = low;
        i=low+1;
        j=low+1;
    }
    
    if(low<high){

    for (j=low+1;j<=high;j++){
    
        if(oArray[j]<oArray[pivot]){
            swap(oArray, i, j);
            i++;
        }
    }
    
    //final swap with highest element
    System.out.println("final swap i="+i+" pivot="+pivot);
    swap(oArray,i-1,pivot);
    return i;
    }
    
    return pivot;
    

        
    }
    
    public void swap(int[] oArray, int a, int b){
        System.out.println("inside swap a="+a+"b="+b);        
        int temp=oArray[a];
        oArray[a]=oArray[b];
        oArray[b]=temp;
        
    }
}
