package FinalProject.service;

import FinalProject.hibernate.entity.Gender;

import java.util.List;

public interface GenderService {

    void saveGender(Gender theGender);
    List<Gender> listGenders();

    Gender getGender(int theId);

    void deleteGender(int theId);
}
