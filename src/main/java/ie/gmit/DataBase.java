package ie.gmit;

import java.util.ArrayList;

public class DataBase
{
    static public ArrayList<User> users = new ArrayList<>();
    static public ArrayList<Job> jobs = new ArrayList<>();

    static public ArrayList<String> getAvailableSkills()
    {
        ArrayList<String> availableSkills = new ArrayList<>();
        availableSkills.add("Communication");
        availableSkills.add("Computer");
        availableSkills.add("People");
        availableSkills.add("Leadership");
        availableSkills.add("Organizational");
        availableSkills.add("Time management");
        availableSkills.add("Collaboration");
        availableSkills.add("Problem-solving");
        availableSkills.add("Coding");
        return availableSkills;
    }
}