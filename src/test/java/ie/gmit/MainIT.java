package ie.gmit;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainIT {

    Job job;
    Skill skill;

    @BeforeEach
    void init()
    {
        job = new Job("001", "Baker", "Sligo", "23/03/21");
        skill = new Skill("Java Programming", 10);
        job.addSkill(skill);
    }

    // Tests for Job ID success and failure
    @Test
    void MainIT()
    {
        assertEquals("001", job.getJobId());
    }
}
