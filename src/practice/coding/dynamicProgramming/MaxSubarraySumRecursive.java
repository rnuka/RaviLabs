package practice.coding.dynamicProgramming;

/*
* Below solution is recursive approach for max sub array sum problem. This is bad because there are lot of
* repetitive recursive calls, using DP approach will be ideal instead of simple recursion.
* */
public class MaxSubarraySumRecursive {
    public MaxSubarraySumRecursive() {
    }
    
    int[] arrLst = {10,-2,-4,-1,-99,-1,1,2,-2,14,5};
    
    int startIndex;
    int endIndex;
    int maxValue;
    int currStartIndex;
    
    
    
    /*
     * Psuedo Code: Dynamic Programming approach
     * f(n) = max(f(n-1)+myArray[n], myArray[n])
     * 
     * */
     
     public static void main(String args[]){
         
        MaxSubarraySumRecursive ls = new MaxSubarraySumRecursive();
        ls.maxSeq(ls.arrLst.length-1);
        System.out.println("maximumValue="+ls.maxValue);
        System.out.println("startIndex="+ls.startIndex);
        System.out.println("endIndex="+ls.endIndex);
         
     }
     
     public int maxSeq(int endPosition){
     
         int tempValue=0;
         
         
         if(endPosition==0){
             startIndex=0;
             endIndex=0;
             maxValue=arrLst[0];
             return arrLst[0];
         }else{
             
           //Optimal subproblem
           tempValue= maxSeq(endPosition-1)+arrLst[endPosition];
             
           
           if(tempValue < arrLst[endPosition]){
               currStartIndex=endPosition;
               tempValue=arrLst[endPosition];
           }
           if(tempValue>maxValue){
               startIndex=currStartIndex;
               endIndex = endPosition;
               maxValue=tempValue;
           }
             
           return tempValue;  
         }
     }
         
}
