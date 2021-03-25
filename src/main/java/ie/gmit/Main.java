package ie.gmit;

import java.util.ArrayList;
import java.util.Scanner;


public class Main {

    static ArrayList<User> users = new ArrayList<>();
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
                    loggedIn = login(email, password);
                    while (loggedIn) {
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


    static boolean login(String email, String password) {
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getEmail().equalsIgnoreCase(email) && users.get(i).getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }

    boolean registerAsEmployee(String title, String name, String email, String password,
                               String phoneNum, String location, String degree, ArrayList<Skill> skills) {
        Employee employee = new Employee(String.valueOf(userIdCount),
                title, name, email, password, phoneNum, location, degree, skills);
        userIdCount++;
        return users.add(employee);
    }

    static ArrayList<Skill> skills() {
        DataBase dataBase = new DataBase();
        ArrayList availableSkills = dataBase.availableSkills();
        for (int i = 0; i < availableSkills.size(); i++) {
            System.out.print(i + "-" + availableSkills.get(i) + "\t"); // printing all the available skills to the user
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
