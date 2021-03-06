 /******************************
 * Description: Class to represent a job posting and its details
 * Author(s): Ricky Small
 * Version: 1.0
 * Date Created: 18/03/21
 ******************************/

package ie.gmit;

import java.util.Objects;

public class User
{

	private int id;
	private String title;
	private String name;
	private String email;
	private String password;
	private String phoneNum;
	private String location;

	// User constructor with arguments
	public User(int id, String title, String name, String email, String password, String phoneNum, String location)
	{
		setId(id);
		setTitle(title);
		setName(name);
		setEmail(email);
		setPassword(password);
		setPhoneNum(phoneNum);
		setLocation(location);
	}


	public int getId()
	{
		return id;
	}

	//Checking the ID is valid before using
	public void setId(int id)
	{
		if(id > 0) {
			this.id = id;
		}
		else {
			throw new IllegalArgumentException("Invalid ID");
		}
	}

	public String getTitle()
	{
		return title;
	}

	//Checking the Title is valid before using
	public void setTitle(String title)
	{
		if(title.equals("Mr") || title.equals("Mrs") || title.equals("Miss") ) {
			this.title = title;
		}
		else {
			throw new IllegalArgumentException("Invalid Title Error - Please choose Mr, Mrs or Miss");
		}
	}

	public String getName()
	{
		return name;
	}

	//Checking the Name is valid before using
	public void setName(String name)
	{
		if(name.length() >= 5 &&  name.length() <= 22) {
			this.name = name;
		}
		else {
			throw new IllegalArgumentException("Invalid Name Error - Name must have more than 5 letters and a maximum of 22");
		}
	}

	public String getEmail()
	{
		return email;
	}

	//Checking the Email is valid before using
	public void setEmail(String email)
	{
		if(email.length() > 0) {
			this.email = email;
		}
		else {
			throw new IllegalArgumentException("Invalid Email Error");
		}
	}

	public String getPassword()
	{
		return password;
	}

	//Checking the Password is valid before using
	public void setPassword(String password)
	{
		if (password.length() > 8 && !password.equals(name)) {
			this.password = password;
		}
		else {
			String error = "";
			if (password.length() < 8) {
				error = "Invalid Password Error - Must be at least 8 characters";
			}
			if (Objects.equals(password, name)) {
				error = "Invalid Password Error - Must not match name";
			}
			throw new IllegalArgumentException(error);
		}
	}

	public String getPhoneNum()
	{
		return phoneNum;
	}

	//Checking the Phone number is valid before using
	public void setPhoneNum(String phoneNum)
	{
		if(phoneNum.length() == 10 ) {
			this.phoneNum = phoneNum;
		}
		else {
			throw new IllegalArgumentException("Invalid Phone Number Error - Phone must be 10 digits");
		}
	}

	public String getLocation()
	{
		return location;
	}

	//Checking the Location is valid before using
	public void setLocation(String location)
	{
		if (location.length() > 2) {
			this.location = location;
		}
		else {
			throw new IllegalArgumentException("Invalid location");
		}
	}
}
