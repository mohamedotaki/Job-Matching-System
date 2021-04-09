/*******************************
 * Description: Test class to test all the methods working together
 * Author(s): Mohamed Otaki
 * Version: 1.0
 * Date Created: 05/04/21
 *******************************/

package ie.gmit;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;


public class AppIT
{
    DataBase dataBase = new DataBase();

    @Test
    void AppIT()
    {
        // new employer create account test
        Employer employer = new Employer(1,"Mr","Johnnn","john@hotmail.com",
                "password12","1234567890","Galway");
        assertTrue(dataBase.addUser(employer));

        //Employer login Test
        Employer currentEmployer = (Employer) dataBase.login("john@hotmail.com","password12");
        assertEquals(employer,currentEmployer);

        //add job test
        ArrayList<Skill> job1Skills =new ArrayList<>();
        job1Skills.add(new Skill(DataBase.getAvailableSkills().get(0),5));
        job1Skills.add(new Skill(DataBase.getAvailableSkills().get(7),5));
        currentEmployer.addJob(new Job(1, "1","Software Engineering","Galway","01/06/2021",job1Skills));
        ArrayList<Skill> job2Skills = new ArrayList<>();
        job2Skills.add(new Skill(DataBase.getAvailableSkills().get(0),5));
        job2Skills.add(new Skill(DataBase.getAvailableSkills().get(1),5));
        job2Skills.add(new Skill(DataBase.getAvailableSkills().get(5),5));
        currentEmployer.addJob(new Job(1, "2","Test Engineering","Mayo","01/07/2021",job2Skills));
        assertEquals(2,DataBase.getJobs().size());

        //Remove job test
        currentEmployer.removeJob("2");
        assertEquals(1,DataBase.getJobs().size());

        // new employee create account test
        Employee employee = new Employee(2,"Mr","Matttt","matt@hotmail.com",
                "password12","1234567890","Mayo","Software");
        assertTrue(dataBase.addUser(employee));

        //Employee login test
        Employee currentEmployee = (Employee) dataBase.login("matt@hotmail.com","password12");
        assertEquals(employee, currentEmployee);

        //add skills
        currentEmployee.addSkill(new Skill(DataBase.getAvailableSkills().get(0),6));
        currentEmployee.addSkill(new Skill(DataBase.getAvailableSkills().get(7),6));
        currentEmployee.addSkill(new Skill(DataBase.getAvailableSkills().get(1),5));
        assertEquals(3, currentEmployee.getSkills().size());

        //change employee details and update in database
        currentEmployee.setName("Ricky");
        DataBase.updateUser(currentEmployee);
        Employee updatedEmployee = (Employee) DataBase.login("matt@hotmail.com","password12");
        assertEquals(currentEmployee.getName(),updatedEmployee.getName());

        //remove skills
        currentEmployee.removeSkill(2);
        assertEquals(2, currentEmployee.getSkills().size());

        //Match job test
        DataBase.updateMatches();
        int[] matches = DataBase.getJobs().get(0).getMatchList().get(0);
        assertEquals(2, matches[0]);

        //Delete user test
        DataBase.deleteUser(updatedEmployee);
        assertThrows(IllegalArgumentException.class,()->DataBase.login("matt@hotmail.com","password12"));


    }
}
