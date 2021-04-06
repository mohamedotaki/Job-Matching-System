/*******************************
 * Description: Test class to test User methods
 * Author(s): Ricky Small
 * Version: 1.0
 * Date Created: 18/03/21
 *******************************/

package ie.gmit;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class UserTest
{

	User user;

	// Initializing a new User before each test runs
	@BeforeEach
	void init()
	{
		user = new User(1,"Mr","Ricky Small","ricky@gmit.ie", "123456789", "0878080028", "Sligo");
	}

	//Checking the User ID Passes and Fails correctly
	@Test
	void testUserIdPass()
	{
		assertEquals(1, user.getId());
	}

	@Test
	void testUserIdFail()
	{
		Exception e = assertThrows(IllegalArgumentException.class, () -> new User(0, "Mr", "Ricky Small", "ricky@gmit.ie", "123456789", "0878080028","Sligo" ));
		assertEquals("Invalid ID", e.getMessage());
	}


	//Checking the Title Passes with all options and Fails correctly
	@Test
	void testUserTitlePassMr()
	{
		assertEquals("Mr", user.getTitle());
	}

	@Test
	void testUserTitlePassMrs()
	{
		user.setTitle("Mrs");
		assertEquals("Mrs", user.getTitle());
	}

	@Test
	void testUserTitlePassMiss()
	{
		user.setTitle("Miss");
		assertEquals("Miss", user.getTitle());
	}

	@Test
	void testUserTitleFail()
	{
		Exception e = assertThrows(IllegalArgumentException.class, () -> new User(2, "", "Ricky Small", "ricky@gmit.ie", "123456789", "0878080028","Sligo"));
		assertEquals("Invalid Title Error - Please choose Mr, Mrs or Miss", e.getMessage());
	}

	//Checking the User Name Passes and Fails correctly under all possibilities
	@Test
	void testUserNamePass()
	{
		assertEquals("Ricky Small", user.getName());
	}

	@Test
	void testUserNameFailUnder5()
	{
		Exception e = assertThrows(IllegalArgumentException.class, () -> new User(2, "Mr", "Rick", "ricky@gmit.ie", "123456789", "0878080028","Sligo"));
		assertEquals("Invalid Name Error - Name must have more than 5 letters and a maximum of 22", e.getMessage());
	}

	@Test
	void testUserNameFailOver22()
	{
		Exception e = assertThrows(IllegalArgumentException.class, () -> new User(2, "Mr", "RickyRossMohRickyRossMoh", "ricky@gmit.ie", "123456789", "0878080028","Sligo"));
		assertEquals("Invalid Name Error - Name must have more than 5 letters and a maximum of 22", e.getMessage());
	}

	//Checking the User Email Passes and Fails correctly
	@Test
	void testUserEmailPass()
	{
		assertEquals("ricky@gmit.ie", user.getEmail());
	}

	@Test
	void testUserEmailFail()
	{
		Exception e = assertThrows(IllegalArgumentException.class, () -> new User(2, "Mr", "Ricky Small", "", "123456789", "0878080028","Sligo"));
		assertEquals("Invalid Email Error", e.getMessage());
	}

	//Checking the User Password Passes and Fails correctly under all possibilities
	@Test
	void testUserPasswordPass()
	{
		assertEquals("123456789", user.getPassword());
	}

	@Test
	void testUserPasswordFailUnder8()
	{
		Exception e = assertThrows(IllegalArgumentException.class, () -> new User(2, "Mr", "Ricky Small", "ricky@gmit.ie", "1234567", "0878080028","Sligo"));
		assertEquals("Invalid Password Error - Must be at least 8 characters", e.getMessage());
	}

	@Test
	void testUserPasswordFailName()
	{
		Exception e = assertThrows(IllegalArgumentException.class, () -> new User(2, "Mr", "Ricky Small", "ricky@gmit.ie", "Ricky Small", "0878080028","Sligo"));
		assertEquals("Invalid Password Error - Must not match name", e.getMessage());
	}

	//Checking the User Phone Passes and Fails correctly
	@Test
	void testUserPhonePass()
	{
		assertEquals("0878080028", user.getPhoneNum());
	}

	@Test
	void testUserPhoneFail()
	{
		Exception e = assertThrows(IllegalArgumentException.class, () -> new User(2, "Mr", "Ricky Small", "ricky@gmit.ie", "123456789", "087808002","Sligo"));
		assertEquals("Invalid Phone Number Error - Phone must be 10 digits", e.getMessage());
	}

	//Checking the User Location Passes and Fails correctly
	@Test
	void testUserLocationPass()
	{
		assertEquals("Sligo", user.getLocation());
	}

	@Test
	void testUserLocationFail()
	{
		Exception e = assertThrows(IllegalArgumentException.class, () -> new User(2, "Mr", "Ricky Small", "ricky@gmit.ie", "123456789", "0878080028",""));
		assertEquals("Invalid location", e.getMessage());
	}
}
