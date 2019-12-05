package service;

import hibernate.entity.Gender;

import java.util.List;

public interface GenderService {

    void saveGender(Gender thePerson);

    Gender getGender(int theId);

    void deleteGender(int theId);
}
