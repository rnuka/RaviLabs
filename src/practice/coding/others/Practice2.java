package practice.coding.others;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by rnuka on 12/12/15.
 */

public class Practice2 {

    public static class Job {
        long startTime;
        long endTime;
        int memory;

        public Job(long startTime, long endTime, int memory) {
            this.startTime = startTime;
            this.endTime = endTime;
            this.memory = memory;
        }
    }


    //input List of jobs, output list of jobs that consumed maximum cpu
    //step1: sort the jobs by start time
    //step2: travel each job and add to final

    public int maxMemoryUsage(List<Job> jobList){

        //step1: sort list by start time
        Collections.sort(jobList, new Comparator<Job>() {
            @Override
            public int compare(Job a, Job b){
                if (a.startTime > b.startTime){
                    return 1;
                }
                else if (a.startTime < b.startTime){
                    return -1;
                }
                else{
                    return 0;
                }
            }

        });

        //step2:
        long prevJobEndtime = 0L;
        int currMaxMemory = 0;
        int finalMaxMemory = 0;
        List<Job> prevJobs = new ArrayList<Job>();
        for(Job currJob: jobList){

            //check curr job vs prev job
            if(currJob.startTime < prevJobEndtime){
                currMaxMemory+= currJob.memory;
            }else{
                currMaxMemory = currJob.memory;
            }

            //remove jobs ended by the time curr job starts
            for(Job prevJob: prevJobs){
                if(prevJob.endTime <= currJob.startTime){
                    currMaxMemory-=prevJob.memory;
                }
            }

            //compare currMaxMemory vs finalMaxMemory and update
            if(currMaxMemory > finalMaxMemory){
                finalMaxMemory = currMaxMemory;
            }

            //add curr job to prev jobs list
            prevJobs.add(currJob);

            //update prevjobEndtime
            prevJobEndtime = currJob.endTime;



        }

        return finalMaxMemory;
    }

    public static void main(String[] args){
        Job job1 = new Job(1000L,1200L,1);
        Job job2 = new Job(1100L,1200L,2);
        Job job3 = new Job(1130L,1230L,3);
        Job job4 = new Job(1200L,1500L,40);
        List<Job> jobList = new ArrayList<Job>();
        jobList.add(job1);
        jobList.add(job4);
        jobList.add(job3);
        jobList.add(job2);
        Practice2 maxMemoryUsed = new Practice2();
        System.out.println("maxMemory="+maxMemoryUsed.maxMemoryUsage(jobList));

    }
}
