/*******************************
 * Description: Class to represent a job posting and its details
 * Author(s): Ross Monaghan
 * Version: 1.0
 * Date Created: 22/03/21
 *******************************/

package ie.gmit;

import java.util.ArrayList;

public class Job
{
    private int employerID;
    private String jobId;
    private String jobTitle;
    private String location;
    private String closingDate;
    private ArrayList<Skill> skillList = new ArrayList<>();
    private ArrayList<Integer> matchList = new ArrayList<>();


    // Job constructor with arguments
    public Job(int employerID, String jobId, String jobTitle, String location, String closingDate, ArrayList<Skill> skills)
    {
        setEmployerID(employerID);
        setJobId(jobId);
        setJobTitle(jobTitle);
        setLocation(location);
        setClosingDate(closingDate);
        setSkillList(skills);

    }

    // Method to add a match to the match list
    public void addMatch(Integer matchAdd)
    {
        if (!matchList.contains(matchAdd)) {
            matchList.add(matchAdd);
        }
        else {
            throw new IllegalArgumentException("Employee ID already present, ID not added");
        }
    }

    // Method to remove a match from the match list
    public void clearMatches()
    {
        matchList.clear();
    }

    // Mutators
    public void setEmployerID(int employerID)
    {
        if (employerID > 0) {
            this.employerID = employerID;
        }
        else {
            throw new IllegalArgumentException("Invalid Employer ID");
        }

    }

    public void setJobId(String jobId)
    {
        if(jobId.length() > 0) {
            this.jobId = jobId;
        }
        else {
            throw new IllegalArgumentException("Invalid Job ID");
        }
    }

    public void setJobTitle(String jobTitle)
    {
        if (jobTitle.length() >= 3) {
            this.jobTitle = jobTitle;
        }
        else {
            throw new IllegalArgumentException("Invalid Job Title");
        }
    }

    public void setLocation(String location)
    {
        if (location.length() >= 2) {
            this.location = location;
        }
        else {
            throw new IllegalArgumentException("Invalid Location");
        }
    }

    public void setClosingDate(String closingDate)
    {
        if (closingDate.length() >= 8) {
            this.closingDate = closingDate;
        }
        else {
            throw new IllegalArgumentException("Closing date must be in format dd/mm/yy");
        }
    }

    public void setSkillList(ArrayList<Skill>skillList)
    {
        if(!skillList.isEmpty()) {
            this.skillList = skillList;
        }
        else {
            throw new IllegalArgumentException("Skill list must have at least one skill");
        }
    }

    // Accessors
    public int getEmployerID()
    {
        return employerID;
    }

    public String getJobId()
    {
        return jobId;
    }

    public String getJobTitle()
    {
        return jobTitle;
    }

    public String getLocation()
    {
        return location;
    }

    public String getClosingDate()
    {
        return closingDate;
    }

    public ArrayList<Skill> getSkillList()
    {
        return skillList;
    }

    public int getMatchListSize()
    {
        return matchList.size();
    }

    public ArrayList<Integer> getMatchList()
    {
        return matchList;
    }

}
