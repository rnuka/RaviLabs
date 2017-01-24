package practice.coding.math;

import java.util.*;

public class MaxMemoryUsage {
    public MaxMemoryUsage() {
    }
    
    public int getMaxMemoryUsed(List<Job> jobList){
        //sort
        Collections.sort(jobList);
        
        //variables to track prev Job details
        Long prevJobEndTime=0L;
        
        int maxMemoryUsed=0;
        int currentMemoryUsed=0;
        
        Set<Job> currentJobList = new HashSet<Job>();
        
        //loop through each job and check
        for(Job job : jobList){
            System.out.println("current memory="+currentMemoryUsed);
            
            //step-1:check current job vs prev job
            if(job.startTime<prevJobEndTime){  //overlap
                System.out.println("Adding job with memory::"+job.memory);
                currentMemoryUsed+=job.memory;
            }else{
                currentMemoryUsed = job.memory;
            }
    
            
            //step-2: check if prev jobs were ended before current job start time, remove if so
            /*for(Job prevJob: currentJobList){
                if(prevJob.endTime <= job.startTime){
                    System.out.println("removing job and decreasing memory="+prevJob.memory);
                    currentMemoryUsed-=prevJob.memory;
                    currentJobList.remove(prevJob);
                }
            }*/

            for(Iterator<Job> jobs = currentJobList.iterator(); jobs.hasNext();){ //***JAVA-LEARN : ITERATE WHILE REMOVE
                Job prevJob = jobs.next();
                if(prevJob.endTime <= job.startTime){
                    System.out.println("removing job and decreasing memory="+prevJob.memory);
                    currentMemoryUsed-=prevJob.memory;
                    jobs.remove(); //NOTE: Iterator.remove (not collection.remove i.e. set.remove)
                }
            }
            
            //step-3:check maxMemory vs currMemorySum and update
            if(currentMemoryUsed>maxMemoryUsed){
                maxMemoryUsed=currentMemoryUsed;
            }
            
            
            //step-4: add current job to running job list
            currentJobList.add(job);
            
            //step-5:update prev values with current values
            prevJobEndTime = Math.max(prevJobEndTime,job.endTime);
            
            
             
        }
        
        return maxMemoryUsed;
    }
    
    public static void main(String[] args){
        Job job1 = new Job(1000L,1200L,1);
        Job job2 = new Job(1100L,1200L,2);
        Job job3 = new Job(1130L,1830L,3);
        Job job4 = new Job(1200L,1500L,40);
        Job job5 = new Job(1215L,1450L, 50);
        List<Job> jobList = new ArrayList<Job>();
        jobList.add(job1);
        jobList.add(job4);
        jobList.add(job3);
        jobList.add(job2);
        jobList.add(job5);
        MaxMemoryUsage maxMemoryUsed = new MaxMemoryUsage();
        System.out.println("maxMemory="+maxMemoryUsed.getMaxMemoryUsed(jobList));
        
    }
}


