package practice.coding.dynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
* Problem Statement: Imagine you have a homework assignment with different parts labeled A through G. Each part has
a “value” (in points) and a “size” (time in hours to complete). For example, say the values and
times for our assignment are:

Example:
--------
Assignment:  A  B  C   D   E  F   G
     value:  7  9  5  12  14  6  12
      time:  3  4  2   6   7  3   5

Say you have a total of 15 hours: which parts should you do to get maximum value or what is the maximum value
you can get?

The above is an instance of the knapsack problem, formally defined as follows:
Definition:
-----------
 In the knapsack problem we are given a set of n items, where each item i is
specified by a size si and a value vi. We are also given a size bound S (the size of our knapsack).
The goal is to find the subset of items of maximum total value such that sum of their sizes is at
most S (they all fit into the knapsack).

Recursive algorithm: either we use the last element or we don’t.
--------------------

Value(n,S) // S = space left, n = # items still to choose from
{
if (n == 0)
    return 0;
if (s_n > S)
    result = Value(n-1,S); // can’t use nth item
else
    result = max{v_n + Value(n-1, S-s_n), Value(n-1, S)};

return result;
}

* */
public class Knapsack {



    public static class Assignment{
        String name;
        int time;
        int value;
        public Assignment(String name, int value, int time){
            this.name = name;
            this.time = time;
            this.value = value;
        }
    }

    public int value(List<Assignment> assignments, int totalHours){

        return value(assignments, totalHours, assignments.size());
    }

    public int valuedp(List<Assignment> assignments, int totalHours){

        int[][] dp = new int[assignments.size()+1][totalHours+1];
        //initialize
        for(int[] row: dp) {
            Arrays.fill(row, -1);
        }

        return valuedp(assignments, totalHours, assignments.size()-1, dp);
    }

    //Bad performance: because of too many repetitive same child recursions.
    private int value(List<Assignment> assignments, int remainingHours, int remainingAssignments){
        if(remainingAssignments==0){
            return 0;
        }else if(assignments.get(remainingAssignments-1).time > remainingHours){
            return value(assignments,remainingHours,remainingAssignments-1);
        }else{
            int currAssignmentValue = assignments.get(remainingAssignments-1).value;
            int currAssignmentTime = assignments.get(remainingAssignments-1).time;
            return Math.max(
                    //add currAssignment value and solve for remaining assignments with (remaining time - currtime)
                    currAssignmentValue + value(assignments, (remainingHours-currAssignmentTime),remainingAssignments-1),
                    //skip curr assignment value and solve for remaining assignments with remaining time
                    value(assignments, remainingHours,remainingAssignments-1));
        }

    }

    //good performance: using dp
    private int valuedp(List<Assignment> assignments, int remainingHours, int remainingAssignments, int[][] dp) {

        int retVal = 0;

        if(remainingHours <0 || remainingAssignments <0){
            return 0;
        }else if(dp[remainingAssignments][remainingHours] != -1){
            return dp[remainingAssignments][remainingHours];
        }else if(assignments.get(remainingAssignments).time > remainingHours){
                retVal = valuedp(assignments, remainingHours, remainingAssignments-1,dp);

        }else{
            int currAssignmentValue = assignments.get(remainingAssignments).value;
            int currAssignmentTime = assignments.get(remainingAssignments).time;
            retVal = Math.max((currAssignmentValue+
                                valuedp(assignments, remainingHours-currAssignmentTime,remainingAssignments-1,dp)),
                                valuedp(assignments, remainingHours,remainingAssignments-1,dp)
                              );
        }

        return dp[remainingAssignments][remainingHours]=retVal;

    }

    public static void main(String args[]){
        Assignment a1= new Assignment("A",7,3);
        Assignment a2= new Assignment("B",9,4);
        Assignment a3= new Assignment("C",5,2);
        Assignment a4= new Assignment("D",12,6);
        Assignment a5= new Assignment("E",14,7);
        Assignment a6= new Assignment("F",6,3);
        Assignment a7= new Assignment("G",12,5);

        List<Assignment> input = new ArrayList<>();
        input.add(a1);
        input.add(a2);
        input.add(a3);
        input.add(a4);
        input.add(a5);
        input.add(a6);
        input.add(a7);


        Knapsack k = new Knapsack();
        System.out.println("max score in 15 hours can be::"+k.valuedp(input, 15));
    }
}
