/*******************************
 * Description: Test class to test employer methods
 * Author(s): Ross Monaghan
 * Version: 1.0
 * Date Created: 23/03/21
 *******************************/

package ie.gmit;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class EmployerTest
{
    Employer employer;
    Job job;

    // Initializing a new valid Employer and adding 1 job to their job list
    @BeforeEach
    void init()
    {
        employer = new Employer("001",
                                "Mr",
                                "Ross Monaghan",
                                "employeremail@gmit.ie",
                                "Password123",
                                "0871234567",
                                "Sligo");

        job = new Job("001", "Baker", "Sligo", "23/03/21");
        employer.addJob(job);
    }

    // Testing that a valid Job can be added to an employers job list
    @Test
    void testAddJobSuccess()
    {
        Job jobAdd = new Job("002", "Painter", "Sligo", "23/03/21");
        assertTrue(employer.addJob(jobAdd));
    }

    // Testing that an invalid Job cannot be added to an employers job list
    @Test
    void testAddJobFail()
    {
        Job jobAdd = new Job("001", "Painter", "Sligo", "23/03/21");

        Exception e = assertThrows(IllegalArgumentException.class, () -> employer.addJob(jobAdd));
        assertEquals("Duplicate Job id found, no object added", e.getMessage());
    }

    // Testing that a valid Job can be removed from an employers job list
    @Test
    void testRemoveJobSuccess()
    {
        assertTrue(employer.removeJob("001"));
    }

    // Testing that an invalid Job cannot be removed from an employers job list
    @Test
    void testRemoveJobFail()
    {
        assertFalse(employer.removeJob("002"));
    }
}
