/*******************************
 * Description: Class to represent an employer and their details
 * Author(s): Ross Monaghan
 * Version: 1.0
 * Date Created: 22/03/21
 *******************************/

package ie.gmit;

import java.util.ArrayList;

public class Employer extends User
{
    DataBase database = new DataBase();

    // Employer constructor with arguments
    public Employer(int id, String title, String name, String email, String password, String phoneNum, String location)
    {
        super(id, title, name, email, password, phoneNum, location);
    }

    // Method to add a job to the job list
    public void addJob(Job jobAdd)
    {
        if (jobAdd.getEmployerID()==getId()) {
            database.addJob(jobAdd);
        }
        else {
            throw new IllegalArgumentException("Employer IDs do not match, no object added");
        }
    }

    // Method to remove a job from the job list
    public void removeJob(String jobRemove)
    {
        Job toRemove = null;
        ArrayList<Job> jobsList = DataBase.getJobs();
        for(Job job : jobsList) {
            if (job.getJobId().equals(jobRemove) && job.getEmployerID()==getId()) {
                toRemove = job;
            }
        }
        if (toRemove!=null) {
            database.removeJob(toRemove);
        }
        else {
            throw new IllegalArgumentException("Error removing job");
        }

    }
}
