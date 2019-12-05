package FinalProject.service;

import FinalProject.hibernate.entity.Gender;

public interface GenderService {

    void saveGender(Gender thePerson);

    Gender getGender(int theId);

    void deleteGender(int theId);
}
