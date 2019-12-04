package finalProject.entity;

import hibernate.entity.Person;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="skill")
public class Skill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="skillID")
    private int skillID;
    @Column(name="name")
    private String name;
    @Column(name="level")
    private int level;

    // Given cascade type all because it has to delete from
    // person if one used is deleted
    //Using lazy because its the fastest
    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {CascadeType.ALL})
    @JoinTable(name="SKILLLEVELS",
            joinColumns = @JoinColumn(name="skillID"),
            inverseJoinColumns = @JoinColumn(name="person_id"))
    private List<Person> personList;

    public Skill(){
        //No Arg constructor
    }

    public Skill(String name, int level) {
        this.name = name;
        this.level = level;
    }
    public void setPersonList(List<Person> personList) {
        this.personList = personList;
    }

    public void add(Person person){
        if (personList == null)
            personList = new ArrayList<>();
        personList.add(person);
    }

    public int getSkillID() {
        return skillID;
    }

    public void setSkillID(int skillID) {
        this.skillID = skillID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    @Override
    public String toString() {
        return "Skill{" +
                "skillID=" + skillID +
                ", name='" + name + '\'' +
                ", level='" + level + '\'' +
                '}';
    }
}
