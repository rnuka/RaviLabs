package practice.coding.arrays;

/*Question: Given an array of integers, find the position such that sum of all elements before that index is equal to
sum of all rest of the elements from that index. return -1 if no such index exists*/
/*
* Note: Same as Equilibrium.java but much more efficient one if input array is sorted.
* */
public class MiddleIndex {
    public MiddleIndex() {
    }
    
    public static void main(String args[]){
        int[] arr = {1,2,3,4,5,5};
        int forwardSum=0;
        int startIndex=0;
        int endIndex=arr.length-1;
        int backwardSum=0;
         
        while(true){
            if(forwardSum<backwardSum){
                forwardSum = forwardSum+arr[startIndex++];
            }else{
                if(startIndex>endIndex){
                    if(forwardSum==backwardSum){
                        System.out.println("Index found:"+startIndex--);
                        break;
                    }else{
                        System.out.println("No such case exists");
                        break;
                    }
                }else{
                    backwardSum = backwardSum+arr[endIndex--];
                }
            }
        }
     }
}
