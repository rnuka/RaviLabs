package practice.coding.greedyAlgorithms;

import java.util.*;

/*
Question: Given an array of jobs where every job has a deadline and associated profit
if the job is finished before the deadline. It is also given that every job takes single unit of time,
 so the minimum possible deadline for any job is 1. How to maximize total profit
 if only one job can be scheduled at a time.

 Note: You can return maximum profit or list of jobs that can be run.

Examples:

Input: Four Jobs with following deadlines and profits
  JobID    Deadline      Profit
    a        4            20
    b        1            10
    c        1            40
    d        1            30
Output: Following is maximum profit sequence of jobs
        c, a


Input:  Five Jobs with following deadlines and profits
   JobID     Deadline     Profit
     a         2           100
     b         1           19
     c         2           27
     d         1           25
     e         3           15
Output: Following is maximum profit sequence of jobs
        c, a, e
* */
public class MaxProfitJobs {

    public static class Job{
        int deadLine;
        int profit;
        String name;
        public Job(String name, int deadLine, int profit){
            this.name = name;
            this.deadLine = deadLine;
            this.profit = profit;
        }
    }

    public int[] maximumProfit(List<Job> input){

        input.sort((j1,j2)->(j2.profit-j1.profit));  //JAVA-8

        int[] results = new int[input.size()];

        //create a slot array and fill to true to make all slots available
        boolean[] slot = new boolean[input.size()];
        Arrays.fill(slot, true);

        for(Job j: input){
            System.out.println("current Job:"+j.name+" with profit::"+j.profit);
            int availableSlot = isValid(j.deadLine,slot);
            if(availableSlot != -1){
                results[availableSlot]=j.profit;
            }
        }

        return results;

    }

    private int isValid(int jobDeadLine, boolean[] slot){
        /*
        check from end of deadLine to begin and see if there is any open slot

        Note: you need to traverse from end otherwise lower slots are used first and may not give optimal
              solution to the problem
        */
        for(int i=jobDeadLine-1;i>=0; i--){
            if(slot[i]){
                slot[i]=false;
                return i;
            }
        }
        return -1;
    }

    public static void main(String args[]){
        List<Job> input = new ArrayList();
        input.add(new Job("A", 1, 25));
        input.add(new Job("B", 1, 19));
        input.add(new Job("C", 2, 100));
        input.add(new Job("D", 2, 27));
        input.add(new Job("E", 3, 15));
        input.add(new Job("F", 3, 30));
        input.add(new Job("F", 4, 5));

        MaxProfitJobs m = new MaxProfitJobs();
        int[] output = m.maximumProfit(input);
        System.out.println("-------- Output ---------");
        for(int curr: output){
            System.out.println(""+curr);
        }


    }

}
