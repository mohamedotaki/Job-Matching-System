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


import static jdk.nashorn.internal.objects.Global.println;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


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


    void newEmployeeNoSkills(){
        employee = new Employee(1,"Mr","mohamed","g00346067@gmit.ie","Password2",
                "0888888888","mayo","Software and Electronic Engineering Year1");

    }

    @Test
    void testAddSkillTrue() {
        skill = new Skill("Organizational Skill",5);
        skills.add(skill);
        employee.setSkills(skills);
        assertEquals(2,employee.getSkills().size());

    }
//    @Test
//    void testAddSkillFalse() {
//        skill = null;
//        assertThrows(IllegalArgumentException.class,);
//    }

    @Test
    void testRemoveSkillTrue() { }
    @Test
    void testremoveSkillFalse() { }


    @Test
    void testSetDegreeFalse(){
        assertThrows(IllegalArgumentException.class,()->employee.setDegree("Error"));
    }

    @Test
    void testSetDegreeTrue()
    {
        assertEquals("Software and Electronic Engineering",employee.getDegree());
    }

    @Test
    void testSetSkillsFalse()
    {
        ArrayList<Skill> emptySkills = new ArrayList<>();
        assertThrows(IllegalArgumentException.class,()->employee.setSkills(emptySkills));
    }

    @Test
    void testSetSkillsTrue()
    {
        assertEquals(1,employee.getSkills().size());
    }

    @Test
    void testAddSkillFalse()
    {
        Skill emptySkill = null;
        assertThrows(IllegalArgumentException.class,()->employee.addSkill(emptySkill));
    }

    @Test
    void testAddSkillTrue()
    {
        assertTrue(employee.addSkill(new Skill("Coding",6)));
    }

    @Test
    void testRemoveSkillFalse()
    {
        assertThrows(IllegalArgumentException.class,()->employee.removeSkill(6));
        assertThrows(IllegalArgumentException.class,()->employee.removeSkill(-4));
    }

    @Test
    void testRemoveSkillTrue()
    {
        employee.addSkill(new Skill("coding",2));
        assertTrue(employee.removeSkill(1));
    }

}

