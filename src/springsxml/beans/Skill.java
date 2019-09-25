package springsxml.beans;

public class Skill {
    public int getSkillID() {
        return SkillID;
    }


    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public double getLevel() {
        return Level;
    }

    public void setLevel(double level) {
        Level = level;
    }
    private int SkillID;
    private String Name;
    private double Level;
}
