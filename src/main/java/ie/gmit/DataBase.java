package ie.gmit;

import java.util.ArrayList;

public class DataBase
{
    static private ArrayList<User> users = new ArrayList<>();
    static private ArrayList<Job> jobs = new ArrayList<>();

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

    // Mutators
    public boolean addJob(Job jobAdd)
    {
        return (jobs.add(jobAdd));
    }

    public boolean removeJob(Job jobRemove)
    {
        return (jobs.remove(jobRemove));
    }

    // Accessor
    public static ArrayList<Job> getJobs()
    {
        return jobs;
    }

    // Method to add a user to the database
    public boolean createAccount(User user)
    {
        return users.add(user);
    }

    // Method to login a user
    public User login(String email, String pass)
    {
        for(int i = 0; i< users.size(); i++) {
            if(users.get(i).getEmail().equalsIgnoreCase(email)
                    && users.get(i).getPassword().equals(pass)){
                return users.get(i);
            }
        }
        return null;
    }

    // Method to update all jobs lists of matches
    public void updateMatches()
    {
        int jobCnt = 0;
        for(Job job : jobs) {
            int matchCount = 0;
            jobs.get(jobCnt).clearMatches();
            ArrayList<Skill> skillsRequired = job.getSkillList();

            for(User user : users) {
                if (user instanceof Employee) {
                    Employee employee = (Employee) user;
                    ArrayList<Skill> employeeSkills = employee.getSkills();

                    for (Skill skillRequired : skillsRequired) {
                        for (Skill employeeSkill : employeeSkills) {
                            if (employeeSkill.getSkillName().equals(skillRequired.getSkillName())
                                    && employeeSkill.getSkillLevel() >= skillRequired.getSkillLevel()) {
                                matchCount++;
                            }
                        }
                    }

                    if (matchCount>skillsRequired.size()/2) {
                        jobs.get(jobCnt).addMatch(employee.getId(), matchCount/skillsRequired.size()*100);
                    }
                }
            }
            jobCnt++;
        }
    }
}