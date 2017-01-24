package practice.coding.sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
Given a collection of intervals, merge all overlapping intervals.

For example,
Given [1,3],[2,6],[8,10],[15,18],
return [1,6],[8,10],[15,18]
 */

/*
Keypoints: Input is not sorted
 */
public class MergeIntervals {

    //Interval Class
    public static class Interval{
        int start, end;
        public Interval(int start, int end){
            this.start = start;
            this.end = end;
        }
    }

    public List<Interval> merge(List<Interval> input){
        //sort the input as per start values
        Collections.sort(input, (Interval i1, Interval i2)->Integer.compare(i1.start,i2.start)); //TODO:separate method

        List<Interval> results = new ArrayList<>();
        Interval previous = null;
        for(Interval curr: input){
            if(previous == null || previous.end < curr.start){ //non-overlap case
                if(previous !=null){
                    results.add(previous);
                }
                previous = new Interval(curr.start, curr.end);
            }else{
                previous.start = Math.min(previous.start, curr.start);
                previous.end = Math.max(previous.end, curr.end);
            }
        }
        //Very important to add below code to handle last previous interval
        if(previous != null){
            results.add(previous);
        }
        return results;
    }



    public void testcase3(){
        System.out.println(" **** TESTCASE-3 ******");
        List<Interval> input = new ArrayList<>();
        input.add(new Interval(1,5));
        input.add(new Interval(4,6));
        input.add(new Interval(9,18));

        for(Interval curr: merge(input)){
            System.out.println("curr start="+curr.start+ " and end="+curr.end);
        }
    }


    public void testcase2(){
        System.out.println(" **** TESTCASE-2 ******");
        List<Interval> input = new ArrayList<>();
        input.add(new Interval(1,3));

        for(Interval curr: merge(input)){
            System.out.println("curr start="+curr.start+ " and end="+curr.end);
        }
    }

    public void testcase1(){
        List<Interval> input = new ArrayList<>();
        //[1,3],[6,9]
        input.add(new Interval(1,3));
        input.add(new Interval(6,9));

        for(Interval curr: merge(input)){
            System.out.println("curr start="+curr.start+ " and end="+curr.end);
        }
    }

    public void testbed(){
        testcase1();
        testcase2();
        testcase3();
    }

    public static void main(String[] args){
        MergeIntervals merge = new MergeIntervals();
        merge.testbed();
    }



}
