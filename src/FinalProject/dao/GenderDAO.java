package FinalProject.dao;


import FinalProject.hibernate.entity.Gender;

public interface GenderDAO {

    Gender getGender(int genderId);

    void saveGender(Gender theGender);

    void deleteGender(int genderID);

}
