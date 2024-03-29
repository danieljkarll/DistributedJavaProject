package springsxml.beans;

import springsxml.Services.LogService;
import java.util.List;

public class Person {
    public Person(){

    }
    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
        logService.log("name- " + name);

    }

    public String getSelfieFileName() {
        return SelfieFileName;
    }

    public void setSelfieFileName(String selfieFileName) {
        SelfieFileName = selfieFileName;
        logService.log("selfieFileName- " + selfieFileName);
    }

    public String getBio() {
        return Bio;
    }

    public void setBio(String bio) {
        Bio = bio;
        logService.log("bio");
    }

    public int getGenderID() {
        return GenderID;
    }

    public void setGenderID(int genderID) {
        GenderID = genderID;
        logService.log("genderID");
    }
    // only a getter for this as its auto generated
    public int getPersonID() {
        return personID;
    }

    public List<Skill> getSkills()
    {
        return skills;
    }

    public void setSkills(List<Skill> skills) {
        this.skills = skills;
        logService.log("skills");

    }

    private LogService logService;

    public void setLogService(LogService logService) {
        // diagnostic message
        this.logService = logService;
    }
    private List<Skill> skills;
    private int personID;
    private String Name;
    private String SelfieFileName;
    private String Bio;
    private int GenderID;
}
