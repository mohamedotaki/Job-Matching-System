/*******************************
 * Description: Test class to test Skill class methods
 * Author(s): Mohamed Otaki
 * Version: 1.0
 * Date Created: 23/03/21
 *******************************/

package ie.gmit;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class SkillTest
{
    Skill skill;

    @BeforeEach
    void newSkill()
    {
        skill = new Skill("Communication Skill",4);
    }

    @Test
    void testSetSkillNameFalse()
    {
        Exception e = assertThrows(IllegalArgumentException.class,()->skill.setSkillName("Error"));
        assertEquals("Skill name should be more than 5",e.getMessage());
    }

    @Test
    void testSetSkillNameTrue()
    {
        assertEquals("Communication Skill",skill.getSkillName());
    }

    @Test
    void testSetSkillLevelFalse()
    {
        Exception e;

        e = assertThrows(IllegalArgumentException.class,()->skill.setSkillLevel(15));
        assertEquals("Skill level should be between 1 and 10",e.getMessage());

        e = assertThrows(IllegalArgumentException.class,()->skill.setSkillLevel(-5));
        assertEquals("Skill level should be between 1 and 10",e.getMessage());
    }

    @Test
    void testSetSkillLevelTrue()
    {
        assertEquals(4,skill.getSkillLevel());
    }

}
