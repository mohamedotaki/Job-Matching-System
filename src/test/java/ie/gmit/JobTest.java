/*******************************
 * Description: Test class to test job methods
 * Author(s): Ross Monaghan
 * Version: 1.0
 * Date Created: 23/03/21
 *******************************/

package ie.gmit;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class JobTest
{
    Job job;
    Skill skill;

    // Initializing a new valid Employer and adding 1 job to their job list
    @BeforeEach
    void init()
    {
        job = new Job("001", "Baker", "Sligo", "23/03/21");
        skill = new Skill("Java Programming", 10);
        job.addSkill(skill);
    }

    // Tests for Job ID success and failure
    @Test
    void testJobIdSuccess()
    {
        assertEquals("001", job.getJobId());
    }

    @Test
    void testJobIdFail()
    {
        Exception e = assertThrows(IllegalArgumentException.class, () -> new Job("",
                                                                                "Baker",
                                                                                "Sligo",
                                                                                "23/03/21"));
        assertEquals("Invalid Job ID", e.getMessage());
    }

    // Tests for Job Title success and failure
    @Test
    void testJobTitleSuccess()
    {
        assertEquals("Baker", job.getJobTitle());
    }

    @Test
    void testJobTitleFail()
    {
        Exception e = assertThrows(IllegalArgumentException.class, () -> new Job("001",
                                                                                "",
                                                                                "Sligo",
                                                                                "23/03/21"));
        assertEquals("Invalid Job Title", e.getMessage());
    }

    // Tests for Job Location success and failure
    @Test
    void testJobLocationSuccess()
    {
        assertEquals("Sligo", job.getLocation());
    }

    @Test
    void testJobLocationFail()
    {
        Exception e = assertThrows(IllegalArgumentException.class, () -> new Job("001",
                                                                                "Baker",
                                                                                "",
                                                                                "23/03/21"));
        assertEquals("Invalid Location", e.getMessage());
    }

    // Tests for Job Closing Date success and failure
    @Test
    void testJobClosingDateSuccess()
    {
        assertEquals("23/03/21", job.getClosingDate());
    }

    @Test
    void testJobClosingDateFail()
    {
        Exception e = assertThrows(IllegalArgumentException.class, () -> new Job("001",
                                                                                "Baker",
                                                                                "Sligo",
                                                                                ""));
        assertEquals("Invalid Closing Date", e.getMessage());
    }

    // Testing that a valid Skill can be added to a Jobs list of required skills
    @Test
    void testAddSkillSuccess()
    {
        Skill skillAdd = new Skill("Python Programming", 5);
        assertTrue(job.addSkill(skillAdd));
    }

    // Testing that an invalid Skill cannot be added to a Jobs list of required skills
    @Test
    void testAddSkillFail()
    {
        Skill skillAdd = new Skill("Java Programming", 5);

        Exception e = assertThrows(IllegalArgumentException.class, () -> job.addSkill(skillAdd));
        assertEquals("Duplicate Skill found, no object added", e.getMessage());
    }

    // Testing that a valid Skill can be removed from a Jobs skill list
    @Test
    void testRemoveSkillSuccess()
    {
        assertTrue(job.removeSkill("Java Programming"));
    }

    // Testing that an invalid Skill cannot be removed from a Jobs skill list
    @Test
    void testRemoveJobFail()
    {
        assertFalse(job.removeSkill("C++ Programming"));
    }
}
