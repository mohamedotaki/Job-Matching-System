/*******************************
 * Description: Test class to test job methods
 * Author(s): Ross Monaghan
 * Version: 1.0
 * Date Created: 23/03/21
 *******************************/

package ie.gmit;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class JobTest
{
    Job job;
    ArrayList<Skill> skillsList;

    // Initializing a new valid Employer and adding 1 job to their job list
    @BeforeEach
    void init()
    {
        skillsList = new ArrayList<>();
        Skill skillCom = new Skill("Communication", 5);
        skillsList.add(skillCom);

        job = new Job(1, "001", "Baker", "Sligo", "23/03/21", skillsList);
        job.addMatch(1, 60);
    }

    // Tests for Employer ID success and failure
    @Test
    void testEmployerIdSuccess()
    {
        assertEquals(1, job.getEmployerID());
    }

    @Test
    void testEmployerIdFailure()
    {
        Exception e = assertThrows(IllegalArgumentException.class, () -> new Job(0,
                                                                                "001",
                                                                                "Baker",
                                                                                "Sligo",
                                                                                "23/03/21",
                                                                                skillsList));

        assertEquals("Invalid Employer ID", e.getMessage());
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
        Exception e = assertThrows(IllegalArgumentException.class, () -> new Job(1,
                                                                                    "",
                                                                                "Baker",
                                                                                "Sligo",
                                                                                "23/03/21",
                                                                                        skillsList));
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
        Exception e = assertThrows(IllegalArgumentException.class, () -> new Job(1,
                                                                                "001",
                                                                                "",
                                                                                "Sligo",
                                                                                "23/03/21",
                                                                                skillsList));
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
        Exception e = assertThrows(IllegalArgumentException.class, () -> new Job(1,
                                                                                "001",
                                                                                "Baker",
                                                                                "",
                                                                                "23/03/21",
                                                                                  skillsList));
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
        Exception e = assertThrows(IllegalArgumentException.class, () -> new Job(1,
                                                                                "001",
                                                                                "Baker",
                                                                                "Sligo",
                                                                                "",
                                                                                        skillsList));

        assertEquals("Closing date must be in format dd/mm/yy", e.getMessage());
    }

    // Tests for Job Set Skills success and failure
    @Test
    void testSetSkillsSuccess()
    {
        ArrayList<Skill> skillsListGood = job.getSkillList();
        assertEquals("Communication", skillsListGood.get(0).getSkillName());
    }

    @Test
    void testSetSkillsFail()
    {

        ArrayList<Skill> skillsListBad = new ArrayList<>();

        Exception e = assertThrows(IllegalArgumentException.class, () -> new Job(1,
                                                                                "001",
                                                                                "Baker",
                                                                                "Sligo",
                                                                                "23/03/21",
                                                                                skillsListBad));

        assertEquals("Skill list must have at least one skill", e.getMessage());
    }

    // Tests for matchList add success and failure
    @Test
    void testAddMatchSuccess()
    {
        int listSize = job.getMatchList().size();
        job.addMatch(2, 60);
        assertEquals(listSize+1, job.getMatchList().size());
    }

    @Test
    void testAddMatchFailure()
    {
        Exception e = assertThrows(IllegalArgumentException.class, () -> job.addMatch(1, 60));
        assertEquals("Employee ID already present, ID not added", e.getMessage());
    }

    // Tests for clearMatches success
    @Test
    void testClearMatchesSuccess()
    {
        job.clearMatches();
        assertEquals(0, job.getMatchList().size());
    }
}
