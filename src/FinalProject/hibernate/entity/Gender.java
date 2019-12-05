package FinalProject.hibernate.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="gender")
public class Gender {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="genderId")
    private int id;
    @Column(name="gender")
    private String gender;
// If deleted it should delete in person also
    @OneToMany(mappedBy = "gender",
            cascade = CascadeType.ALL)
    private List<Person> personList;

    public Gender(){
        // no arg constructor
    }
    public Gender(String gender) {
        this.gender = gender;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Gender{" +
                "id=" + id +
                ", gender='" + gender + '\'' +
                '}';
    }
}
