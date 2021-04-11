/*******************************
 * Description: Test class to test all the Database operation
 * Author(s): Mohamed Otaki, Ricky Small
 * Version: 1.0
 * Date Created: 07/04/21
 *******************************/

package ie.gmit;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class DatabaseTest
{
    static User userTrue, userFalse;
    static Job jobOne, jobTwo, jobDup;

    Skill skillCom5;
    Skill skillCom6;
    Skill skillComp;
    Skill skillPeople5;
    Skill skillPeople6;
    Skill skillLead;
    ArrayList<Skill> reqSkills1;
    ArrayList<Skill> reqSkills2;
    ArrayList<Skill> reqSkills3;
    ArrayList<Skill> employeeSkills;
    @BeforeEach
    void init()
    {
        skillCom5 = new Skill(DataBase.getAvailableSkills().get(0), 5);
        skillCom6 = new Skill(DataBase.getAvailableSkills().get(0), 6);
        skillComp = new Skill(DataBase.getAvailableSkills().get(1), 5);
        skillPeople5 = new Skill(DataBase.getAvailableSkills().get(2), 5);
        skillPeople6 = new Skill(DataBase.getAvailableSkills().get(2), 6);
        skillLead = new Skill(DataBase.getAvailableSkills().get(3), 5);
        reqSkills1 = new ArrayList<>();
        reqSkills1.add(skillCom5);
        reqSkills1.add(skillComp);
        reqSkills1.add(skillPeople5);
        reqSkills1.add(skillLead);
        reqSkills2 = new ArrayList<>();
        reqSkills2.add(skillCom5);
        reqSkills2.add(skillComp);
        reqSkills2.add(skillPeople5);
        reqSkills3 = new ArrayList<>();
        reqSkills3.add(skillCom6);
        reqSkills3.add(skillPeople6);
        employeeSkills = new ArrayList<>();
        employeeSkills.add(skillCom5);
        employeeSkills.add(skillComp);
    }

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

    //Test to check if the job adds correctly to the database, passes with unique id
    @Test
    void testAddJobPass()
    {
        jobOne = new Job(1,"001", "AddJobPass", "IntelliJ", "12/12/21", employeeSkills);
        DataBase.addJob(jobOne);
        int jobListSize = DataBase.getJobs().size();
        jobTwo = new Job(1,"002", "AddJobPass", "IntelliJ", "12/12/21", employeeSkills);
        DataBase.addJob(jobTwo);
        assertEquals(jobListSize+1, DataBase.getJobs().size());
    }

    //Test to check if the job is empty that the user is informed correctly
    @Test
    void testAddJobFail()
    {
        Exception e = assertThrows(IllegalArgumentException.class,()->DataBase.addJob(null));
        assertEquals("Cannot add empty Job in database",e.getMessage());
    }

    //Test to check if the add Job method fails with a duplicate entry.
    @Test
    void testAddJobDuplicate()
    {
        jobDup = new Job(2,"001", "AddJobPass", "IntelliJ", "12/12/21", employeeSkills);
        Exception e = assertThrows(IllegalArgumentException.class,()->DataBase.addJob(jobDup));
        assertEquals("Job already in database",e.getMessage());
    }

    //Remove job is a success if the jobList count is increased by one after adding one job.
    @Test
    void testRemoveJobSuccess()
    {
        int jobListCount = DataBase.getJobs().size();
        DataBase.removeJob(jobTwo);
        assertEquals(jobListCount-1, DataBase.getJobs().size());
    }

    //Remove job is a fail if ID does not match any in the Database
    @Test
    void testRemoveJobWrongID()
    {
        Job jobRemove = new Job(1,"0", "AddJobPass", "IntelliJ", "12/12/21", employeeSkills);
        Exception e = assertThrows(IllegalArgumentException.class,()->DataBase.removeJob(jobRemove));
        assertEquals("Please check Job ID",e.getMessage());
    }

    //Remove job informs user to enter an ID if entry is empty
    @Test
    void testRemoveJobNull()
    {
        Exception e = assertThrows(IllegalArgumentException.class,()->DataBase.removeJob(null));
        assertEquals("Enter ID to Remove Job",e.getMessage());
    }

    @Test
    void testUpdateMatches()
    {
        // Adding jobs to database
        Job job1 = new Job(1, "010", "Baker", "Sligo", "23/03/21", reqSkills1);
        Job job2 = new Job(2, "011", "Developer", "Sligo", "23/03/21", reqSkills2);
        Job job3 = new Job(3, "012", "Developer", "Sligo", "23/03/21", reqSkills3);
        DataBase.addJob(job1);
        DataBase.addJob(job2);
        DataBase.addJob(job3);

        // Adding an employee to the database
        Employee employee = new Employee(11,
                "Mr",
                "Jackie Chan",
                "jchan@gmail.com",
                "Password1234",
                "0987654321",
                "Sligo",
                "Electronic and Software Engineering");
        employee.setSkills(employeeSkills);
        DataBase.addUser(employee);
        DataBase.updateMatches();
        assertEquals(0, job1.getMatchList().size());
        assertEquals(1, job2.getMatchList().size());
        assertEquals(0, job3.getMatchList().size());
    }

}
