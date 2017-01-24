package practice.coding.others;

/**
 * Created by rnuka on 7/12/16.
 */
public class Job implements Comparable<Job> {
    Long startTime;
    Long endTime;
    Long memory;

    public Job(Long st, Long et, Long mem){
        this.startTime = st;
        this.endTime = et;
        this.memory = mem;
    }

    @Override
    public int compareTo(Job o){
        return this.startTime.compareTo(o.startTime);
    }

}
