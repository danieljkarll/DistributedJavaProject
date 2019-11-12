package hibernate.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="person_id")
    private int id;
    @Column(name="name")
    private String name;
    @Column(name="selfiefilename")
    private String selfiefile;
    @Column(name="bio")
    private String bio;
    @Column(name="genderid")
    private int genderid;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="gender")
    private List<Gender> genders;

    public void add(Gender gender) {
        if (genders == null)
            genders = new ArrayList<>();
        genders.add(gender);
    }


    public List<Gender> getGenders() {
        return genders;
    }

    public void setGenders(List<Gender> genders) {
        this.genders = genders;
    }


    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name="SKILLLEVELS",
            joinColumns = @JoinColumn(name="person_id"),
            inverseJoinColumns = @JoinColumn(name="skillID"))
    private List<Skill> skillList;

    public List<Skill> getSkillList() {
        return skillList;
    }

    public void add(Skill skill){
        if (skillList == null)
            skillList = new ArrayList<>();
        skillList.add(skill);
    }

    public void setSkillList(List<Skill> skillList) {
        this.skillList = skillList;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", selfiefile='" + selfiefile + '\'' +
                ", bio='" + bio + '\'' +
                ", genderid='" + genderid + '\'' +
                '}';
    }

    public Person(){
        // no arg constructor
    }
    public Person(String name, String selfiefile, String bio, int genderid) {
        this.name = name;
        this.selfiefile = selfiefile;
        this.bio = bio;
        this.genderid = genderid;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSelfiefile() {
        return selfiefile;
    }

    public void setSelfiefile(String selfiefile) {
        this.selfiefile = selfiefile;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public int getGenderid() {
        return genderid;
    }

    public void setGenderid(int genderid) {
        this.genderid = genderid;
    }
}
