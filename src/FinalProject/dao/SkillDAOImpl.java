package FinalProject.dao;

import FinalProject.hibernate.entity.Skill;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SkillDAOImpl implements  SkillDAO {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void saveSKill(Skill theSKill) {
        Session session = sessionFactory.getCurrentSession();

        session.saveOrUpdate(theSKill);
    }

    @Override
    public Skill getSkill(int skillId) {
        Session session = sessionFactory.getCurrentSession();

        return session.get(Skill.class, skillId);
    }

    @Override
    public void deleteSkill(int theId) {
        Session session = sessionFactory.getCurrentSession();

        // Delete object using primary key
        Query query = session.createQuery("delete from Skill where id = :doomedSkillId");
        // Set parameter value
        query.setParameter("doomedSkillId", theId);

        // Perform the delete
        query.executeUpdate();
    }

    @Override
    public List<Skill> getSkills() {
        // Get current Hibernate session
        Session session = sessionFactory.getCurrentSession();

        // Get list of donuts from query
        List<Skill> skillList = session.createQuery("from Skill", Skill.class).getResultList();

        // Return results
        return skillList;
    }
}
