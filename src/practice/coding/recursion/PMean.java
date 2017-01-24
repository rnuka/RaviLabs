package practice.coding.recursion;

/**
 * Created by rnuka on 10/20/15.
 */

/*
Given an array of n integers, return the maximum PMEAN of all possible array rotations,
where PMEAN = the sum of each integer multiplied by its current location (index + 1).

For example:

The PMEANs for every rotation of the array {20, 30, 10} are:

PMEAN1 = (1 * 20) + (2 * 30) + (3 * 10) = 110
PMEAN2 = (1 * 30) + (2 * 10) + (3 * 20) = 110
PMEAN3 = (1 * 10) + (2 * 20) + (3 * 30) = 140

The max PMEAN of array {20, 30, 10} is 140.
The question is simple enough. I was able to get a working algorithm quick enough, but I failed to optimize my answer.
Hint from the interviewer:
If you have PMEANn, how can you use the result to get PMEANn+1?


case:1 (only one element)
20
p(1)=20

case:2 (two elements)
20,30
p(1) = 20+2*30
p(2) (goal: 30+2.20) = (20+2.*30) - 30 + 20

case:3 (three elements)
20,30,10
p(1) = 20+2.30+3.10 = 20+60+30 = 110
p(2)(goal 1.30+2.10+3.20) = (20+2.30+3.10) -30-10 -20+ 3*20 = p(1)-TS+(n+1)arr[n-1];
     = 110-30-10-20+60
     =110
     = 1.30+2.10+3.20

p(3)(goal 1.10+2.20+3.30) = (1.30+2.10+3.20)-10-20-30 +2.30+30


Rule: f(n) = f(n-1)+∑n + n*arr[n-1]

 */

public class PMean {
    int[] pmean;
    static int max;

    public PMean(int n){
        pmean = new int[n];

    }

    int add(int[] arr){
        int sum = 0;

        for(int i:arr){
            sum+=i;
        }
        return sum;
    }



    int maxPMean(int[] arr, int n){

        //if n is 0
        if(n<0) {
            return 0;
        }

        //f(1) case
        if(n==0) {
            int sum = 0;
            int k=1;
            for(int i:arr){
                sum+=i*k++;
            }
            return sum;
        }


        int result = maxPMean(arr, n-1) - add(arr) + (arr.length) * arr[n - 1];

        pmean[n] = result;

        //return max in final iteration
        if(n == arr.length) {
            for (int curr : pmean) {
                if (max < curr) {
                    max = curr;
                }
            }
        }

        return result;
    }

    public static void main(String[] args){
        int[] arr = {20,30,10};
        PMean pm = new PMean(arr.length);
        System.out.println("pmean max="+pm.maxPMean(arr,arr.length-1));

    }
}
