package FinalProject.dao;
import java.util.List;
import FinalProject.hibernate.entity.Skill;

public interface SkillDAO {


        void saveSKill(Skill theSKill);
        Skill getSkill(int skillId);
        void deleteSkill(int theId);
        List<Skill> getSkills();

}
