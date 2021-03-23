package ie.gmit;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class SkillTest {
    Skill skill;

    @BeforeEach
    void newSkill(){
        skill = new Skill("Communication Skill",4);
    }

    @Test
    void testSetSkillNameFalse(){
        assertThrows(IllegalArgumentException.class,()->skill.setSkillName("Error"));
    }
    @Test
    void testSetSkillNameTrue(){
        assertEquals("Communication Skill",skill.getSkillName());
    }
    @Test
    void testSetSkillLevelFalse(){
        assertThrows(IllegalArgumentException.class,()->skill.setSkillLevel(15));
        assertThrows(IllegalArgumentException.class,()->skill.setSkillLevel(-5));
    }
    @Test
    void testSetSkillLevelTrue(){
        assertEquals(4,skill.getSkillLevel());
    }

}
