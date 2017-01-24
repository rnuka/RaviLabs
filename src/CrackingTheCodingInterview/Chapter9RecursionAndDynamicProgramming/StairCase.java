package CrackingTheCodingInterview.Chapter9RecursionAndDynamicProgramming;

/**
 * Created by rnuka on 10/18/15.
 */
/*
Question 9.1 A child is running up a staircase with n steps, and can hop either 1 step, 2 steps, or
3 steps at a time. Implement a method to count how many possible ways the child
can run up the stairs.
 */
/*
input: stair case with n steps
output: possible ways to climb n step stair case if allowed to hop 1-step, 2-steps or 3-steps at a time
*/
public class StairCase {

    int[] stepWays;

    //constructor
    public StairCase(int n){
        stepWays = new int[n+1];

        //initialize to -1
        for(int i=0; i<=n; i++){
            stepWays[i] = -1;
        }

    }

    //possible ways to climb stair case
    int noOfWays(int n){

        //if <0 steps in stair case
        if(n < 0){
            return 0;
        }

        //base case-1 for step-1
        if(n == 0){
            return 1;
        }

        if(stepWays[n] > -1) {
            return stepWays[n];
        }else{
            stepWays[n] = noOfWays(n-1) + noOfWays(n-2) + noOfWays(n-3);
        }
        return stepWays[n];
    }

    //test
    public static void main(String[] args){
        int n = 3;
        StairCase sc = new StairCase(n);
        System.out.println("no of ways for "+n+" step case to hop is::"+sc.noOfWays(n));
    }




}
