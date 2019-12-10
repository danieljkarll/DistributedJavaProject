package FinalProject.dao;


import FinalProject.hibernate.entity.Gender;

import java.util.List;

public interface GenderDAO {

    Gender getGender(int genderId);

    void saveGender(Gender theGender);

    void deleteGender(int genderID);
    List<Gender> getGenders();

}
