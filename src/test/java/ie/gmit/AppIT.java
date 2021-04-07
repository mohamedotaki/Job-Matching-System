package ie.gmit;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AppIT {
    DataBase dataBase = new DataBase();
    ArrayList<Skill> skills =new ArrayList<>();
    @Test
    void AppIT(){
        // new employer create account test
        Employer employer = new Employer(1,"Mr","Johnnn","john@hotmail.com",
                "password12","1234567890","Galway");
        assertTrue(dataBase.createAccount(employer));
        //Employer login Test
        Employer currentEmployer = (Employer) dataBase.login("john@hotmail.com","password12");
        assertEquals(employer,currentEmployer);
        //add job - test
        currentEmployer.addJob(new Job(1, "1","Software Engineering","Galway","01/06/2021",skills));
        skills.clear();
        skills.add(new Skill(DataBase.getAvailableSkills().get(0),5));
        skills.add(new Skill(DataBase.getAvailableSkills().get(1),5));
        skills.add(new Skill(DataBase.getAvailableSkills().get(5),5));
        currentEmployer.addJob(new Job(1, "2","Test Engineering","Mayo","01/07/2021",skills));
        //assertEquals(2,currentEmployer.getJobList().size());
        //Remove job test
        currentEmployer.removeJob("2");
        //assertEquals(1,currentEmployer.getJobList().size());

        // new employee create account test
        Employee employee = new Employee(2,"Mr","Matttt","matt@hotmail.com",
                "password12","1234567890","Mayo","Software");
        assertTrue(dataBase.createAccount(employee));

        //Employee login test
        Employee currentEmployee = (Employee) dataBase.login("matt@hotmail.com","password12");
        assertEquals(employee, currentEmployee);
        //add skills
        currentEmployee.addSkill(new Skill(DataBase.getAvailableSkills().get(0),5));
        currentEmployee.addSkill(new Skill(DataBase.getAvailableSkills().get(7),5));
        currentEmployee.addSkill(new Skill(DataBase.getAvailableSkills().get(1),5));
        assertEquals(3, currentEmployee.getSkills().size());
        //remove skills
        currentEmployee.removeSkill(2);
        assertEquals(2, currentEmployee.getSkills().size());

        //Match job test






    }
}
