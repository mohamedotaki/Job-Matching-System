package ie.gmit;

public class Skill {
    private String skillName;
    private int skillLevel;

    public Skill(String skillName, int skillLevel) {
        setSkillName(skillName);
        setSkillLevel(skillLevel);
    }

    public String getSkillName() {
        return skillName;
    }

    public void setSkillName(String skillName) {
        if(skillName.length()<=5){
            throw new IllegalArgumentException("Skill name should be more than 5");
        }else {
            this.skillName = skillName;
        }
    }

    public int getSkillLevel() {
        return skillLevel;
    }

    public void setSkillLevel(int skillLevel) {
        if(skillLevel>10 || skillLevel<1){
            throw new IllegalArgumentException("Skill level should be between 1 and 10");
        }
        this.skillLevel = skillLevel;
    }
}
