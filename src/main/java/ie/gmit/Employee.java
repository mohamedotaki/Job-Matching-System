package ie.gmit;

import java.util.ArrayList;

public class Employee extends User{
    private String degree;
    private ArrayList<Skill> skills;


    public Employee(int id, String title, String name, String email, String password, String phoneNum, String location, String degree, ArrayList<Skill> skills) {
        super(id, title, name, email, password, phoneNum, location);
        setDegree(degree);
        setSkills(skills);
    }


    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        if(degree.length()<=5){
            throw new IllegalArgumentException("Degree name should be more than 5 character");
        }else{
            this.degree = degree;
        }

    }

    public ArrayList<Skill> getSkills() {
        return skills;
    }

    public void setSkills(ArrayList<Skill> skills) {
        if(skills.isEmpty()){
            throw new IllegalArgumentException("Skills can't be empty");
        }else{
            this.skills = skills;
        }
    }
}
