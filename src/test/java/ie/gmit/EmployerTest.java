/*******************************
 * Description: Test class to test employer methods
 * Author(s): Ross Monaghan
 * Version: 1.0
 * Date Created: 23/03/21
 *******************************/

package ie.gmit;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class EmployerTest
{
    ArrayList<Skill> skillsList;
    Employer employer;
    Job job;

    // Initializing a new valid Employer and adding 1 job to their job list
    @BeforeEach
    void init()
    {
        employer = new Employer(1,
                                "Mr",
                                "Ross Monaghan",
                                "employeremail@gmit.ie",
                                "Password123",
                                "0871234567",
                                "Sligo");


        skillsList = new ArrayList<>();
        Skill skillCom = new Skill("Communication", 5);
        skillsList.add(skillCom);

        job = new Job(1, "001", "Baker", "Sligo", "23/03/21", skillsList);
        employer.addJob(job);
    }

    // Testing that a valid Job can be added to an employers job list
    @Test
    void testAddJobSuccess()
    {
        Job jobAdd = new Job(1, "002", "Painter", "Sligo", "23/03/21", skillsList);
        int jobListSize = DataBase.jobs.size();
        employer.addJob(jobAdd);
        assertEquals(jobListSize+1, DataBase.jobs.size());
    }

    // Testing that an invalid Job cannot be added to an employers job list
    @Test
    void testAddJobFail()
    {
        Job jobAdd = new Job(3, "001", "Painter", "Sligo", "23/03/21", skillsList);

        Exception e = assertThrows(IllegalArgumentException.class, () -> employer.addJob(jobAdd));
        assertEquals("Employer IDs do not match, no object added", e.getMessage());
    }

    // Testing that a valid Job can be removed from an employers job list
    @Test
    void testRemoveJobSuccess()
    {
        int jobListSize = DataBase.jobs.size();
        employer.removeJob("001");
        assertEquals(jobListSize-1, DataBase.jobs.size());
    }

    // Testing that an invalid Job cannot be removed from an employers job list
    @Test
    void testRemoveJobFail1()
    {
        Exception e1 = assertThrows(IllegalArgumentException.class, () -> employer.removeJob("003"));
        assertEquals("Error removing job", e1.getMessage());

        Employer employer2 = new Employer(2,
                "Mr",
                "John Monaghan",
                "monaghan@gmit.ie",
                "Password12345",
                "0870303037",
                "Sligo");

        Exception e2 = assertThrows(IllegalArgumentException.class, () -> employer2.removeJob("001"));
        assertEquals("Error removing job", e2.getMessage());
    }
}
