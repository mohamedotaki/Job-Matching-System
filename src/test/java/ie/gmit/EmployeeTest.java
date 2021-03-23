package ie.gmit;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class EmployeeTest {
    Employee employee;
    ArrayList<Skill> skills;
    Skill skill;
    @BeforeEach
    void newEmployee(){
        skills = new ArrayList<>();
        skill = new Skill("Communication Skill",4);
        skills.add(skill);
        employee = new Employee("Software and Electronic Engineering",skills);
    }

    @Test
    void testSetDegreeFalse(){
        assertThrows(IllegalArgumentException.class,()->employee.setDegree("Error"));
    }
    @Test
    void testSetDegreeTrue(){
        assertEquals("Software and Electronic Engineering",employee.getDegree());
    }
    @Test
    void testSetSkillsFalse(){
        ArrayList<Skill> emptySkills = new ArrayList<>();
        assertThrows(IllegalArgumentException.class,()->employee.setSkills(emptySkills));
    }
    @Test
    void testSetSkillsTrue(){
        assertEquals(1,employee.getSkills().size());
    }

}

