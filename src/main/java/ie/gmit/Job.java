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
    private String jobId;
    private String jobTitle;
    private String location;
    private String closingDate;
    private ArrayList<Skill> skillList = new ArrayList<>();;

    // Job constructor with arguments
    public Job(String jobId, String jobTitle, String location, String closingDate, ArrayList<Skill> skills)
    {
        setJobId(jobId);
        setJobTitle(jobTitle);
        setLocation(location);
        setClosingDate(closingDate);
        setSkillList(skills);
    }
    public Job(String jobId, String jobTitle, String location, String closingDate)
    {
        setJobId(jobId);
        setJobTitle(jobTitle);
        setLocation(location);
        setClosingDate(closingDate);
    }

    public void setSkillList(ArrayList<Skill>skillList){
        this.skillList = skillList;
    }
    // Method to add a skill to the skill list
    public boolean addSkill(Skill skillAdd)
    {
        for(Skill skillExisting : skillList) {
            if (skillExisting.getSkillName().equals(skillAdd.getSkillName())) {
                throw new IllegalArgumentException("Duplicate Skill found, no object added");
            }
        }
        skillList.add(skillAdd);
        return true;
    }

    // Method to remove a job from the job list
    public Boolean removeSkill(String skillName)
    {
        for(Skill skillRemove : skillList) {
            if (skillRemove.getSkillName().equals(skillName)) {
                skillList.remove(skillRemove);
                return true;
            }
        }
        return false;
    }

    // Mutators
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
            throw new IllegalArgumentException("Invalid Closing Date");
        }
    }

    // Accessors
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

    public ArrayList<Skill> getSkillList() {
        return skillList;
    }
}
