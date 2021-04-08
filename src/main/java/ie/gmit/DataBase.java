/*******************************
 * Description: Test class to test job methods
 * Author(s): Mohamed Otaki,
 * Version: 1.0
 * Date Created: 23/03/21
 *******************************/

package ie.gmit;

import java.util.ArrayList;

public class DataBase
{
    private static ArrayList<User> users = new ArrayList<>();
    private static ArrayList<Job> jobs = new ArrayList<>();

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

    // Method to login a user
    public static User login(String email, String pass)
    {
        for (User user : users) {
            if (user.getEmail().equalsIgnoreCase(email)
                    && user.getPassword().equals(pass)) {
                return user;
            }
        }
        throw new IllegalArgumentException("Wrong email or password");
    }

    public static boolean deleteUser(User user)
    {
        if(user != null) {
            return users.remove(user);
        }
        else {
            throw new IllegalArgumentException("User was not found in database");
        }
    }

    public static boolean addUser(User user)
    {
        if(user != null) {
            for (User value : users) {
                if (user.getId() == value.getId()) {
                    throw new IllegalArgumentException("User ID already in database");
                }
            }
            return users.add(user);
        }
        else {
            throw new IllegalArgumentException("Can't add empty user");
        }
    }

    public static boolean updateUser(User user)
    {
        for(int index = 0; index < users.size(); index++) {
            if (user.getId() == users.get(index).getId()) {
                users.set(index,user);
                return true;
            }
        }
        throw new IllegalArgumentException("User ID was not found in database");
    }

    // Method to update all jobs lists of matches
    public static void updateMatches()
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