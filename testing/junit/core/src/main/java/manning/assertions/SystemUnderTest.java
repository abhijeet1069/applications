package manning.assertions;

import java.util.ArrayList;
import java.util.List;

public class SystemUnderTest {
    private String systemName;
    private boolean isVerified;
    private List<Job> jobs = new ArrayList<>();
    private Job currentJob;

    public SystemUnderTest(String systemName) {
        this.systemName = systemName;
        this.isVerified = false;
    }

    public String getSystemName() {
        return systemName;
    }

    public boolean isVerified() {
        return isVerified;
    }

    public void verify() {
        this.isVerified = true;
    }

    public void addJob(Job job) {
        jobs.add(job);
    }

    public Object[] getJobsAsArray() {
        return jobs.toArray();
    }

    public Job getCurrentJob() {
        return currentJob;
    }

    public void run() {
        if (jobs.isEmpty())
            throw new NoJobException("No jobs on execution list!");

        currentJob = jobs.remove(0);
        System.out.println("Running job: " + currentJob);
    }

    public void run(int jobDuration) throws InterruptedException {
        if(jobs.isEmpty())
            throw new NoJobException("No jobs on the execution list!");

        currentJob = jobs.remove(0);
        System.out.println("Running job: " + currentJob + " lasts " + jobDuration + " ms");
        Thread.sleep(jobDuration);
    }
}
