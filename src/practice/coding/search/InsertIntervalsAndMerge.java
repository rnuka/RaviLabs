package practice.coding.search;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*
Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).
You may assume that the intervals were initially sorted according to their start times.

Example 1:
---------
Given intervals [1,3],[6,9] , insert and merge [2,5] in as [1,5],[6,9] .


Example 2:
----------
Given [1,2],[3,5],[6,7],[8,10],[12,16] , insert and merge [4,9] in as [1,2],[3,10],[12,16] .
Explanation: This is because the new interval [4,9] overlaps with [3,5],[6,7],[8,10] .
 */
public class InsertIntervalsAndMerge {

    public static class Interval{
        int start;
        int end;
        public Interval(int start, int end){
            this.start = start;
            this.end = end;
        }
    }

    //bruteforce approach: Time Complexity O(N) and space complexity of O(N)
    public List<Interval> insertAndMerge(List<Interval> input, Interval target){
        List<Interval> results = new ArrayList<>();

        for(int i=0; i<input.size(); i++){
            Interval curr = input.get(i);
            if(curr.start>target.end ||curr.end < target.start){ //no overlap
                results.add(curr);
            }else{ //overlap
                int start = Math.min(curr.start,target.start);
                int end = curr.end;
                //Keep moving the current intervals until no overlap with target
                while(i<input.size() && curr.start<target.end){
                    i++;
                    if(i<input.size()) {
                        curr = input.get(i);
                    }
                }
                //move one step back as we are in next element than our target
                i--;
                curr = input.get(i);
                end = Math.max(curr.end, target.end);
                results.add(new Interval(start,end));
            }
        }
        return results;
    }

    /*
    Optimized solution : Using binary search approach
    Time Complexity: best case: O(logN) and worst case O(N) with space complexity of O(1)
     */
    public List<Interval> insertAndMerge2(List<Interval> input, Interval target){

        //handle single element cases here
        if(input.size()==0){
            return null;
        }else if(input.get(0).start>target.end || input.get(input.size()-1).end < target.start){ //no overlap
                input.add(target);
        }else{
            int result = insertAndMerge2(input, 0, input.size() - 1, target);
            if(result == -1){
                input.add(target);
            }
        }
        return input;
    }

    //TODO: complex code written, need to see if can be simplified.
    private int insertAndMerge2(List<Interval> input, int low, int high, Interval target){

        if(low>=high && (low <input.size() &&
                (input.get(low).end < target.start && input.get(low).start>target.end)
        )){
            return -1;
        }

        int mid = (low+high)/2;
        int midMinus1 = Math.max(mid - 1, 0);

        if((input.get(midMinus1).start<=target.start && (midMinus1 == mid || target.start <=input.get(mid).start))){

            //check if mid-1 is overlapping with target or not
            int start, end; //initialize

            //Logic to handle if mid-1 overlap scenario
            if(input.get(midMinus1).end < target.start){ //mid-1 is not overlapping
                start = target.start;
                midMinus1++;
            }else{ //if overlaps
                //remove mid-1 element as newly formed start, end interval will over mid-1 interval
                start = Math.min(input.get(midMinus1).start, target.start);
                input.remove(midMinus1);
            }

            //Traverse until overlap is gone for rest of the elements.
            Interval temp = target;
            while(midMinus1<input.size() && input.get(midMinus1).start<target.end){
                temp = input.get(midMinus1);
                input.remove(midMinus1); // no need to increase counter as we are removing elements.
            }

            end = Math.max(target.end, temp.end);

            if(midMinus1==input.size()) {
                input.add(new Interval(start, end));
            }else {
                input.add(midMinus1, new Interval(start, end));
            }
        }else{//continue binary search
            if(input.get(mid).start>target.start){
                insertAndMerge2(input, low, mid-1,target);
            }else{
                insertAndMerge2(input,mid+1,high,target);
            }
        }

        return 0;
    }


    public void testcase8(){
        System.out.println(" **** TESTCASE-8 ******");
        List<Interval> input = new ArrayList<>();
        input.add(new Interval(0,1));
        input.add(new Interval(3,5));
        input.add(new Interval(8,10));
        Interval target = new Interval(2,20);

        for(Interval curr: insertAndMerge(input, target)){
            System.out.println("curr start="+curr.start+ " and end="+curr.end);
        }
    }

    public void testcase7(){
        System.out.println(" **** TESTCASE-7 (Binary Search Approach) ******");
        List<Interval> input = new LinkedList<>();
        input.add(new Interval(12,33));
        Interval target = new Interval(2,15);

        for(Interval curr : insertAndMerge2(input, target)){
            System.out.println("curr start="+curr.start+ " and end="+curr.end);
        }
    }


    public void testcase6(){
        System.out.println(" **** TESTCASE-6 (Binary Search Approach) ******");
        List<Interval> input = new LinkedList<>();
        input.add(new Interval(1,3));
        input.add(new Interval(27,33));
        Interval target = new Interval(4,15);

        for(Interval curr : insertAndMerge2(input, target)){
            System.out.println("curr start="+curr.start+ " and end="+curr.end);
        }
    }

    public void testcase5(){
        System.out.println(" **** TESTCASE-5 (Binary Search Approach) ******");
        List<Interval> input = new LinkedList<>();
        input.add(new Interval(1,2));
        input.add(new Interval(4, 6));
        input.add(new Interval(9,18));
        Interval target = new Interval(3,15);

        for(Interval curr : insertAndMerge2(input, target)){
            System.out.println("curr start="+curr.start+ " and end="+curr.end);
        }
    }

    public void testcase4(){
        System.out.println(" **** TESTCASE-4 (Binary Search Approach) ******");
        List<Interval> input = new LinkedList<>();
        input.add(new Interval(1,3));
        Interval target = new Interval(2,5);

        for(Interval curr : insertAndMerge2(input, target)){
            System.out.println("curr start="+curr.start+ " and end="+curr.end);
        }
    }


    public void testcase3(){
        System.out.println(" **** TESTCASE-3 ******");
        List<Interval> input = new ArrayList<>();
        input.add(new Interval(1,2));
        input.add(new Interval(4,6));
        input.add(new Interval(9,18));
        Interval target = new Interval(3,15);

        for(Interval curr: insertAndMerge(input, target)){
            System.out.println("curr start="+curr.start+ " and end="+curr.end);
        }
    }


    public void testcase2(){
        System.out.println(" **** TESTCASE-2 ******");
        List<Interval> input = new ArrayList<>();
        input.add(new Interval(1,3));
        Interval target = new Interval(2,5);

        for(Interval curr: insertAndMerge(input, target)){
            System.out.println("curr start="+curr.start+ " and end="+curr.end);
        }
    }

    public void testcase1(){
        List<Interval> input = new ArrayList<>();
        //[1,3],[6,9]
        input.add(new Interval(1,3));
        input.add(new Interval(6,9));
        Interval target = new Interval(2,5);

        for(Interval curr: insertAndMerge(input, target)){
            System.out.println("curr start="+curr.start+ " and end="+curr.end);
        }
    }

    public void testbed(){
//        testcase1();
//        testcase2();
//        testcase3();
        testcase4();
//        testcase5();
//        testcase6();
   //    testcase7();
        testcase8();
    }

    public static void main(String[] args){
        InsertIntervalsAndMerge insert = new InsertIntervalsAndMerge();
        insert.testbed();
    }

}
