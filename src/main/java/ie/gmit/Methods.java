/*******************************
 * Description: Class to represent a job posting and its details
 * Author(s): Mohamed Otaki, Ricky Small, Ross Monaghan
 * Version: 1.0
 * Date Created: 04/04/21
 *******************************/

package ie.gmit;

import java.util.ArrayList;
import java.util.EnumMap;

public class Methods
{
    // Method to add a user to the database
    public boolean createAccount(User user)
    {
        return DataBase.users.add(user);
    }

    // Method to login a user
    public User login(String email, String pass)
    {
        for(int i = 0; i< DataBase.users.size(); i++) {
            if(DataBase.users.get(i).getEmail().equalsIgnoreCase(email)
            && DataBase.users.get(i).getPassword().equals(pass)){
                return DataBase.users.get(i);
            }
        }
        return null;
    }

    // Method to update all jobs lists of matches
    public void updateMatches()
    {
        int jobCnt = 0;
        for(Job job : DataBase.jobs) {
            int matchCount = 0;
            DataBase.jobs.get(jobCnt).clearMatches();
            ArrayList<Skill> skillsRequired = job.getSkillList();

            for(User user : DataBase.users) {
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
                        DataBase.jobs.get(jobCnt).addMatch(employee.getId());
                    }
                }

            }
            jobCnt++;
        }
    }
}