package practice.coding.games;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by rnuka on 10/15/15.
 */
/*
 * Take Home Question: Cup Challenge
 You are in a room with a circle of 100 cups. The cups are numbered sequentially from 1 to 100.
 At some point in time, cup #1 is taken away. Cup #2 is skipped, then cup #3 is taken away.
 Then two cups are skipped, and cup #6 is taken away. Then three cups are skipped, and the next one is taken away.
 This pattern of removing cups and skipping more cups continues until only one cup remains.
 A cup that is removed from the circle is gone forever, and is not considered in subsequent skipping calculations.
 Write a program to determine which cup is left after all others have been removed.
 Please send us the answer (in Java) and your working code to wxie@popsugar.com.
 Your code should print the answer to the cup challenge when there are 100 cups.

 Example:

 Cups are marked with a C, removed cups are marked as X. Not pictured in this example is that the cups wrap around in a circle.

 Start:
 C C C C C C C C C C ...

 Step 1: cup #1 is removed
 X C C C C C C C C C ...

 Step 2: cup #2 is skipped, cup #3 is removed
 X C X C C C C C C C ...

 Step 3: cups #4, #5 are skipped, cup #6 is removed
 X C X C C X C C C C ...

 Step 3: cups #7, #8, #9 are skipped, cup #10 is removed
 X C X C C X C C C X ...

 And so on.
 */

public class CupChallenge {

    public int finalCup1(char[] cupSet){

        int n = cupSet.length;
        int remaining_targets = n-1;
        int skip=0;
        int i=0;
        while(remaining_targets>0){
            while(skip>0){
                if(cupSet[i] == 'C') {
                    cupSet[i] = 'X';
                }
            }
            --remaining_targets;
        }

        return -1;
    }


    //return position of last available cup
    public int finalCup(char[] cupSet ){

        //null case
        if(cupSet == null){
            return -1;
        }

        int totalCups = cupSet.length;
        int counter = 0;
        int removeCount = totalCups;
        int skipCount = 0;
        int targetCupToRemove = 1;

        /*To remain one cup, need to remove n-1 cups and hence n-1 targets exists*/
        while(removeCount > 0) {

            if( cupSet[counter] == 'C' && ++skipCount == targetCupToRemove){

                //remove next available cup
                cupSet[counter] = 'X';
                removeCount--;

                //exit condition check
                if(removeCount == 0){
                    counter++;
                    return counter;
                }
                //reset target and skipCounter
                ++targetCupToRemove;
                skipCount = 0;

            }

            counter++;
            //reset counter if last cup
            if (counter == totalCups) {
                counter = 0;
            }
        }

        return -1;

    }


    public int finalCup2(int totalCups){

        Queue<Integer> cups = new LinkedList<>();

        //populate queue with cups
        for(int i=1;i<=totalCups; i++){
            cups.add(i);
        }

        //start extraction
        int skipCount = 0;
        while(cups.size()>1){
            int i=0;
            //skip cups based on skipcount by removing them from front and add at end
            while(i<skipCount){
                cups.add(cups.poll());
                i++;
            }

            //remove a cup
            cups.poll();

            //increase skip count
            skipCount++;

        }

        return cups.poll();


    }

    public static void main(String args[]){

        char[] cupSet = new char[100];
        for(int i=0; i< cupSet.length;i++){
            cupSet[i]='C';
        }
        CupChallenge cups = new CupChallenge();
        System.out.println("finalCup="+cups.finalCup(cupSet));

        int totalCups = 100;
        System.out.println("final cup using new process::"+cups.finalCup2(totalCups));
    }

}

