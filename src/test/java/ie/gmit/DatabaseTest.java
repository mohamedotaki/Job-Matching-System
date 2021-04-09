/*******************************
 * Description: Test class to test all the Database operation
 * Author(s): Mohamed Otaki, Ricky Small
 * Version: 1.0
 * Date Created: 07/04/21
 *******************************/

package ie.gmit;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class DatabaseTest
{
    static User user;

    @Test
    void testAvailableSkillsDatabase()
    {
        ArrayList<String> availableSkillsdb = new ArrayList<>();
        availableSkillsdb.add("Communication");
        availableSkillsdb.add("Computer");
        availableSkillsdb.add("People");
        availableSkillsdb.add("Leadership");
        availableSkillsdb.add("Organizational");
        availableSkillsdb.add("Time management");
        availableSkillsdb.add("Collaboration");
        availableSkillsdb.add("Problem-solving");
        availableSkillsdb.add("Coding");

        boolean isEqual = DataBase.getAvailableSkills().equals(availableSkillsdb);
        assertTrue(isEqual);
    }

    @Test
    void testAddUserTrue()
    {
        user = new User(1, "Mr", "Mohamed",
                "g00346067@gmit.ie", "password12",
                "0089212121","Mayo");
        assertTrue(DataBase.addUser(user));
    }

    @Test
    void testAddUserFalse()
    {
        User duplicatedUser = new User(2, "Mr", "duplicatedUser",
                "g00346067@gmit.ie", "password12",
                "0089212121","Mayo");
        DataBase.addUser(duplicatedUser);
        assertThrows(IllegalArgumentException.class,()-> DataBase.addUser(duplicatedUser));

        User emptyUser = null;
        assertThrows(IllegalArgumentException.class,()-> DataBase.addUser(emptyUser));
    }

    @Test
    void testLoginTrue()
    {
        assertEquals(user, DataBase.login("g00346067@gmit.ie", "password12"));
    }

    @Test
    void testLoginFalse()
    {
        assertThrows(IllegalArgumentException.class,()-> DataBase.login("g00346067@gmit.ie", "wrongPassword"));
        assertThrows(IllegalArgumentException.class,()-> DataBase.login("wrongEmail@gmit.ie", "password12"));
    }

    @Test
    void testUpdateUserTrue()
    {
        user.setLocation("Galway");
        user.setName("Mohamed Otaki");
        assertTrue(DataBase.updateUser(user));
    }

    @Test
    void testUpdateUserFalse()
    {
        user.setId(6);
        user.setName("Mohamed Otaki");
        assertThrows(IllegalArgumentException.class,()->DataBase.updateUser(user));
    }

    @Test
    void testDeleteUserTrue()
    {
        assertTrue(DataBase.deleteUser(user));
    }

    @Test
    void testDeleteUserFalse()
    {
        User emptyUser = null;
        assertThrows(IllegalArgumentException.class,()->DataBase.deleteUser(emptyUser));
    }


    @Test
    void testupdateMatchesPass()
    {

    }

}
