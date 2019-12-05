package FinalProject.service;

import FinalProject.hibernate.entity.Skill;

import java.util.List;

public interface SkillService {
    List<Skill> getSkills();

    void saveSkill(Skill theSkill);

    Skill getSkill(int theId);

    void deleteSkill(int theId);
}
