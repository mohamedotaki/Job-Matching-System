package ie.gmit;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AppIT {
    Methods methods= new Methods();
    @Test
    void AppIT(){
        // new employer create account test
        Employer employer = new Employer(1,"Mr","John","john@hotmail.com",
                "password","1234567890","Galway");
        assertTrue(methods.createAccount(employer));
        // new employee create account test
        ArrayList<Skill> skills =new ArrayList<>();
        skills.add(DataBase.availableSkills().get(8));
        skills.add(DataBase.availableSkills().get(7));
        Employee employee = new Employee(2,"Mr","Matt","matt@hotmail.com",
                "password","1234567890","Mayo","Software",skills);
        assertTrue(methods.createAccount(employee));
        //Employer login Test
        Employer currentEmployer = (Employer) methods.login("john@hotmail.com","password");
        assertEquals(employer,currentEmployer);
        //add job - test
        currentEmployer.addJob(new Job("1","Software Engineering","Galway","01/06/2021",skills));
        skills.clear();
        skills.add(DataBase.availableSkills().get(0));
        skills.add(DataBase.availableSkills().get(1));
        skills.add(DataBase.availableSkills().get(5));
        currentEmployer.addJob(new Job("2","Test Engineering","Mayo","01/07/2021",skills));
        assertEquals(2,currentEmployer.getJobList().size());

        assertEquals(employee,methods.login("matt@hotmail.com","password"));



    }
}
