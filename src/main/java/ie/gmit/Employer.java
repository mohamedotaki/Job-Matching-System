/*******************************
 * Description: Class to represent an employer and their details
 * Author(s): Ross Monaghan
 * Version: 1.0
 * Date Created: 22/03/21
 *******************************/

package ie.gmit;

import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.ArrayList;

public class Employer extends User
{

    private ArrayList<Job> jobList;

    // Employer constructor with arguments
    public Employer(int id, String title, String name, String email, String password, String phoneNum, String location)
    {
        super(id, title, name, email, password, phoneNum, location);
        jobList = new ArrayList<>();
    }

    // Method to add a job to the job list
    public boolean addJob(Job jobAdd)
    {
        for(Job jobExisting : jobList) {
            if (jobExisting.getJobId().equals(jobAdd.getJobId())) {
                throw new IllegalArgumentException("Duplicate Job id found, no object added");
            }
        }
        jobList.add(jobAdd);
        return true;
    }

    // Method to remove a job from the job list
    public Boolean removeJob(String jobId)
    {
        for(Job jobRemove : jobList) {
            if (jobRemove.getJobId().equals(jobId)) {
                jobList.remove(jobRemove);
                return true;
            }
        }
        return false;
    }

}
