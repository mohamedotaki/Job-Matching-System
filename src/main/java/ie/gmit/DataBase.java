package ie.gmit;

import java.util.ArrayList;

public class DataBase
{
    static public ArrayList<User> users = new ArrayList<>();
    static public ArrayList<Job> jobs = new ArrayList<>();

    static public ArrayList<Skill> availableSkills()
    {
        ArrayList<Skill> availableSkills = new ArrayList<>();
        availableSkills.add(new Skill("Communication",5));
        availableSkills.add(new Skill("Computer",5));
        availableSkills.add(new Skill("People",5));
        availableSkills.add(new Skill("Leadership",5));
        availableSkills.add(new Skill("Organizational",5));
        availableSkills.add(new Skill("Time management",5));
        availableSkills.add(new Skill("Collaboration",5));
        availableSkills.add(new Skill("Problem-solving",5));
        availableSkills.add(new Skill("Coding",5));
        return availableSkills;
    }


}