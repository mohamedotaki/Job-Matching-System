package ie.gmit;

import java.util.ArrayList;
import java.util.Scanner;


public class Main {
    static DataBase dataBase = new DataBase();
    static ArrayList<User> users;
    int userIdCount = users.size() + 1;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        boolean loggedIn = false;
        while (true) {
            System.out.println("Please enter 1 to login or 2 to register");
            String dataIn = scanner.nextLine();
            while (!dataIn.contains("1") && !dataIn.contains("2")) {
                dataIn = scanner.nextLine();
            }
            switch (dataIn) {
                case "1":
                    System.out.println("Email:");
                    String email = scanner.nextLine();
                    System.out.println("Password:");
                    String password = scanner.nextLine();
                    User currentUser = login(email, password);
                    if(currentUser != null) {
                        loggedIn = true;
                    }
                    while (loggedIn) {
                        if(currentUser instanceof Employer)
                        System.out.println("1-Show matched jobs\n2-Show all available jobs\n" +
                                "3-Logout");
                        switch (scanner.nextLine()) {
                            case "1":
                                break;
                            case "2":
                                break;
                            case "3":
                                loggedIn = false;
                                break;
                        }

                    }

                    break;
                case "2":
                    skills();
                    break;
            }


        }
    }


    static User login(String email, String password) {
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getEmail().equalsIgnoreCase(email) && users.get(i).getPassword().equals(password)) {
                return users.get(i);
            }
        }
        throw new IllegalArgumentException("ss");
    }

    boolean registerAsEmployee(String title, String name, String email, String password,
                               String phoneNum, String location, String degree, ArrayList<Skill> skills) {
        Employee employee = new Employee(String.valueOf(userIdCount),
                title, name, email, password, phoneNum, location, degree, skills);
        userIdCount++;
        return users.add(employee);
    }

    //Printing available skills from database
    static ArrayList<Skill> skills()
    {

        ArrayList availableSkills = dataBase.availableSkills();
        for (int i = 0; i < availableSkills.size(); i++) {
            System.out.print(i + "-" + availableSkills.get(i) + "\t");
        }
        return null;
    }

    void getUserType() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter 1 for company login or 2 for user login:");
        switch (scanner.nextLine()) {
            case "1":
                System.out.println("company");
                break;
            case "2":
                System.out.println("User");
                break;
            default:
                System.out.println("Please enter 1 or 2");
                break;
        }
    }
}
