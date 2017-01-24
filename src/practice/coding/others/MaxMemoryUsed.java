package practice.coding.others;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by rnuka on 7/12/16.
 */
public class MaxMemoryUsed {
    public Long maxMemoryConsumed(List<Job> jobList){
        Long maxMemory = 0L;
        Collections.sort(jobList, new Comparator<Job>() {
            @Override
            public int compare(Job o1, Job o2) {
                return o1.startTime.compareTo(o2.startTime);
            }
        });

        //Loop through jobs and calculate
        Long currMemoryUsed = 0L;
        List<Job> runningJobs= new ArrayList<Job>();
        for(Job currJob: jobList){
            runningJobs.add(currJob);
            currMemoryUsed += currJob.memory;

            //remove if any old jobs are ended before currJob begins
            int totalRunningJobs = runningJobs.size();
            for(int i=0; i < totalRunningJobs; i++){
                Job prevJob = runningJobs.get(i);
                if(prevJob.endTime <= currJob.startTime){
                    currMemoryUsed-=prevJob.memory;
                    runningJobs.remove(i);
                    i--;
                    totalRunningJobs--;
                }
            }

            //check if this run is max
            if(currMemoryUsed > maxMemory){
                maxMemory = currMemoryUsed;
            }
        }
        return maxMemory;
    }

    void myAssert(boolean x){
        if(!x){
            throw new IllegalArgumentException("Assert Fails");
        }
    }

    void testcase1(){
        Job job1 = new Job(1000L,1200L,1L);
        Job job2 = new Job(1100L,1200L,2L);
        Job job3 = new Job(1130L,1230L,3L);
        Job job4 = new Job(1200L,1500L,40L);
        List<Job> jobList = new ArrayList<Job>();
        jobList.add(job1);
        jobList.add(job4);
        jobList.add(job3);
        jobList.add(job2);
        Long maxMemory = maxMemoryConsumed(jobList);
        System.out.println("maxMemory="+maxMemory);
        myAssert(43L == maxMemory);
    }

    void testbed(){
        testcase1();
    }

    public static void main(String[] args){
        MaxMemoryUsed mmu = new MaxMemoryUsed();
        mmu.testbed();
    }
}
