package ie.gmit;

import com.sun.istack.internal.NotNull;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AppIT {
    DataBase dataBase = new DataBase();
    Methods methods= new Methods();
    @Test
    void AppIT(){
        // new employer account test
        Employer employer = new Employer(1,"Mr","John","john@hotmail.com",
                "password","1234567890","Galway");
        assertTrue(methods.createAccount(employer));
        // new employee account test
        Employee employee = new Employee(2,"Mr","Matt","matt@hotmail.com",
                "password","1234567890","Mayo","Software");
        assertTrue(methods.createAccount(employee));
        //Employer login Test
        Employer currentEmployer = (Employer) methods.login("john@hotmail.com","password");
        assertEquals(employer,currentEmployer);
        //add job - test
        ArrayList<Skill> skills =new ArrayList<>();
        skills.add(dataBase.availableSkills().get(8));
        skills.add(dataBase.availableSkills().get(7));
        currentEmployer.addJob(new Job("1","Software Engineering","Galway","01/06/2021",skills));
        skills.clear();
        skills.add(dataBase.availableSkills().get(0));
        skills.add(dataBase.availableSkills().get(1));
        skills.add(dataBase.availableSkills().get(5));
        currentEmployer.addJob(new Job("2","Test Engineering","Mayo","01/07/2021",skills));
        assertEquals(2,currentEmployer.getJobList().size());

        assertEquals(employee,methods.login("matt@hotmail.com","password"));



    }
}
