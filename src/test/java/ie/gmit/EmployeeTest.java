/*******************************
 * Description: Test class to test employee methods
 * Author(s): Mohamed Otaki
 * Version: 1.0
 * Date Created: 23/03/21
 *******************************/
package ie.gmit;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;


public class EmployeeTest
{
    Employee employee;
    ArrayList<Skill> skills;
    Skill skill;

    @BeforeEach
    void newEmployee()
    {
        employee = new Employee(1,"Mr","mohamed","g00346067@gmit.ie","Password2",
                "0888888888","mayo","Software and Electronic Engineering");
        skills = new ArrayList<>();
        skill = new Skill("Communication Skill",4);
        skills.add(skill);
        employee.setSkills(skills);
    }

    @Test
    void testSetDegreeFalse()
    {
        Exception e = assertThrows(IllegalArgumentException.class,()->employee.setDegree("Error"));
        assertEquals("Degree name should be more than 5 character",e.getMessage());
    }

    @Test
    void testSetDegreeTrue()
    {
        assertEquals("Software and Electronic Engineering",employee.getDegree());
    }

    @Test
    void testAddSkillFalse()
    {
        Skill emptySkill = null;
        Exception e = assertThrows(IllegalArgumentException.class,()->employee.addSkill(emptySkill));
        assertEquals("Can't add empty skill",e.getMessage());
    }

    @Test
    void testAddSkillTrue()
    {
        assertTrue(employee.addSkill(new Skill("Coding",6)));
    }

    @Test
    void testRemoveSkillFalse()
    {
        Exception e;

        e = assertThrows(IllegalArgumentException.class,()->employee.removeSkill(6));
        assertEquals("Skill index is out of range",e.getMessage());

        e = assertThrows(IllegalArgumentException.class,()->employee.removeSkill(-4));
        assertEquals("Skill index is out of range",e.getMessage());

    }

    @Test
    void testRemoveSkillTrue()
    {
        employee.addSkill(new Skill("coding",2));
        assertTrue(employee.removeSkill(1));
    }

    @Test
    void testSetSkillsFalse()
    {
        ArrayList<Skill> emptySkills = new ArrayList<>();
        Exception e = assertThrows(IllegalArgumentException.class,()->employee.setSkills(emptySkills));
        assertEquals("Skills can't be empty",e.getMessage());
    }

    @Test
    void testSetSkillsTrue()
    {
        assertEquals(1,employee.getSkills().size());
    }

}

