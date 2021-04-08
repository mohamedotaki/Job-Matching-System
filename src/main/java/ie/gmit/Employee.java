/*******************************
 * Description: Class to represent an employee and their details
 * Author(s): Mohamed Otaki
 * Version: 1.0
 * Date Created: 23/03/21
 *******************************/

package ie.gmit;

import java.util.ArrayList;

public class Employee extends User
{
    private String degree;
    private ArrayList<Skill> skills;

    public Employee(int id, String title, String name, String email, String password, String phoneNum, String location, String degree)
    {
        super(id, title, name, email, password, phoneNum, location);
        setDegree(degree);
        skills = new ArrayList<>();
    }

    public String getDegree()
    {
        return degree;
    }

    public void setDegree(String degree)
    {
        if(degree.length() <= 5) {
            throw new IllegalArgumentException("Degree name should be more than 5 character");
        }
        else {
            this.degree = degree;
        }
    }

    public boolean addSkill(Skill skill)
    {
        if(skill != null) {
            return skills.add(skill);
        }
        else {
            throw new IllegalArgumentException("Can't add empty skill");
        }
    }

    public boolean removeSkill(int skillIndex)
    {
        if(skills.size() >= skillIndex && skillIndex >= 0) {
            skills.remove(skillIndex);
            return true;
        }
        else {
            throw new IllegalArgumentException("Skill index is out of range");
        }
    }

    public ArrayList<Skill> getSkills()
    {
        return skills;
    }

    public void setSkills(ArrayList<Skill> skills)
    {
        if(skills.isEmpty()) {
            throw new IllegalArgumentException("Skills can't be empty");
        }
        else{
            this.skills = skills;
        }
    }
}
