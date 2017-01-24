package practice.coding.sort;

public class InversionCount {
    public InversionCount() {
    }
    
    public InversionCount(int h) {
        mArray = new int[h];
        
    }
    
    static int[] mArray;
    
    static int i = 0;
    static int j = 0;
    static int k = 0;
    
    static long inversionCount = 0;
    
    public long mergeSort(int[] array, int low, int high){
        
       
       
       int newmid = (low+high)/2;
    
       //System.out.println("low : "+low+" , high : "+high+" ,mid :  "+newmid);
       if(low<high){
       //traverse left
       mergeSort(array,low,newmid);
       
       //traverse right
       mergeSort(array,newmid+1,high);
       
       mergeData(array,low, high, newmid);
       
       }else{
           //System.out.println("element="+array[newmid]);
           //mergeData(array,low, high, newmid);
       }
       
       return inversionCount;
    }
    
    public void mergeData(int[] oArray, int low, int high, int mid){

         
         j=mid+1;
         k=low;
         i=low;
         while(i<=mid && j<=high){

             if(oArray[i]>oArray[j]){
                 mArray[k] = oArray[j];

                 j++;

                 //when j element is swapped which says all remaining i elements are inversions
                  /*if(inversionCount>1231555081){
                      System.out.println("mid"+mid+"i="+i+"inversionCount="+inversionCount);
                  }*/
                 inversionCount=inversionCount+(mid-i+1);

             }else{

                mArray[k] = oArray[i];
                i++;

             }

         k++;
         }
         while(i<=mid){
             mArray[k]=oArray[i];
             //System.out.println("Adding rest i elements");
             
             //t++; //inversionCount++;
             i++;
             k++;
             
         }
        
        //System.out.println("Adding rest j elements");
         while(j<=high){
             mArray[k]=oArray[j];
             j++;
             k++;
         }
         
         //copy mArray to oArray after all sorting
        for(int p=0;p<k;p++){
           oArray[p] = mArray[p]; 
        }
        

        
        System.out.println("inversionCount="+inversionCount);
        
    }
}
