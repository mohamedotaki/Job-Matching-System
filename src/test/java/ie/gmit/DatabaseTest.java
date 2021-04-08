package ie.gmit;


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class DatabaseTest
{
    static User user;

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

        User emptyUser = null;
        assertThrows(IllegalArgumentException.class,()-> DataBase.addUser(emptyUser));
//        User duplicatedUser = new User(1, "Mr", "Mohamed",
//                "g00346067@gmit.ie", "password12",
//                "0089212121","Mayo");
//        assertThrows(IllegalArgumentException.class,()-> DataBase.addUser(duplicatedUser));
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
    void getAvailableSkills()
    {

    }

}
