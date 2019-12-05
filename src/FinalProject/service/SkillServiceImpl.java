package FinalProject.service;

import FinalProject.dao.SkillDAO;
import FinalProject.hibernate.entity.Skill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class SkillServiceImpl implements  SkillService {
    @Autowired
    private SkillDAO skillDAO;

    @Override
    @Transactional
    public List<Skill> getSkills() {
        return skillDAO.getSkills();
    }

    @Override
    public void saveSkill(Skill theSkill) {
        skillDAO.saveSKill(theSkill);
    }

    @Override
    public Skill getSkill(int theId) {
        return skillDAO.getSkill(theId);
    }

    @Override
    public void deleteSkill(int theId) {
        skillDAO.deleteSkill(theId);
    }
}
