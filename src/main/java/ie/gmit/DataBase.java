package ie.gmit;

import java.util.ArrayList;

public class DataBase
{

    private ArrayList<Employee> employeeDatabase = new ArrayList<>();

    // Method to return the available skills a user can choose from
    public ArrayList<String> availableSkills()
    {
        ArrayList<String> availableSkills = new ArrayList<>();
        availableSkills.add("Communication");
        availableSkills.add("Computer");
        availableSkills.add("People");
        availableSkills.add("Leadership");
        availableSkills.add("Organizational");
        availableSkills.add("Time management");
        availableSkills.add("Collaboration");
        availableSkills.add("Problem-solving");
        availableSkills.add("Coding");
        return availableSkills;
    }

    // Method to add an employee to the employee database
    public boolean addEmployee(Employee employeeAdd)
    {
        for(Employee employeeExisting : employeeDatabase) {
            if (employeeExisting.getId() == employeeAdd.getId()) {
                throw new IllegalArgumentException("Duplicate Employee ID found, no object added");
            }
        }
        employeeDatabase.add(employeeAdd);
        return true;
    }

    // Method to remove an Employee from the employee database
    public Boolean removeJob(int employeeId)
    {
        for(Employee employeeRemove : employeeDatabase) {
            if (employeeRemove.getId() == employeeId) {
                employeeDatabase.remove(employeeRemove);
                return true;
            }
        }
        return false;
    }

    // Method to initialize the employee database
    public boolean initializeEmployees()
    {
        Skill skill = new Skill("Java", 5);
        ArrayList<Skill> skills = new ArrayList<>();
        skills.add(skill);

        Employee employee1 = new Employee(
                            1 , "Mr","mohamed","g00346067@gmit.ie","Password2",
                            "0888888888","mayo","Software and Electronic Engineering", skills );

        employeeDatabase.add(employee1);
        return true;
    }
}
