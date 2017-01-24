package practice.coding.math;

import java.util.Iterator;

public class Job implements Comparable<Job> {
    public Job() {
    }
    Long    startTime;
    Long    endTime;
    Integer memory;
    public Job(Long startTime, Long endTime, Integer memory ){
        this.startTime = startTime;
        this.endTime   = endTime;
        this.memory    = memory;
    }
    public int compareTo(Job that){
        if(this.startTime == that.startTime){ //same start time
            return this.endTime.compareTo(that.endTime);
        }
        return this.startTime.compareTo(that.startTime);
    }

    public Integer getMemory() {
        return memory;
    }
}
