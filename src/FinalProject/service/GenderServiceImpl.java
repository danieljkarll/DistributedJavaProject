package FinalProject.service;

import FinalProject.dao.GenderDAO;
import FinalProject.hibernate.entity.Gender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class GenderServiceImpl implements GenderService{
    @Autowired
    private GenderDAO genderDAO;

    @Override
    public void saveGender(Gender thePerson) {
        genderDAO.saveGender(thePerson);
    }

    @Override
    @Transactional
    public Gender getGender(int theId) {
        return genderDAO.getGender(theId);
    }

    @Override
    @Transactional
    public void deleteGender(int theId) {
        genderDAO.deleteGender(theId);
    }
}
