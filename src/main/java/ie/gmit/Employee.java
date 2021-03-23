package ie.gmit;

import java.util.ArrayList;

public class Employee {
    private String degree;
    private ArrayList<Skill> skills;

    public Employee(String degree, ArrayList<Skill> skills) {
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
