package practice.coding.sort;

public class QuickSortCounting {

    static long qsortCompCount = 0;
    public QuickSortCounting() {
    }
    public long qSort(int[] oArray, int low, int high){
    

     int pivot;
     
     if(low<high){
         //partition
         pivot = partition(oArray, low, high);
       
         //left splits
         qSort(oArray, low, pivot-1);
         
         //right splits
         qSort(oArray,pivot+1,high);
     }
     
     return qsortCompCount;
        
    }
    
    public int partition(int[] oArray, int low, int high){
    
    qsortCompCount = qsortCompCount + (high-low);
    
      //Type1: Low Pivot
    int pivot = low;
    int i=low;
    int j=low;
    
    if(low<high){
        i=low+1;
        j=low+1;
    }
    
    if(low<high){
        while(j<high && i<high){
            if(oArray[j]<oArray[pivot]){
                //swap
                swap(oArray, i, j);
                j++;
                i++;
                
            }else{
                j++;
            }
        }
    
    
        //final swap of pivot and i
        System.out.println("i val before swap="+i);
        swap(oArray,i-1,pivot);
        return i-1;
    
    }
    
    return pivot;
    
    
    
    //Type2: High pivot
    
    /* int pivot = high;
     
     
     int i=low;
     int j=low;
     

     
     if(low<high){

     for (j=low;j<high;j++){
         if(oArray[j]<oArray[pivot]){
             swap(oArray, i, j);
             i++;
         }
     }
     
     //final swap with highest element
     System.out.println("final swap i="+i+" pivot="+pivot);
     swap(oArray,i,pivot);
     return i;
     }
     
     return pivot;
     */
    

        
    }
    
    public void swap(int[] oArray, int a, int b){
        int temp=oArray[a];
        oArray[a]=oArray[b];
        oArray[b]=temp;
        
    }
    
}
