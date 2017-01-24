package practice.coding.math;

public class LcmGcd {
    public static int[] array={2,4,7,21};
    public static int[] temp=new int[array.length];
    
    public LcmGcd() {
       
    }
    
    public static void main(String args[]){

        LcmGcd l=new LcmGcd();
        l.mergeSort(array,0,array.length);
        
        //print original array and see first element will be lcm
        for(int i=0;i<array.length;i++){
            System.out.println("array[i]="+array[i]);
        }

    }
    
    
    public  void mergeSort(int[] array, int low, int high){
    
       int mid=(low+high)/2;
       if(low<high)
          {
           mergeSort(array,low,mid);
           mergeSort(array,mid+1,high);
           merge(array,low,high);
       }
    }
    
    public  void merge(int[] array, int low, int high){
        int mid=(low+high)/2;
        int max=0;
        if(mid+1==array.length){
            max=mid;
        }else{
            max=mid+1;
        }
        System.out.println("low="+low+"high="+high);
        int lcm = doLCM(array[low], array[max]);
        temp[low]=lcm;
        /*System.out.println("lcm while merging"+lcm);
        for(int i=low+1;i<high;i++){
            temp[i]=1;
        }
        */
        //update original array
        for(int i=low;i<high;i++){
            array[i]=temp[i];
        }
    }
    
    public  int doLCM(int product1, int product2){
        int gcd=1;
        for(int i=2; i <= Math.min(product1, product2); i++){
            if(product1%i==0&&product2%i==0){
                gcd=i;
            }
        }
        System.out.println("gcd="+gcd+" for product1="+product1+" and product2="+product2);
        int lcm=(product1*product2)/gcd;
        return lcm;
    }
}
