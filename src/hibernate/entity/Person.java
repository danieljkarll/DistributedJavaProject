package hibernate.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="person")
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

    // You dont need to delete any genders just read from it all
    @ManyToOne(cascade = {CascadeType.DETACH,
            CascadeType.MERGE,
            CascadeType.PERSIST,
            CascadeType.REFRESH})
    @JoinColumn(name="genderid")
    private Gender gender;


    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender aGender) {
        this.gender = aGender;
    }


    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {CascadeType.DETACH,
                    CascadeType.MERGE,
                    CascadeType.PERSIST,
                    CascadeType.REFRESH})
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
                '}';
    }

    public Person(){
        // no arg constructor
    }
    public Person(String name, String selfiefile, String bio) {
        this.name = name;
        this.selfiefile = selfiefile;
        this.bio = bio;
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

}
