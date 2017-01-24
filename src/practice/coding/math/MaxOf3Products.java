package practice.coding.math;

public class MaxOf3Products {
    

    public MaxOf3Products() {
    }

    public int maxProduct(int[] numList){
         int max_1=Integer.MIN_VALUE;
         int max_2=Integer.MIN_VALUE;
         int max_3=Integer.MIN_VALUE;

         int min_1=Integer.MAX_VALUE;
         int min_2=Integer.MAX_VALUE;
         int min_3=Integer.MAX_VALUE;

        for(int i=0;i<numList.length;i++){
            //check against max_1
            if(numList[i]>max_1){
                max_3=max_2;
                max_2=max_1;
                max_1=numList[i];
            }
            else if(numList[i]>max_2){
                max_3=max_2;
                max_2=numList[i];
            }
            else if(numList[i]>max_3){
                max_3=numList[i];
            }

            //check against max_1
            if(numList[i]<min_1){
                min_3=min_2;
                min_2=min_1;
                min_1=numList[i];
            }
            else if(numList[i]<min_2){
                min_3=min_2;
                min_2=numList[i];
            }
            else if(numList[i]<min_3){
                min_3=numList[i];
            }
        }

        System.out.println("max_1="+max_1+"::max_2="+max_2+"::max_3="+max_3);
        System.out.println("min_1="+min_1+"::min_2="+min_2+"::min_3="+min_3);

        if((min_1*min_2*max_1)>(max_1*max_2*max_3)){
            return (min_1*min_2*max_1);
        }else{
            return (max_1*max_2*max_3);
        }
    }

    public static void main(String args[]){
        int[] numList={-10,-6,-30,-20,-1,-5};
        MaxOf3Products mp = new MaxOf3Products();
        System.out.println("max product="+mp.maxProduct(numList));

    }
}
