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
    static User userTrue, userFalse;

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

    //Testing and adding 2 users to the database one for true test one for false
    @Test
    void testAddUserTrue()
    {
        userTrue = new User(1, "Mr", "Mohamed",
                "g00346067@gmit.ie", "password12",
                "0089212121","Mayo");
        assertTrue(DataBase.addUser(userTrue));

        userFalse = new User(2, "Mr", "duplicatedUser",
                "g00346067@gmit.ie", "password12",
                "0089212121","Mayo");
        assertTrue(DataBase.addUser(userFalse));
    }

    //Testing if null user or duplicated user added to database
    @Test
    void testAddUserFalse()
    {
        Exception e;
         e = assertThrows(IllegalArgumentException.class, ()-> DataBase.addUser(userFalse));
        assertEquals("User ID already in database", e.getMessage());

        User emptyUser = null;
        e = assertThrows(IllegalArgumentException.class, ()-> DataBase.addUser(emptyUser));
        assertEquals("Can't add empty user", e.getMessage());
    }

    @Test
    void testLoginTrue()
    {
        assertEquals(userTrue, DataBase.login("g00346067@gmit.ie", "password12"));
    }

    @Test
    void testLoginFalse()
    {
        Exception e;

        e = assertThrows(IllegalArgumentException.class,()-> DataBase.login("g00346067@gmit.ie", "wrongPassword"));
        assertEquals("Wrong email or password",e.getMessage());

        e = assertThrows(IllegalArgumentException.class,()-> DataBase.login("wrongEmail@gmit.ie", "password12"));
        assertEquals("Wrong email or password",e.getMessage());
    }

    @Test
    void testUpdateUserTrue()
    {
        userTrue.setLocation("Galway");
        userTrue.setName("Mohamed Otaki");
        assertTrue(DataBase.updateUser(userTrue));
    }

    @Test
    void testUpdateUserFalse()
    {
        User userNotInDatabase = new User(5, "Mr", "userNotInDatabase",
                "g00346067@gmit.ie", "password12",
                "0089212121","Mayo");
        Exception e = assertThrows(IllegalArgumentException.class,()->DataBase.updateUser(userNotInDatabase));
        assertEquals("User ID was not found in database",e.getMessage());
    }

    @Test
    void testDeleteUserTrue()
    {
        assertTrue(DataBase.deleteUser(userTrue));
    }

    @Test
    void testDeleteUserFalse()
    {
        User emptyUser = null;
        Exception e = assertThrows(IllegalArgumentException.class,()->DataBase.deleteUser(emptyUser));
        assertEquals("User was not found in database",e.getMessage());
    }


}
