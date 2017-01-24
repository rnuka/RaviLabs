package practice.coding.dynamicProgramming;

public class MaxSubarraySum {
      //static int[] currArray = {1,99,-4,1,10,-2,-10,-1};
      static int[] currArray = {10,-2,-4,-1,-99,-1,1,2,-2,14,5};
      static  int currSum;
      static  int finalMaxSum;

public static void main(String args[]){       
       //loop through all elements and store current sum and compare against final sum
       for(int i=0;i<currArray.length;i++){
           
           if(currSum+currArray[i]>=0){
               currSum += currArray[i];
           }else{
               currSum = 0;
           }

           //compare current running total against final total 
           if(currSum>finalMaxSum){
              finalMaxSum=currSum;
           }
       }
       
       System.out.println("Max sum="+finalMaxSum);
}
}
